package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.db.DBUtils;
import com.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int add(User obj) {
		Connection conn = new DBUtils().getConnection();
		String sql = "insert into User(username,password) values(?,?)";
		PreparedStatement psmt = null;
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getUsername());
			psmt.setString(2, obj.getPassword());
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
	public int update(User obj) {
		int update = 0;
		String sql="update User set username = ?,password = ?,mobile = ? where user_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getUsername());
			psmt.setString(2, obj.getPassword());
			psmt.setString(3, obj.getMobile());
			psmt.setInt(4, obj.getUser_id());
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
		String sql=" delete from user where user_id = ? ";
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
	public List<User> queryAll() {
		User user = null;
		String sql="SELECT user_id,username,score FROM user ORDER BY score desc";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		List<User> userlist = new ArrayList<User>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setScore(rs.getInt("score"));
				userlist.add(user);
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

		return userlist;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> queryPage(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryObject(int id) {
		User user = null;
		String sql="select * from user where user_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				user.setLevel_id(rs.getInt("level_id"));
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
		return user;
	}

	@Override
	public User login(User obj) {
		// TODO Auto-generated method stub
		User user = null;
		String sql="select * from User where username = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getUsername());
			rs = psmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				user.setLevel_id(rs.getInt("level_id"));
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
		return user;
	}

	@Override
	public int update_score(int user_id) {
		int update = 0;
		String sql="update User set score = score + 1 where user_id = ?; ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user_id);
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
	public int query_score(int user_id) {
		// TODO Auto-generated method stub
		String sql="select score from User where user_id = ?";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		int score = 0;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user_id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				score = rs.getInt("score");
			}
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
		return score;
	}

	@Override
	public int update_level(int level_id,int user_id) {
		int update = 0;
		String sql="update User set level_id = ? where user_id = ?";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, level_id);
			psmt.setInt(2, user_id);
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
	public User query_userAllData(int user_id) {
		User user = null;
		String sql="select * from User where user_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, user_id);
			rs = psmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				user.setLevel_id(rs.getInt("level_id"));
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
		return user;
	}
	
	
	//select user_id,username,password,mobile,score,level_id,level_name FROM user,library_level where user.level_id = library_level.level_id
	@Override
	public List<User> queryUserList() {
		User user = null;
		String sql="select * from user";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		ResultSet rs =null;
		List<User> userlist = new ArrayList<User>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				user.setLevel_id(rs.getInt("level_id"));
				userlist.add(user);
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

		return userlist;
	}

	@Override
	public int updateUserAllData(User obj) {
		int update = 0;
		String sql="update User set username = ?,password = ?,mobile = ?,score = ?,level_id = ? where user_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getUsername());
			psmt.setString(2, obj.getPassword());
			psmt.setString(3, obj.getMobile());
			psmt.setInt(4, obj.getScore());
			psmt.setInt(5, obj.getLevel_id());
			psmt.setInt(6, obj.getUser_id());
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
	public int addUser(User obj) {
		Connection conn = new DBUtils().getConnection();
		String sql = "insert into User(username,password,mobile) values(?,?,?)";
		PreparedStatement psmt = null;
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getUsername());
			psmt.setString(2, obj.getPassword());
			psmt.setString(3, obj.getMobile());
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

}
