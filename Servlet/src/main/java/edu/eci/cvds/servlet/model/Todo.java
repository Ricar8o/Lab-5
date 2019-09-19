package edu.eci.cvds.servlet.model;


public class Todo{
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public Todo(){
	}
	
	public int getUserId(){
		return userId;
	}
	
	public int getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public boolean getCompleted(){
		return completed;
	}
	
	public void setUserId(int n){
		userId = n;
	}
	
	public void setId(int n){
		id = n;
	}
	
	public void setTitle(String s){
		title = s;
	}
	
	public void setCompleted(boolean b){
		completed = b;
	}

}