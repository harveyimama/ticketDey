package com.ticket.park.dto;

import com.ticket.park.enums.ChargeTypeEnum.ChargeType;

public class BankDto {
	
	private String id,bank_name,bank_code;

	public BankDto(String id, String bank_name, String bank_code) {
		super();
		this.id = id;
		this.bank_name = bank_name;
		this.bank_code = bank_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	
	
	
		
	
	

}
