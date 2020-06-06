package com.main;

import com.interFace.UserDao;
import com.interFace.UserDaoImpl;

public class FetchUsers {

	public static void main(String[] args) {
		try {
			UserDao userDao=new UserDaoImpl();
			userDao.fetchAll().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
