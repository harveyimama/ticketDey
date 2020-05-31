package com.ticket.park.data;

import com.ticket.park.dto.ChargeDto;
import com.ticket.park.dto.EventDto;
import com.ticket.park.dto.EventTicketDto;
import com.ticket.park.dto.EventTypeDto;
import com.ticket.park.enums.TicketTypeEnum.TicketType;

public class DDCategory {
	
	
private  EventTypeDto eventTypeDataHold;
private  ChargeDto chargeTypeDataHold;
private TicketType ticketTypeDataHold;
private EventTicketDto eventTicketDataHold;
private EventDto eventDataHold;	

	
	public DDCategory()
	{}


	public EventTypeDto getEventTypeDataHold() {
		return eventTypeDataHold;
	}


	public void setEventTypeDataHold(EventTypeDto eventTypeDataHold) {
		this.eventTypeDataHold = eventTypeDataHold;
	}


	public ChargeDto getChargeTypeDataHold() {
		return chargeTypeDataHold;
	}


	public void setChargeTypeDataHold(ChargeDto chargeTypeDataHold) {
		this.chargeTypeDataHold = chargeTypeDataHold;
	}


	public TicketType getTicketTypeDataHold() {
		return ticketTypeDataHold;
	}


	public void setTicketTypeDataHold(TicketType ticketTypeDataHold) {
		this.ticketTypeDataHold = ticketTypeDataHold;
	}


	public EventTicketDto getEventTicketDataHold() {
		return eventTicketDataHold;
	}


	public void setEventTicketDataHold(EventTicketDto eventTicketDataHold) {
		this.eventTicketDataHold = eventTicketDataHold;
	}


	public EventDto getEventDataHold() {
		return eventDataHold;
	}


	public void setEventDataHold(EventDto eventDataHold) {
		this.eventDataHold = eventDataHold;
	}








	
	

}
