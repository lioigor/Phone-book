package com.lioigor22.repositories.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonFileDAO<E> implements FileDAO<E> {

	private static final Logger logger = LoggerFactory.getLogger(JsonFileDAO.class);

	private static ObjectMapper mapper = new ObjectMapper();
	private File file;
	private static String workingDirectory = System.getProperty("user.dir");
	private InputStream inputStream;

	public JsonFileDAO() {

	}

	private void init(String pathFile) {

		file = new File(workingDirectory + "/src/main/resources" + pathFile);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

		} catch (IOException io) {
			logger.error(io.getMessage());
		}

		try {
			inputStream = new FileInputStream(file);

		} catch (FileNotFoundException nf) {
			logger.error("File " + file.getName() + " not found! Info: " + nf.getMessage());
		}

	}

	private void closeStream() {

		try {
			if (inputStream != null)
				inputStream.close();

		} catch (IOException e) { // closing quietly

			logger.error("Closing input stream file " + file.getName() + ". Info: " + e.getMessage());
		}

	}

	@Override
	public List<E> read(String pathFile, Class<E> myClass) {

		init(pathFile);

		try {
			// objects = mapper.readValue(inputStream, typeReference);
			List<E> objects = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, myClass));

			closeStream();
			return objects;

		} catch (IOException e) {
			logger.error("Can not read file " + file.getName() + ". Info: " + e.getMessage());
		}

		closeStream();

		return new ArrayList<>();
	}

	/**
	 * Write to Json file, need to update all the file with old data and new
	 * data (It's very slow, but it temporary solution)
	 * 
	 * @param Object
	 *            - method write any type
	 *
	 */
	@Override
	public void write(String pathFile, E object, Class<E> myClass) {

		init(pathFile);

		List<E> oldData = new ArrayList<>();
		oldData.addAll(read(pathFile, myClass));

		oldData.add(object); // final data

		try {

			// Convert object to JSON string and save into file directly
			mapper.writeValue(file, oldData);

		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException occurred during to call method write()." + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException occurred during to call method write()." + e.getMessage());
		} catch (IOException e) {
			logger.error("IOException occurred during to call method write()." + e.getMessage());
		}
	}

	@Override
	public void writeWithReplace(String pathFile, List<E> objects) {

		init(pathFile);

		try {

			// Convert object to JSON string and save into file directly
			mapper.writeValue(file, objects);

		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException occurred during to call method writeWithReplace()." + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException occurred during to call method writeWithReplace()." + e.getMessage());
		} catch (IOException e) {
			logger.error("IOException occurred during to call method writeWithReplace()." + e.getMessage());
		}
	}

}
