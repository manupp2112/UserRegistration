package com.admin.register.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.register.model.RegistrationPage;
import com.admin.register.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);
	
	@Autowired
	UserRegistrationRepository repository;

	public List<RegistrationPage> getUser() {
		logger.info("Fetching user info from repository...");
		List<RegistrationPage> registrationPages = repository.getUser();
		logger.info("User details fetched from repository...");
		return registrationPages;
	}
	
	public RegistrationPage getOneUser(int userId) {
		logger.info("Fetching single user info from repository...");
		if(userId !=0)
		return repository.getOneUser(userId);	
		else
			return null;
	}
	public RegistrationPage insertUser(RegistrationPage registrationPage) {
		logger.info("Insertion of a new user calling repository...");
		if (repository.insertUser(registrationPage) > 0) 
			return registrationPage ;
			else
				return null;
		}
	public RegistrationPage updateUser(RegistrationPage registrationPageToUpdate) {
		logger.info("Update the user details calling updateUser repository...");
		RegistrationPage registrationPage = this.getOneUser(registrationPageToUpdate.getUserId());
		if(registrationPageToUpdate.getUserName()!=null)
			  registrationPage.setUserName(registrationPageToUpdate.getUserName());
			  if(registrationPageToUpdate.getPhoneNum()!=null)
			  registrationPage.setPhoneNum(registrationPageToUpdate.getPhoneNum());
			  if(registrationPageToUpdate.getDob()!=null)
			  registrationPage.setDob(registrationPageToUpdate.getDob());
			  if(registrationPageToUpdate.getGender()!=null)
			  registrationPage.setGender(registrationPageToUpdate.getGender());
			  if(registrationPageToUpdate.getCity()!=null)
			  registrationPage.setCity(registrationPageToUpdate.getCity());
			  if(registrationPageToUpdate.getPincode()!=0)
			  registrationPage.setPincode(registrationPageToUpdate.getPincode());
		repository.updateUser(registrationPage);
		logger.info("Updated the details...");
			return registrationPage;
			}
	public int deleteUser(int userId ) {	
		if(userId!=0)
		return repository.deleteUser(userId);
		else 
			return 0;
	}
	}

