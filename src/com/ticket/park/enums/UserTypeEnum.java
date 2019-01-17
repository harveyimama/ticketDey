package com.ticket.park.enums;

import com.ticket.park.enums.ChargeTypeEnum.ChargeType;

public class UserTypeEnum {
	
	
	public enum UserType {
		ADMIN(1),CUSTOMER(2),CUSTOMER_USER(3),APPROVER(4);
		private final int id;
		
		private UserType(int id) {
		this.id = id;
		}
		
		public int getId() {
			return id;
		}
	}
	
	
	public UserType setUserType(int id)
	{
		UserType ut = null;
		if(id==1)
		{
			ut = ut.ADMIN;
		}
		else if (id ==2)
		{
			ut = ut.CUSTOMER;
		}
		else if (id ==4)
		{
			ut = ut.APPROVER;
		}
		else 
		{
			ut = ut.CUSTOMER_USER;
		}
		
		
		
		
		
		return ut;
	}

}
