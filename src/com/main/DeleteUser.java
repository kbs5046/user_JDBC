package com.main;

import java.util.Scanner;
import com.interFace.UserDao;
import com.interFace.UserDaoImpl;

public class DeleteUser {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name:\t\n");
		String name = input.next();
		input.close();
		try {
			UserDao user = new UserDaoImpl();		
			user.fetchAll().forEach(System.out::println);
			user.deleteUser(name);
			System.out.println("Record is deleted");
			System.out.println("Now new status");
			user.fetchAll().forEach(System.out::println);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}

	}

}
