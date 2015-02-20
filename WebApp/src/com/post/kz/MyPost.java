package com.post.kz;

import java.util.Vector;
public class MyPost {
	static Vector<String> arr = new Vector<String>();
	
	public void setPost(String s){
		arr.add(s);
		System.out.println("Success");
	}
	
	public Vector<String> getPost(){
		return arr;
	}

	public static String printPost(){
		//int len = arr.size();
		for(String s: arr){
			return s;
		}
		return null;
	}
	
}
