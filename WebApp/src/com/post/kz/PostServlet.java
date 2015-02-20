package com.post.kz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    MyPost p = new MyPost();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if(request.getParameter("blog_text")!=null){
			
			p.setPost(request.getParameter("blog_text").toString());
		
	}
	//System.out.println(p.getPost().toString().substring(1,p.getPost().toString().length()-1));
	
	String post = request.getParameter("blog_text");
	p.setPost(post);
	String name = User.getName();
	request.setAttribute("post", p);
	request.setAttribute("name", name);
	//response.sendRedirect("Second.jsp");
	RequestDispatcher view = getServletContext().getRequestDispatcher("/Second.jsp"); 
	view.forward(request,response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(p.getPost().toString().substring(1,p.getPost().toString().length()-1));
			
	}

}
