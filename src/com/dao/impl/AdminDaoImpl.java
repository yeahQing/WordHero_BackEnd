package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDao;
import com.db.DBUtils;
import com.pojo.Admin;

public class AdminDaoImpl implements AdminDao{

	@Override
	public int add(Admin obj) {
		Connection conn = new DBUtils().getConnection();
		String sql = "insert into admin(admin_name,admin_password) values(?,?)";
		PreparedStatement psmt = null;
		int update = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getAdmin_name());
			psmt.setString(2, obj.getAdmin_password());
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
	public int update(Admin obj) {
		int update = 0;
		String sql="update admin set admin_name = ?,admin_password = ? where admin_id = ? ";
		Connection conn = new DBUtils().getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, obj.getAdmin_name());
			psmt.setString(2, obj.getAdmin_password());
			psmt.setInt(3, obj.getAdmin_id());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Admin> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Admin> queryPage(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin queryObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin login(Admin obj) {
		// TODO Auto-generated method stub
				Admin user = null;
				String sql="select * from admin where admin_name = ? ";
				Connection conn = new DBUtils().getConnection();
				PreparedStatement psmt = null;
				ResultSet rs =null;
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, obj.getAdmin_name());
					rs = psmt.executeQuery();
					while(rs.next()){
						user = new Admin();
						user.setAdmin_id(rs.getInt("admin_id"));
						user.setAdmin_name(rs.getString("admin_name"));
						user.setAdmin_password(rs.getString("admin_password"));
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

}
