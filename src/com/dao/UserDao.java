package com.dao;

import java.util.List;

import com.pojo.User;

public interface UserDao extends BaseDao<User>{
	User login(User obj);
	int update_score(int user_id);
	int query_score(int user_id);
	int update_level(int level_id,int user_id);
	User query_userAllData(int user_id);
	List<User> queryUserList();
	int updateUserAllData(User obj);
	int addUser(User obj);
}
