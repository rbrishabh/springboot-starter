package com.rishabh.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "RB", new Date()));
		users.add(new User(4, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
		users.add(new User(2, "Rob", new Date()));
		
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User u:users) {
			if(u.getId() == id) {
				return u;
			} 
		}
		return null;
	}
	

	public User deleteOne(int id) {
		for(User u:users) {
			if(u.getId() == id) {
				users.remove(id);
			} 
		}
		return null;
	}
	
	
	
 	
}
