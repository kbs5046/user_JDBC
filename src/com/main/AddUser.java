package com.main;

import java.util.Scanner;
import com.dao.entity.UserEntity;
import com.interFace.UserDao;
import com.interFace.UserDaoImpl;

public class AddUser {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the New UserName:\t\n");
		String userName = input.next();
		System.out.print("Enter the new Password:\t\n");
		String password = input.next();
		System.out.print("Enter the name:\t\n");
		String name = input.next();
		System.out.print("Enter the Emai:\t\n");
		String email = input.next();
		System.out.print("Enter the salutation:\t\n");
		String salutation = input.next();	
		input.close();
		try {
			UserDao user = new UserDaoImpl();		
			user.fetchAll().forEach(System.out::println);
			UserEntity entity = new UserEntity(0,userName,password,name,email,salutation,null);
			user.addUser(entity);
			System.out.println("Record is add");
			System.out.println("Now new status");
			user.fetchAll().forEach(System.out::println);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
