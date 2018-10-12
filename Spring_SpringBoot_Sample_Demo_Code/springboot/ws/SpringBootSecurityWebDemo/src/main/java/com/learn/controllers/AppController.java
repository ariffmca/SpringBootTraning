package com.learn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value= {"/","/home"},method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting","Hi, Welcome to SpringBoot Site");
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "adminoperations";
	}
	
	@RequestMapping("/common")
	public String commonPages(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "commonoperations";
	}
	
	@RequestMapping("/Access_Denied")
	public String accessDenied(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessdenied";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler()
			.logout(req, resp, auth);
		}
		return "redirect:/login?logout";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		}else {
			userName = principal.toString();
		}
		return userName;
	}
}