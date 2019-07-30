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

import com.admin.register.model.AdminLogin;
import com.admin.register.service.AdminLoginService;

@Controller
public class AdminLoginController {

	private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	@Autowired
	AdminLoginService service;

	@RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
	@ResponseBody
	public List<AdminLogin> getAdmin() {
		logger.debug("Trying to retreieve admin details...");
		List<AdminLogin> adminLogins = service.getAdmin();
		logger.debug("Successfully fetched the details of admin...");
		return adminLogins;
	}

	@RequestMapping(value = "/getOneAdmin", method = RequestMethod.GET)
	@ResponseBody
	public AdminLogin getOneAdmin(@RequestParam int adminId, String password) {
		logger.info("Trying to fetch the single admin from UI...");
		AdminLogin adminLogin = service.getOneAdmin(adminId, password);
		logger.info("Row fetched successfully...");
		return adminLogin;
	}
	
	@RequestMapping(value = "/getAdminById", method = RequestMethod.GET)
	@ResponseBody
	public AdminLogin getAdminById(@RequestParam int adminId) {
		logger.info("Trying to fetch the single admin from UI...");
		AdminLogin adminLogin = service.getAdminById(adminId);
		logger.info("Row fetched successfully...");
		return adminLogin;
	}

	@RequestMapping(value = "/insertAdmin", method = RequestMethod.POST)
	@ResponseBody
	public AdminLogin insertAdmin(@RequestBody AdminLogin adminLogin) {
		logger.info("Hitting the service method for inserting new admin...");
		return service.insertUser(adminLogin);
	}

	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAdmin(@RequestParam int adminId) {
		logger.info("Deletion of record initiated....");
		service.deleteUser(adminId);
		return "Success....";

	}

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.PUT)
	@ResponseBody
	public AdminLogin updateAdmin(@RequestBody AdminLogin adminLogin) {
		logger.info("Calling updateAdmin method in services...");
		return service.updateAdmin(adminLogin);
	}
}
