package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
}


