package com.rishabh.rest.webservices.restfulwebservices.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	@Autowired
	private PostDaoService pds;
	
	@GetMapping(path="/posts")
	public List<Post> getAllPosts(){
		return pds.getAllPosts();
	}
	
	@GetMapping(path="/users/{userId}/posts")
	public List<Post> getAllUserPosts(@PathVariable int userId){
		return pds.fetchAllUserPosts(userId);
	}
	
	@GetMapping(path="/users/{userId}/posts/{postId}")
	public Post getUserPost(@PathVariable int userId, @PathVariable int postId){
		return pds.fetchPost(userId, postId);
	}
	
	@GetMapping(path="/posts/count")
	public int getAllPostsCount() {
		return pds.getPostsCount();
	}
	
	@PostMapping(path="/users/{userId}/posts")
	public Post createPost(@RequestBody Post post, @PathVariable int userId) {
		post.setUserId(userId);
		return pds.createPost(post);
	}
	
}
