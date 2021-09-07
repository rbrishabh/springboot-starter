package com.rishabh.rest.webservices.restfulwebservices.post;

import java.util.Date;

public class Post {
		
	private int userId;
	private String postName;
	private String postBody;
	private Date postDate;
	private int postId;

	public Post(int userId, String postName, String postBody, Date postDate, int postId) {
		super();
		this.userId = userId;
		this.postName = postName;
		this.postBody = postBody;
		this.postDate = postDate;
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Post [userId=" + userId + ", postName=" + postName + ", postBody=" + postBody + ", postDate=" + postDate
				+ "]";
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	
}
