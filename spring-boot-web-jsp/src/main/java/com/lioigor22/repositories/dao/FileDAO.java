package com.lioigor22.repositories.dao;

import java.util.List;

public interface FileDAO<E> {

	List<E> read(String pathFile, Class<E> myClass);

	void write(String pathFile, E objects, Class<E> myClass);

	void writeWithReplace(String pathFile, List<E> objects);

}
