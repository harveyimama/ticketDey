package com.ticket.park.jersey.responses;

import javax.xml.bind.annotation.XmlRootElement;

import com.ticket.park.dto.ChargeTypeDto;
import com.ticket.park.dto.UserDto;
import com.ticket.park.enums.ChargeTypeEnum.ChargeType;
import com.ticket.park.enums.DiscountTypeEnum.DiscountType;

import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="ChargeResponse")

public class ChargeResponse extends ServiceResponse 
{
	private String id,charge_type_id,amount, agent_amount,dealer_amount;
	private String guest_start_ranege,guest_end_ranege,crt_dt;
	private ChargeType dealer_commision_type,agent_commision_type;
	private UserDto user_id;
	private String featureLevel;

	
	public ChargeResponse()
	{}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCharge_type_id() {
		return charge_type_id;
	}


	public void setCharge_type_id(String charge_type_id) {
		this.charge_type_id = charge_type_id;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getAgent_amount() {
		return agent_amount;
	}


	public void setAgent_amount(String agent_amount) {
		this.agent_amount = agent_amount;
	}


	public String getDealer_amount() {
		return dealer_amount;
	}


	public void setDealer_amount(String dealer_amount) {
		this.dealer_amount = dealer_amount;
	}


	public String getGuest_start_ranege() {
		return guest_start_ranege;
	}


	public void setGuest_start_ranege(String guest_start_ranege) {
		this.guest_start_ranege = guest_start_ranege;
	}


	public String getGuest_end_ranege() {
		return guest_end_ranege;
	}


	public void setGuest_end_ranege(String guest_end_ranege) {
		this.guest_end_ranege = guest_end_ranege;
	}


	public String getCrt_dt() {
		return crt_dt;
	}


	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}


	public ChargeType getDealer_commision_type() {
		return dealer_commision_type;
	}


	public void setDealer_commision_type(ChargeType dealer_commision_type) {
		this.dealer_commision_type = dealer_commision_type;
	}


	public ChargeType getAgent_commision_type() {
		return agent_commision_type;
	}


	public void setAgent_commision_type(ChargeType agent_commision_type) {
		this.agent_commision_type = agent_commision_type;
	}


	public UserDto getUser_id() {
		return user_id;
	}


	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}


	public String getFeatureLevel() {
		return featureLevel;
	}


	public void setFeatureLevel(String featureLevel) {
		this.featureLevel = featureLevel;
	}


	
	
	
}
