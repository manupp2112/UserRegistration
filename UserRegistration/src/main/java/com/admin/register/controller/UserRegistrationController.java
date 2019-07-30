package com.admin.register.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admin.register.model.RegistrationPage;
import com.admin.register.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	@Autowired
	UserRegistrationService service;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public List<RegistrationPage> getUsers() {
		logger.info("Trying to retrieve the details of all the users ...");
		List<RegistrationPage> list = service.getUser();
		logger.info("User details fetched for admin...");
		return list;
	}
	
	@RequestMapping(value = "/getOneUser", method = RequestMethod.GET)
	@ResponseBody
	public RegistrationPage getOneUser(@RequestParam int userId) {
		logger.info("Trying to retrieve a user hitting controller... ");
		RegistrationPage regPage = service.getOneUser(userId);
		logger.info("Fetched the data for admin of a single user...");
		return regPage;
	}
	
	@RequestMapping(value = "/insertUser" , method = RequestMethod.POST)
	@ResponseBody
	public RegistrationPage insertUser(@RequestBody RegistrationPage registrationPage) {
		logger.info("Insertion of the user is initiated via controller...");
		return service.insertUser(registrationPage);
		
	}
	@RequestMapping(value="/updateUser" , method = RequestMethod.PUT)
	@ResponseBody
	public RegistrationPage updateUser(@RequestBody RegistrationPage registrationPage) {
		logger.info("Updation of user fields initiating...");
		return service.updateUser(registrationPage);
		
	}
	@RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteUser( @RequestParam int userId) {
		logger.info("Deleting initiated for a user...");
		int result =  service.deleteUser(userId);
		logger.info("Deleted the row from tables...");
		return result;
		
	}
}
