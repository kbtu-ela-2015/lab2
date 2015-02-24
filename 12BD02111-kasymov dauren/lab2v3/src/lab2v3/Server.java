package lab2v3;

	import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Scanner;

	import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;


public class Server {
	  public static void main(String[] args) throws Exception {
	    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	    System.out.println("server startted");
	    
	    
	    System.out.println("Enter any number to close server:");
	    server.createContext("/", new InfoHandler());
	    server.createContext("/get", new GetHandler());
	    server.setExecutor(null); // creates a default executor
	    server.start();
	    
	    Scanner sc= new Scanner(System.in);
	    sc.next();
	    sc.close();
	    
	    server.stop(0);
	    System.out.println("server closed");
	  }

	  static class InfoHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {
	      String response;// = "<html><i>Use /get to download a PDF</i></html>";
//	      t.sendResponseHeaders(200, response.length());
	      
//	      URI uri=t.getRequestURI();//ok
//	      String s=uri.getAuthority();
//	      System.out.println(uri.toString());
	      //System.out.println(uri.getAuthority());
	      //System.out.println(uri.getFragment());
	      //System.out.println(uri.getHost());
//	      System.out.println(uri.getPath());//ok
//	      System.out.println(uri.getQuery());//ok
	    //create controller pass URI object
	      //return response string 
	      
	      Controller c= new Controller();
	      response=c.getResponse(t);
	      if(response==null)
	    	  response = "<html><i>no data received</i></html>";
	      t.sendResponseHeaders(200, response.length());
	      
	      OutputStream os = t.getResponseBody();
	      os.write(response.getBytes());
	      System.out.println("request handled info");
	      os.close();
	    }
	  }

	  static class GetHandler implements HttpHandler {
	    public void handle(HttpExchange t) throws IOException {

	      // add the required response header for a PDF file
	     // Headers h = t.getResponseHeaders();
	      //h.add("Content-Type", "application/pdf");
	    	
	    	
	    	
	      // a actions
	    	//Controller c= new Controller();
	    	
	    	
	      File file = new File ("index.html");
	      if(!file.exists()){
	    	  System.out.println("no file");
	    	  
	    	  
	      }
	      byte [] bytearray  = new byte [(int)file.length()];
	      FileInputStream fis = new FileInputStream(file);
	      BufferedInputStream bis = new BufferedInputStream(fis);
	      bis.read(bytearray, 0, bytearray.length);

	      // ok, we are ready to send the response.
	      t.sendResponseHeaders(200, file.length());
	      OutputStream os = t.getResponseBody();
	      
	      os.write(bytearray,0,bytearray.length);
	      System.out.println("request handled");
	      os.close();
	      bis.close();
	    }
	  }
	}