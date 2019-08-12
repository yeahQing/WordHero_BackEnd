package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.LibraryDao;
import com.db.DBUtils;
import com.pojo.Library;
import com.pojo.Word;


public class LibraryDaoImpl implements LibraryDao{

	@Override
	public int add(Library obj) {
		Connection conn = new DBUtils().getConnection();
		String sql = "insert into library(option_1,option_2,option_3,option_4,level_id) values(?,?,?,?,?,?)";
		PreparedStatement psmt = null;
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, obj.getQues_name());
			psmt.setString(2, obj.getOption_1());
			psmt.setString(3, obj.getOption_2());
			psmt.setString(4, obj.getOption_3());
			psmt.setString(5, obj.getOption_4());
			psmt.setInt(6, obj.getLevel_id());
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
	public int update(Library obj) {
		int update = 0;
		String sql="update word set option_1 = ?,option_2 = ?,option_3 = ?,option_4 = ?,level_id = ? where ques_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, obj.getQues_name());
			psmt.setString(1, obj.getOption_1());
			psmt.setString(2, obj.getOption_2());
			psmt.setString(3, obj.getOption_3());
			psmt.setString(4, obj.getOption_4());
			psmt.setInt(5, obj.getLevel_id());
			psmt.setInt(6, obj.getQues_id());
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
		String sql=" delete from library where ques_id = ? ";
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
	public List<Library> queryAll() {
		Library library = null;
		String sql="select * from library";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		List<Library> librarylist = new ArrayList<Library>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				library = new Library();
				library.setQues_id(rs.getInt("ques_id"));
//				library.setQues_name(rs.getString("ques_name"));	
				library.setOption_1(rs.getString("option_1"));
				library.setOption_2(rs.getString("option_2"));
				library.setOption_3(rs.getString("option_3"));
				library.setOption_4(rs.getString("option_4"));
				library.setLevel_id(rs.getInt("level_id"));
				librarylist.add(library);
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

		return librarylist;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Library> queryPage(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Library queryObject(int id) {
		Library library = null;
		String sql="select * from library where ques_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()){
				library = new Library();
				library.setQues_id(rs.getInt("ques_id"));
//				library.setQues_name(rs.getString("ques_name"));	
				library.setOption_1(rs.getString("option_1"));
				library.setOption_2(rs.getString("option_2"));
				library.setOption_3(rs.getString("option_3"));
				library.setOption_4(rs.getString("option_4"));
				library.setLevel_id(rs.getInt("level_id"));
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
		return library;
	}

	
}
