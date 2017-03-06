package com.mkyong.web.Dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mkyong.web.Dao.MongoDBDao;



public class MongDBDaoImpl<K extends Serializable, T> implements MongoDBDao<K, T> {
	@Autowired
    protected MongoOperations mongoOperation;

    protected Class<T> entityClass;

    /** Default Constructor */
    @SuppressWarnings("unchecked")
    public MongDBDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return mongoOperation.findAll(entityClass);
	}
	

	@Override
	public List<T> findAllCollection(String collection) {
		// TODO Auto-generated method stub
		return mongoOperation.findAll(entityClass, collection);
	}
	
	public T findById(Serializable key) {
		// TODO Auto-generated method stub
		return mongoOperation.findById(key, entityClass);
	}

	public void update(T obj) {
		// TODO Auto-generated method stub
		mongoOperation.save(obj);

	}

	public void saveOrUpdate(T obj) {
		this.update(obj);

	}

	public void delete(T obj) {
		mongoOperation.remove(obj);
	}

	public void save(T obj) {
		// TODO Auto-generated method stub
		mongoOperation.save(obj);
	}

}
