package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.WordDao;

import com.db.DBUtils;
import com.pojo.Word;

public class WordDaoImpl implements WordDao{

	@Override
	public int add(Word obj) {
		Connection conn = new DBUtils().getConnection();
		String sql = "insert into Word(word_name,word_translate) values(?,?)";
		PreparedStatement psmt = null;
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getWord_name());
			psmt.setString(2, obj.getWord_translate());
			update = psmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return update;
	}

	@Override
	public int update(Word obj) {
		int update = 0;
		String sql="update word set word_name = ?,word_translate = ? where word_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getWord_name());
			psmt.setString(2, obj.getWord_translate());
			psmt.setInt(3, obj.getWord_id());
			update = psmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public int delete(int id) {
		int update = 0;
		String sql=" delete from word where word_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			update = psmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public List<Word> queryAll() {
		Word word = null;
		String sql="select * from word";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		List<Word> wordlist = new ArrayList<Word>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				word = new Word();
				word.setWord_id(rs.getInt("word_id"));
				word.setWord_name(rs.getString("word_name"));
				word.setWord_translate(rs.getString("word_translate"));
				wordlist.add(word);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wordlist;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Word> queryPage(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Word queryObject(int id) {
		Word word = null;
		String sql="select * from word where word_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()){
				word = new Word();
				word.setWord_id(rs.getInt("word_id"));
				word.setWord_name(rs.getString("word_name"));
				word.setWord_translate(rs.getString("word_translate"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return word;
	}

	@Override
	public Word queryWord(String word_name) {
		// TODO Auto-generated method stub
		Word word = null;
		String sql="select * from Word where word_name = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, word_name);
			rs = psmt.executeQuery();
			while(rs.next()){
				word = new Word();
				word.setWord_id(rs.getInt("word_id"));
				word.setWord_name(rs.getString("word_name"));
				word.setWord_translate(rs.getString("word_translate"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			rs.close();
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return word;
	}

}
