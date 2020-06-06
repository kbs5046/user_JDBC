package com.dao.query;

public interface SQLQuery {
	public static String UPDATE_USERS = "update Users set UserName = ?, Password = ? where Name=?";
	public static String DELETE_BY_NAME = "delete from USERS where Name = ?";
	
	public static String SELECT_SIGNUP_USERNAME_PASSWORD = "select UserName,Password,Name,Email,Salutation,DateCreated from Users where UserName=? and Password=? ";
	public static String ADD_USER = "insert into USERS(UserName,Password,Name,Email,Salutation) values(?,?,?,?,?)";
	public static String SELECT_ALL_USERS = "select * from Users";
}
