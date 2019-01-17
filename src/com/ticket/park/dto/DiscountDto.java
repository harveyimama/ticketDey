package com.ticket.park.dto;

import com.ticket.park.enums.ChargeTypeEnum.ChargeType;
import com.ticket.park.enums.DiscountTypeEnum.DiscountType;

public class DiscountDto {
	
	private String id,amount,number_of_transactions,start_date,end_date,crt_dt;
	private ChargeType chargeType;
	private DiscountType discountType;
	private UserDto user_id;
	
	
	
	
	public DiscountDto(String id, String amount, String number_of_transactions, String start_date, String end_date,
			String crt_dt, ChargeType chargeType, DiscountType discountType, UserDto user_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.number_of_transactions = number_of_transactions;
		this.start_date = start_date;
		this.end_date = end_date;
		this.crt_dt = crt_dt;
		this.chargeType = chargeType;
		this.discountType = discountType;
		this.user_id = user_id;
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
	public String getNumber_of_transactions() {
		return number_of_transactions;
	}
	public void setNumber_of_transactions(String number_of_transactions) {
		this.number_of_transactions = number_of_transactions;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getCrt_dt() {
		return crt_dt;
	}
	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}
	public ChargeType getChargeType() {
		return chargeType;
	}
	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	public UserDto getUser_id() {
		return user_id;
	}
	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}
	
	
	
}
