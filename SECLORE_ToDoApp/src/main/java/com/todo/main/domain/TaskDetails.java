package com.todo.main.domain;

public class TaskDetails {
	private int taskId;
	private UserDetails userDetails;
	private String title;
	private String description;
	private String status;
	public TaskDetails() {
		// TODO Auto-generated constructor stub
	}
	public TaskDetails(int taskId, UserDetails userDetails, String title, String description, String status) {
		super();
		this.taskId = taskId;
		this.userDetails = userDetails;
		this.title = title;
		this.description = description;
		this.status = status;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TaskDetails [taskId=" + taskId + ", userDetails=" + userDetails + ", title=" + title + ", description="
				+ description + ", status=" + status + "]";
	}
	
}
