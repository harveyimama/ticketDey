package com.ticket.park.dto;

public class EventTypeDto {
	
	private String id,event_type_name,event_type_description,fee_frequency,crt_dt;
	private ChargeTypeDto charge_type_id;
	private DiscountDto discount;
	private UserDto user_id;
	
	
	public EventTypeDto(String id, String event_type_name, String event_type_description, String fee_frequency,
			String crt_dt, ChargeTypeDto charge_type_id, UserDto user_id,DiscountDto discount) {
		super();
		this.id = id;
		this.event_type_name = event_type_name;
		this.event_type_description = event_type_description;
		this.fee_frequency = fee_frequency;
		this.crt_dt = crt_dt;
		this.charge_type_id = charge_type_id;
		this.user_id = user_id;
		this.discount = discount;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getEvent_type_name() {
		return event_type_name;
	}


	public void setEvent_type_name(String event_type_name) {
		this.event_type_name = event_type_name;
	}


	public String getEvent_type_description() {
		return event_type_description;
	}


	public void setEvent_type_description(String event_type_description) {
		this.event_type_description = event_type_description;
	}


	public String getFee_frequency() {
		return fee_frequency;
	}


	public void setFee_frequency(String fee_frequency) {
		this.fee_frequency = fee_frequency;
	}


	public String getCrt_dt() {
		return crt_dt;
	}


	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}


	public ChargeTypeDto getCharge_type_id() {
		return charge_type_id;
	}


	public void setCharge_type_id(ChargeTypeDto charge_type_id) {
		this.charge_type_id = charge_type_id;
	}


	public UserDto getUser_id() {
		return user_id;
	}


	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}


	public DiscountDto getDiscount() {
		return discount;
	}


	public void setDiscount(DiscountDto discount) {
		this.discount = discount;
	}
	
	
	
	
	

}
