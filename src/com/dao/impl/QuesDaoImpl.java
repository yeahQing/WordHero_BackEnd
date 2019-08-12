package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.QuesDao;
import com.db.DBUtils;
import com.pojo.Ques_lib;
import com.pojo.User;

public class QuesDaoImpl implements QuesDao{

	@Override
	public int add(Ques_lib obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Ques_lib obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ques_lib> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ques_lib> queryPage(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ques_lib queryObject(int id) {
		
		return null;
	}

	@Override
	public Ques_lib queryQues(int level_id) {
		Ques_lib ques = null;
		String sql="select * from Library  where level_id = ? ORDER BY RAND() LIMIT 1;";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, level_id);
			rs = psmt.executeQuery();
			while(rs.next()){
				ques = new Ques_lib();
				ques.setQues_id(rs.getInt("ques_id"));
				ques.setQues_name(rs.getString("ques_name"));
				ques.setOption_1(rs.getString("option_1"));
				ques.setOption_2(rs.getString("option_2"));
				ques.setOption_3(rs.getString("option_3"));
				ques.setOption_4(rs.getString("option_4"));
				ques.setLevel_id(rs.getInt("level_id"));
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

		return ques;
	}

	@Override
	public String queryLevel_name(int level_id) {
		
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		String level_name = null;
		String sql = "select level_name from Library_Level where level_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, level_id);
			rs = psmt.executeQuery();
			while(rs.next()){
				level_name = rs.getString("level_name");
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
		
		return level_name;
	}

}
