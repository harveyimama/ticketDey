package com.ticket.park.dto;

import com.ticket.park.enums.DiscountTypeEnum.DiscountType;
import com.ticket.park.enums.TicketTypeEnum.TicketType;

public class EventTicketDto {
	EventDto event;
	TicketType ticketType;
	DiscountType discountType;
	String id,amount;
	
	
	public EventTicketDto(EventDto event, TicketType ticketType, DiscountType discountType, String id,
			String amount) {
		super();
		this.event = event;
		this.ticketType = ticketType;
		this.discountType = discountType;
		this.id = id;
		this.amount = amount;
	}


	public EventDto getEvent() {
		return event; 
	}


	public void setEvent(EventDto event) {
		this.event = event;
	}


	public TicketType getTicketType() {
		return ticketType;
	}


	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	public DiscountType getDiscountType() {
		return discountType;
	}


	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
