package lab2v3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

public class View {

	public String render(String fname){
		
		String strfile = getF(fname);
		
		
		return strfile;
	}
	
public String render(String fname, boolean t){
		
		String strfile = getF(fname);
		if(t){
			String note= getF("postadded.html");
			strfile= strfile.replaceFirst("@note", note);
		}else {
			strfile = strfile.replaceFirst("@content", getF("errormsg.html"));
		}
		
		return strfile;
	}
	

public String render(String fname, Vector<Post> d){
	String resp= getF(fname);
	String fullList="";
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	for(int i=0; i<d.size(); i++){
		String list = getF("listcontent.html");
		list=list.replaceAll("@title", d.get(i).getTitle());
		list=list.replaceFirst("@text", d.get(i).getText());
		list=list.replaceFirst("@date", dateFormat.format(d.get(i).getDate()));
		fullList+=list;
	}
	
	resp= resp.replaceFirst("@content", fullList);
	
	
	return resp;
}

public String render(String fname, Post p){
	
	
	
	return null;
	
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
