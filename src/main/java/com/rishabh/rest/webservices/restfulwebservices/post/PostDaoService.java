package com.rishabh.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class PostDaoService {
	
	private static List<Post> posts = new ArrayList<>(); 
	
	private static int postsCount = 4;

	static {
		 posts.add(new Post(1, "My First Post", "About me", new Date(), 1));		
		 posts.add(new Post(2, "My Last Post", "About me", new Date(), 1));		
		 posts.add(new Post(3, "My Second Post", "About me", new Date(), 1));		
		 posts.add(new Post(4, "My Third Post", "About me", new Date(), 1));		
	}
	
	public Post createPost(Post post) {
		++postsCount;
		posts.add(post);
		return post;
	}
	
	public Post fetchPost(int userId, int postId) {
		for(Post p:posts) {
			if(p.getPostId() == postId && p.getUserId() == userId) {
				return p;
			}
		}
		return null;
	}
	
	public List<Post> fetchAllUserPosts(int userId) {
		List<Post> postsToReturn = new ArrayList<>();
		for(Post p:posts) {
			if( p.getUserId() == userId) {
				postsToReturn.add(p);
			}
		}
		return postsToReturn;
	}

	public int getPostsCount() {
		return postsCount;
	}
	
	public List<Post> getAllPosts() {
		return posts;
	}


	
}
