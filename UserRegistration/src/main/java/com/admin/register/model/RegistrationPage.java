package com.admin.register.model;

public class RegistrationPage {
	private int userId;
	private String userName;
	private String phoneNum;
	private String dob;
	private String gender;
	private String city;
	private int pincode;

	public RegistrationPage() {
		super();

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "RegistrationPage [userId=" + userId + ", userName=" + userName + ", phoneNum=" + phoneNum + ", dob="
				+ dob + ", gender=" + gender + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
