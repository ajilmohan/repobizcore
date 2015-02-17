package com.href.biz.proxy;

import java.io.Serializable;
import java.util.List;

public interface BaseProxy<T extends Serializable> {
	T save(final T entity);
	void delete(final long id);
	void deleteAll();
	T findOne(final long id);
	List< T > findAll();
}
