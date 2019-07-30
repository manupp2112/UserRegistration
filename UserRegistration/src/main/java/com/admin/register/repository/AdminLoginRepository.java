package com.admin.register.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.admin.register.model.AdminLogin;
import com.admin.register.rowmapper.AdminLoginRowmapper;

@Repository
public class AdminLoginRepository {
	private static final Logger logger = LoggerFactory.getLogger(AdminLoginRepository.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<AdminLogin> getAdmin() {
		List<AdminLogin> adList = jdbcTemplate.query("Select * from adminLogin", new AdminLoginRowmapper());
		return adList;
	}

	public AdminLogin getOneAdmin(int adminId, String password) {
		logger.info("Trying to fetch the information of single admin from database... ");
		
		AdminLogin adminLogin = jdbcTemplate.queryForObject("Select * from adminLogin where User_id=? and password=?",
				new Object[] { adminId, password }, new AdminLoginRowmapper());
		logger.info("Fetched a single admin from database... ");
		return adminLogin;
	}

	public AdminLogin getAdminById(int adminId) {
		logger.info("Trying to fetch the information of single admin from database... ");
		AdminLogin adminLogin = jdbcTemplate.queryForObject("Select * from adminLogin where User_id=?",
				new Object[] { adminId}, new AdminLoginRowmapper());
		logger.info("Fetched a single admin from database... ");
		return adminLogin;
	}
	public int insertAdmin(AdminLogin adminLogin) {
		logger.info("Trying to add new admin into database....");
		int result = jdbcTemplate.update("insert into adminlogin values(?,?,?)",
				new Object[] { adminLogin.getAdminId(), adminLogin.getUsername(), adminLogin.getPassword() });
		logger.info("Successfully inserted the new record...");
		return result;
	}

	public int deleteAdmin(int adminId) {
		logger.info("Trying to delete the records from database...");
		int result = jdbcTemplate.update("Delete from adminlogin where User_id=?", new Object[] { adminId });
		logger.info("Successfully deleted the record...{}", adminId);
		return result;
	}

	public int updateAdmin(AdminLogin adminLogin) {
		logger.info("Trying to update the details...");
		int result = jdbcTemplate.update("Update adminlogin SET UserName=?,Password=? where User_id=?",
				new Object[] { adminLogin.getUsername(), adminLogin.getPassword(), adminLogin.getAdminId() });
		logger.info("Updation success...");
		return result;

	}
}
