package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/")
	public String welcome(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "index";
	}

}
