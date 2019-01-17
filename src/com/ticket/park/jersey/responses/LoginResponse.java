package com.ticket.park.jersey.responses;

import com.ticket.park.dto.UserDto;
import com.ticket.park.enums.UserTypeEnum.UserType;

public class LoginResponse extends ServiceResponse  {
	
	private String id,email,password,phone,fullname,crt_dt;
	private String usertype ;
	private UserDto user_id ;
	
	
	
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

	public UserDto getUser_id() {
		return user_id;
	}
	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	

}
