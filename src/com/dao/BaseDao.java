package com.dao;

import java.util.List;

public interface BaseDao<E> {
	int add(E obj);
	int update(E obj);
	int delete(int id);
	List<E> queryAll();
	int queryCount();
	List<E> queryPage(int offset,int size);
	E queryObject(int id);
}
