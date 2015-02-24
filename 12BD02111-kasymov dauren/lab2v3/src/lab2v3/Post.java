package lab2v3;

import java.util.Date;

public class Post {
	private int id;
	private String title;
	private String text;
	private Date date;
	
	
	public Post(String title, String text, Date date) {
		super();
		this.title = title;
		this.text = text;
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}



