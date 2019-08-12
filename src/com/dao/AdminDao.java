package com.dao;

import com.pojo.Admin;


public interface AdminDao extends BaseDao<Admin>{
	Admin login(Admin obj);
}
