package com.ticket.park.dto;

import com.ticket.park.enums.UserTypeEnum;
import com.ticket.park.enums.UserTypeEnum.UserType;

public class UserDto {
	
	private String id,email,password,phone,fullname,crt_dt;
	private UserType usertype ;
	private UserDto user_id ;
	
	
	public UserDto(String id, String email, String password, String phone, String fullname, String crt_dt,
			UserType usertype, UserDto user_id) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.fullname = fullname;
		this.crt_dt = crt_dt;
		this.usertype = usertype;
		this.user_id = user_id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getCrt_dt() {
		return crt_dt;
	}


	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}


	public UserType getUsertype_id() {
		return usertype;
	}


	public void setUsertype_id(UserType usertype_id) {
		this.usertype = usertype_id;
	}


	public UserDto getUser_id() {
		return user_id;
	}


	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}
	
	
	

}
