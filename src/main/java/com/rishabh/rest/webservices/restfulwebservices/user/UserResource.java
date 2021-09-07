package com.rishabh.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

 
@RestController
public class UserResource {
		
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = 	service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable int id){
		User u = service.findOne(id);
		if(u == null) {
			throw new UserNotFoundException("id-"+id);
		}
		return u;
	}	
	
	
	@DeleteMapping(path="/users/{id}")
	public User deleteUserById(@PathVariable int id){
		User u = service.findOne(id);
		if(u == null) {
			throw new UserNotFoundException("id-"+id);
		}
		service.deleteOne(id);
		return u;
	}	
}
