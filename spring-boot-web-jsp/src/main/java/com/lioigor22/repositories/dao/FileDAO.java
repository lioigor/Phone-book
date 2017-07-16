package com.lioigor22.repositories.dao;

import java.util.List;

public interface FileDAO {

	List<Object> read(String pathFile);

	void write(String pathFile, Object object);

}
