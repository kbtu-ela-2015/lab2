package com.post.kz;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class DB {
	String name;
	String password;
	static Vector<User> users = new Vector<User>();
	static HashMap<Date, MyPost> posts = new HashMap<Date, MyPost>();
	
	public DB(){}
	
	public static void signUp(User u){
		users.add(u);
	}
	
	public static String getName(User u){
		return u.getName();
	}
	
	public static boolean signIn(User u){
		User user = new User(u.getName(),u.getPassword());
		if(users.contains(user)){
			return true;
		}
		return false;
	}
	public static int postsCnt(){
		return posts.size();
	}

	public static void setPost(Date d, MyPost p){
		posts.put(d, p);
	}
	
	public static Date getDate(){
			return (Date)posts.keySet();

	}
	
	
}
