package com.dao;

import com.pojo.Word;

public interface WordDao extends BaseDao<Word>{
	Word queryWord(String word_name);
	
}
