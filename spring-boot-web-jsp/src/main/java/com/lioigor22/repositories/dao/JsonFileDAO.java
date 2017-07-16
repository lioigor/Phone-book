package com.lioigor22.repositories.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileDAO implements FileDAO {

	private static final Logger logger = LoggerFactory.getLogger(JsonFileDAO.class);

	private static ObjectMapper mapper = new ObjectMapper();
	private static String workingDirectory = System.getProperty("user.dir");
	private File file;
	private InputStream inputStream;

	public JsonFileDAO() {

	}

	private void init(String pathFile) {

		file = new File(workingDirectory + "/src/main/resources" + pathFile);
		inputStream = TypeReference.class.getResourceAsStream(pathFile);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

		} catch (IOException io) {
			logger.error(io.getMessage());
		}
	}

	@Override
	public List<Object> read(String pathFile) {

		init(pathFile);

		TypeReference<List<Object>> typeReference = new TypeReference<List<Object>>() {
		};

		List<Object> objects;
		try {
			objects = mapper.readValue(inputStream, typeReference);

			return objects;
		} catch (IOException e) {
			logger.error("Can not read file " + file.getName() + ". Info: " + e.getMessage());
		}

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
	public void write(String pathFile, Object object) {

		init(pathFile);

		List<Object> oldData = new ArrayList<>();
		oldData.addAll(read(pathFile));

		oldData.add(object); // final data

		try {

			// Convert object to JSON string and save into file directly
			mapper.writeValue(file, oldData);

		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException occurred during to call method writeJson()." + e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException occurred during to call method writeJson()." + e.getMessage());
		} catch (IOException e) {
			logger.error("IOException occurred during to call method writeJson()." + e.getMessage());
		}
	}

	// public static void main(String[] args) {
	//
	// JsonFileDAO ujs = new JsonFileDAO();
	//
	// // UserDto userDto = new UserDto();
	// // userDto.setId(3);
	// // userDto.setUsername("petro");
	// // userDto.setFullName("kalash");
	// // userDto.setPassword("fgdfgdgdfgd");
	// // RoleDto roleDto = new RoleDto();
	// // roleDto.setName("ROLE_USER");
	// // userDto.setRoleDto(roleDto);
	// //
	// // ujs.write(userDto);
	// //
	// // String workingDirectory = System.getProperty("userDto.dir");
	// // System.out.println(workingDirectory +
	// // "/src/main/resources/json/userDtos.json");
	// //
	// // List<Object> list = new ArrayList<>();
	// // list.addAll(ujs.read());
	//
	// for (Object u : ujs.find()) {
	// System.out.println(u.toString());
	//
	// }
	// }

}
