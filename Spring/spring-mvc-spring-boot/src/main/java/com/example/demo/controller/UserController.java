package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/")
	public String welcome(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "index";
	}

	@GetMapping("/hello")
	public ModelAndView greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		ModelAndView m = new ModelAndView("index");
		m.addObject("name", name);
		return m;
	}

	@GetMapping("/users")
	public String getUsers(ModelMap m) {
		List<User> users = service.getUsers();
		
		m.addAttribute("users",users);
		return "getUsers";
	}

	@PostMapping("/users")
	public ModelAndView createUser(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("role")String role) {
		ModelAndView model = new ModelAndView("addUser");
		User createdUser = service.createUser(id,name,role);
		model.addObject("user", createdUser);
		return model;
	}

	@PutMapping("/users/{userid}")
	public ModelAndView putUser(@RequestParam("userid") Integer id,@RequestParam("name")String name,@RequestParam("role")String role) {
		User user = service.updateUser(id,name,role);
		ModelAndView model = new ModelAndView("updateUser");
		model.addObject("user", user);
		return model;
	}

	@DeleteMapping("users/{usersid}")
	public ModelAndView deleteUser(@RequestParam("userid") Integer id) {
		service.deleteUser(id);
		ModelAndView model = new ModelAndView("deleteUser");
		String msg = "Deleted User with id:" + id;
		model.addObject("msg", msg);
		return model;
	}

}
