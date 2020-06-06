package com.interFace;

import com.dao.entity.UserEntity;
import com.dao.query.SQLQuery;
import com.util.SQLConnectionUtils;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	public List<UserEntity> fetchAll() throws Exception{
		Connection connection = SQLConnectionUtils.getConn();
		PreparedStatement pstmt = connection.prepareStatement(SQLQuery.SELECT_ALL_USERS);
		ResultSet rs = pstmt.executeQuery();
		List<UserEntity> users = new ArrayList<>();
		while(rs.next()) {
			int uId = rs.getInt(1);
			String userName = rs.getString(2);
			String password = rs.getString(3);
			String name = rs.getString(4);
			String email = rs.getString(5);
			String salutation = rs.getString(6);
			Timestamp createdDate  = rs.getTimestamp(7);
			UserEntity entity = new UserEntity(uId,userName,password,name,email,salutation,createdDate);
			users.add(entity);
			
		}
		return users;
		
	}
	
	public String updateUser(UserEntity entity) throws Exception{
		Connection connection = SQLConnectionUtils.getConn();
		PreparedStatement pstmt = connection.prepareStatement(SQLQuery.UPDATE_USERS);	
		pstmt.setString(1,entity.getUserName());
		pstmt.setString(2,entity.getPassword());
		pstmt.setString(3,entity.getName());
		pstmt.execute();
		return "success";
		
	}
	
	public String addUser(UserEntity entity) throws Exception{
		Connection connection = SQLConnectionUtils.getConn();
		PreparedStatement pstmt = connection.prepareStatement(SQLQuery.ADD_USER);	
		pstmt.setString(1,entity.getUserName());
		pstmt.setString(2,entity.getPassword());
		pstmt.setString(3,entity.getName());
		pstmt.setString(4,entity.getEmail());
		pstmt.setString(5,entity.getSalutation());
		pstmt.execute();
		return "success";
	}
	
	public String deleteUser(String name) {
		try{
			Connection connection = SQLConnectionUtils.getConn();		
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.DELETE_BY_NAME);	
			pstmt.setString(1,name);
			pstmt.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
}
