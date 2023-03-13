package com.deborasroka.simpleform.model.dao;

import java.sql.SQLException;

public interface DAO<T> {
	
	
	T searchByID(int id) throws SQLException;
	T searchByEmail(String email) throws SQLException;
	void insert (T t) throws SQLException;
	void update (T t) throws SQLException;
	void delete (T t) throws SQLException;
	
	
}
