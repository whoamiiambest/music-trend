package com.mkyong.web.Dao;

import java.io.Serializable;
import java.util.List;

public interface MongoDBDao<K extends Serializable, T> {
	public List<T> findAll();
	
	public List<T> findAllCollection(String collection);

	public T findById(K key);

	public void save(T obj);

	public void update(T obj);

	public void saveOrUpdate(T obj);

	public void delete(T obj);
}
