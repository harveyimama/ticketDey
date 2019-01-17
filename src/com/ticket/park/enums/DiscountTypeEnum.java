package com.ticket.park.enums;

public class DiscountTypeEnum {

	
	public enum DiscountType {
	    EVENT_TYPE(1),EVENT(2),GUEST(3);
		private final int id;
		
		private DiscountType(int id) {
		this.id = id;
		}

		public int getId() {
			return id;
		}
	}
	
	
	public DiscountType setDiscountType(int id)
	{
		DiscountType ct = null;
		if(id==1)
		{
			ct =  ct.EVENT_TYPE;
		}
		else if(id==2)
		{
			ct =  ct.EVENT;
		}
		else
		{
			ct =  ct.GUEST;
		}
		
		
		return ct;
	}
	
}
