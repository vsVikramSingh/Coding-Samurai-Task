package com.task1;

import java.util.Date;

public class Task {

	private String title;
    private String description;
    private Date dueDate;
    private boolean completed;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Task(String title, String description, Date dueDate, boolean completed) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.completed = completed;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
