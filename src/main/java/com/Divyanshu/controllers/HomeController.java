package com.Divyanshu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee-out-in")
public class HomeController 
{
	@RequestMapping("")
	public String getHomeView()
	{
		return "home/home";
	}
}
