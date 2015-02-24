package lab2v3;

//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//import java.text.SimpleDateFormat;
import java.util.Vector;
import java.io.*;
import java.util.Date;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.StringTokenizer;


public class DBConnection {
	FileOutputStream fos;
	ObjectOutputStream oos;
	private Post post;
//main batabase
	static Vector<Post> db= new Vector<Post>();
//	FileInputStream fis= new FileInputStream("vector.txt");
//	ObjectInputStream ois= new ObjectInputStream(fis);
	
	
	// vector.txt
	public void writeToFile(){
	try{
		fos= new FileOutputStream("vector.txt");
		oos= new ObjectOutputStream(fos);
		oos.writeObject(db);
		try{
			
			fos.close();
			oos.close();
			
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	} catch(IOException e){
		System.out.println(e);
	}
	
	}
	
	public void readFromFile(){
		
	}
	//end
	
	public void addPostDB(String title, String text){
		
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		//System.out.println(dateFormat.format(date)); //2013/10/15 16:16:39
		//int lastId= db.size();
		Post p= new Post(title, text, date);
	
		db.add(p);
		
		
	}


	public Vector<Post> readPostDB() {
		
		return db;
	}
	
	public Post getPostByTitle(String title){
		for(int i=0; i<db.size(); i++){
			if(db.get(i).getTitle().equals(title))
				return db.get(i);
		}
		
		return null;
	}
	
	public boolean deletePostByTitle(String t){
		Post p = getPostByTitle(t);
		return db.remove(p);
		
	}


	
	
	
	
	
}
