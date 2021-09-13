package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public User createUser(Integer id,String name,String role) {
		User user = new User(id,name,role);
		return repository.save(user);
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	public User updateUser(Integer id,String name,String role) {
		User user = repository.getById(id);
		user.setName(name);
		user.setRole(role);
		return repository.save(user);
	}
	
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}
	
}


