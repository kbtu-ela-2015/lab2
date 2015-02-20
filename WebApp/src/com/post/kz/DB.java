package com.post.kz;

import java.util.Vector;

public class DB {
	String name;
	String password;
	static Vector<User> users = new Vector<User>();
	
	public DB(){}
	
	public static void signUp(User u){
		//this.name = u.getName();
	//	this.password = u.getPassword();
		users.add(u);
	}
	
	public static boolean signIn(User u){
		User user = new User(u.getName(),u.getPassword());
		if(users.contains(user)){
			return true;
		}
		return false;
	}

}
