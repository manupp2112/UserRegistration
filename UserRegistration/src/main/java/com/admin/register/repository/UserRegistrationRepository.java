package com.admin.register.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.admin.register.model.RegistrationPage;
import com.admin.register.rowmapper.UserRegistrationRowmapper;

@Repository
public class UserRegistrationRepository {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<RegistrationPage> getUser() {
		logger.info("Trying to retrieve user details from database... ");
		List<RegistrationPage> regList = jdbcTemplate.query("Select * from register", new UserRegistrationRowmapper());
		logger.info("User details fetched...");
		return regList;
	}

	public RegistrationPage getOneUser(int userId) {
		logger.info("Trying to retrieve one user at a time....");
		RegistrationPage regPage = jdbcTemplate.queryForObject("Select * from register where User_id=?",
				new Object[] { userId }, new UserRegistrationRowmapper());
		logger.info(" Retrieval of user done  Successfully.... ");
		return regPage;
	}

	public int insertUser(RegistrationPage registrationPage) {
		logger.info("Trying to insert a new user into database... {} ", registrationPage);
		int noOfinsertion = jdbcTemplate.update("insert into register(UserName,PhoneNo,DOB,Gender,City,Pincode) values(?,?,?,?,?,?)",
				new Object[] { registrationPage.getUserName(),
						registrationPage.getPhoneNum(), registrationPage.getDob(), registrationPage.getGender(),
						registrationPage.getCity(), registrationPage.getPincode() });
		logger.info("Insertion of a new user initiated and done...");
		return noOfinsertion;
	}

	
	  public int updateUser(RegistrationPage registrationPage) {  
		  logger.info("Updating the user info.....");
	  int updatedRow = jdbcTemplate.update("Update register SET UserName=?,PhoneNo=?,DOB=?,Gender=?,City=?,Pincode=? where User_Id=?"
	  ,new Object []{registrationPage.getUserName(),registrationPage.getPhoneNum(),
	  registrationPage.getDob(),registrationPage.getGender(),registrationPage.
	  getCity(),registrationPage.getPincode(),registrationPage.getUserId()}) ;
	  logger.info("Updated user info.....");
	  return updatedRow; 
	  }
	  
	  public int deleteUser(int userId) {
		  logger.info("Deleting user from database...");
		  int result = jdbcTemplate.update("Delete from register where User_Id=?",new Object[] {userId});
		  logger.info("Deleted user from database...");
		  return result;
	  }
}