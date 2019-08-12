package com.dao;

import java.util.List;

import com.pojo.Ques_lib;

public interface QuesDao extends BaseDao<Ques_lib>{
	Ques_lib queryQues(int level_id);
	String queryLevel_name(int level_id);
}
