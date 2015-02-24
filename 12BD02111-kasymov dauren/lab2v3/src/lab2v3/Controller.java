package lab2v3;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import com.sun.net.httpserver.HttpExchange;

public class Controller {
	static Vector<Post> db= new Vector<Post>();
	
	public String getFileName(URI uri){
		String name= uri.getPath();
		name = name.replaceFirst("/", ""); 
		return name;
	}
	
	public HashMap<String, String> getQueryString(URI u){
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
		StringTokenizer st;
		StringTokenizer str;
		
		String ff=u.getQuery();
		/*
		if(ff==null){
		System.out.println(ff);
		return null;
		}
		else
			return ff;
	*/
		if(ff==null){
			System.out.println(ff);
			return null;
			}
			else
			{
		
		st= new StringTokenizer(ff, "&");
		
		if(st.countTokens()>1){
		while(st.hasMoreTokens()){
			String arg1 = st.nextToken();
			String arg2 = st.nextToken();
			

			
			str = new StringTokenizer(arg1, "=");
			String title= str.nextToken();
			String val=str.nextToken();
			
			
			str = new StringTokenizer(arg2, "=");
			String text= str.nextToken();
			String textval=str.nextToken();
			
			
			val=val.replaceAll("\\+", " ");
			textval= textval.replaceAll("\\+", " ");
			
			
			hashmap.put(val, textval);
			
			
			System.out.println(val+ " = "+ textval);
			
		}
		}else{
			str = new StringTokenizer(ff, "=");
			String title= str.nextToken();
			String val=str.nextToken();
			val=val.replaceAll("\\+", " ");
			hashmap.put(title, val);
		
		}
		
		
		
		return hashmap;
			}
	}
	
	


	public String getResponse(HttpExchange t){
		URI uri=t.getRequestURI();//ok
		String filename= getFileName(uri);
		
		//getQueryString(uri);
		if(filename.equals("index.html")){
			View v = new View();
			//String str = v.render();
			return v.render(filename);//str;
			
		}
		
		else if(filename.equals("post.html")){
			HashMap<String, String> qw=getQueryString(uri);
			
			if(qw==null){
				View v =new View();
				//String str = v.render(filename);
				return v.render(filename);
			}else{
				View v =new View();
				DBConnection dbc = new DBConnection();
				for (String key : qw.keySet()) {
					dbc.addPostDB(key, qw.get(key));
				    //System.out.println(key+"="+qw.get(key));
				}
				
				
				//String str = v.render();
				//System.out.println(qw);
				//add to db and redirect to ok page
				return v.render(filename, true);
			}
			
			
			
		}else if(filename.equals("list.html")){
			View v =new View();
			DBConnection dbc = new DBConnection();
			
			db=dbc.readPostDB();
			// two step view
			return v.render(filename, db);
			//return getF(filename);
		}
		else if(filename.equals("show.html")){
			View v = new View();
			// get post title and render it
			HashMap<String, String> qw=getQueryString(uri);
			System.out.println(qw.get("title"));
			
			if(qw==null){
				
				//String str = v.render(filename);
				return v.render("error.html", false);
			}else{
				
				DBConnection dbc = new DBConnection();
		///		String titl;
			///	for (String key : qw.keySet()) {
			///		titl=qw.get(key);
				    //System.out.println(key+"="+qw.get(key));
			///	}
				
				boolean del = dbc.deletePostByTitle(qw.get("title"));
				if(del){
					db=dbc.readPostDB();
					return v.render("list.html", db);
				}
				else
					return v.render("error.html", false);
		}
		}
		else
		{
			//render error page
			View v = new View();
			//String str=v.render();
			return v.render("error.html", false);
		}
		
		
		/*
		try {
			String res=readFile(filename);
			System.out.println(res);
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "null !!!!!!!!!!";
		}*/
	}
	
	
	
	private String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
	
	public String getF(String f){
		
		try {
			String res=readFile(f);
			//System.out.println(res);
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "null !!!!!!!!!!";
		}
	}
	
	
}
