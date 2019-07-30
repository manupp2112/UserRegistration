package com.admin.register.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.admin.register.model.AdminLogin;

public class AdminLoginRowmapper implements RowMapper<AdminLogin>{

	@Override
	public AdminLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
	    AdminLogin adminLogin = new AdminLogin();
	    adminLogin.setAdminId(rs.getInt("User_id"));
	    adminLogin.setUsername(rs.getString("UserName"));
	    adminLogin.setPassword(rs.getString("Password"));
		return adminLogin;
	}

}
