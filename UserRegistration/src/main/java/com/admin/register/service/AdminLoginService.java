package com.admin.register.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.register.model.AdminLogin;
import com.admin.register.repository.AdminLoginRepository;

@Service
public class AdminLoginService {
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginService.class);
	@Autowired
	AdminLoginRepository repository;

	public List<AdminLogin> getAdmin() {
		logger.info("Trying to hit repository for getting details...");
		List<AdminLogin> adminList = repository.getAdmin();
		logger.info("Successfully received data from repo...");
		return adminList;
	}

	public AdminLogin getOneAdmin(int adminId, String password) {
		logger.info("Trying to hit the repository from service for fetching single adminUSer");
		
		AdminLogin adminLogin = repository.getOneAdmin(adminId, password);
		logger.info("Successfully received the data of single admin user... ");
		return adminLogin;

	}
	public AdminLogin getAdminById(int adminId) {
		logger.info("Trying to hit the repository from service for fetching single adminUSer");
		AdminLogin adminLogin = repository.getAdminById(adminId);
		logger.info("Successfully received the data of single admin user... ");
		return adminLogin;

	}
	

	public AdminLogin insertUser(AdminLogin adminLogin) {
		logger.info("Trying to insert new user in database through repository...");
		if (repository.insertAdmin(adminLogin) > 0)
			return adminLogin;
		else
			return null;
	}

	public int deleteUser(int adminId) {
		logger.info("Trying to hit repo service to get the info...");
		return repository.deleteAdmin(adminId);
	}

	public AdminLogin updateAdmin(AdminLogin adminLoginToUpdate) {
		logger.info("UPdating some fields in database... ");
		AdminLogin adminLogin = this.getAdminById(adminLoginToUpdate.getAdminId());
		if (adminLoginToUpdate.getUsername() != null)
			adminLogin.setUsername(adminLoginToUpdate.getUsername());
		if (adminLoginToUpdate.getPassword() != null)
			adminLogin.setPassword(adminLoginToUpdate.getPassword());

		repository.updateAdmin(adminLogin);
		logger.info("FEtched the details from repo...");
		return adminLogin;

	}
}
