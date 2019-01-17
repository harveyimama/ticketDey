package com.ticket.park.enums;

public class ChargeTypeEnum {

	
	public enum ChargeType {
	    FLAT(1),PERCENT(2);
		private final int id;
		
		private ChargeType(int id) {
		this.id = id;
		}

		public int getId() {
			return id;
		}
	}
	
	
	public ChargeType setChargeType(int id)
	{
		ChargeType ct = null;
		if(id==1)
		{
			ct =  ct.FLAT;
		}
		else
		{
			ct =  ct.PERCENT;
		}
		
		
		return ct;
	}
	
}
