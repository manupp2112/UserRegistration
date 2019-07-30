package com.admin.register.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.admin.register.model.RegistrationPage;

public class UserRegistrationRowmapper implements RowMapper<RegistrationPage> {
private static final Logger logger = LoggerFactory.getLogger(UserRegistrationRowmapper.class);
	@Override
	public RegistrationPage mapRow(ResultSet rs, int rowNum) throws SQLException {
		logger.info("Mapping user details with database...");
		RegistrationPage regPage = new RegistrationPage();
		regPage.setUserId(rs.getInt("User_id"));
		regPage.setUserName(rs.getString("UserName"));
		regPage.setPhoneNum(rs.getString("PhoneNo"));
		regPage.setDob(rs.getString("DOB"));
		regPage.setGender(rs.getString("Gender"));
		regPage.setCity(rs.getString("City"));
		regPage.setPincode(rs.getInt("Pincode"));

		return regPage;
	}

}
