package com.ticket.park.enums;

public class TicketTypeEnum {

	
	public enum TicketType {
	    VIP(1),REGULAR(2);
		private final int id;
		
		private TicketType(int id) {
		this.id = id;
		}

		public int getId() {
			return id;
		}
	}
	
	
	public TicketType setTicketType(int id)
	{
		TicketType ct = null;
		if(id==1)
		{
			ct =  ct.VIP;
		}
		else
		{
			ct =  ct.REGULAR;
		}
		
		
		return ct;
	}
	
}
