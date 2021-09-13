package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}

	// Using Model

	@GetMapping("/model")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model m) {
		m.addAttribute("name", name);
		return "displayname";
	}

	// Using ModelAndView

	@GetMapping("/modelandview")
	public ModelAndView mav(@RequestParam(value = "name", defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("displayname");
		mv.addObject("name", name);
		return mv;
	}

}
