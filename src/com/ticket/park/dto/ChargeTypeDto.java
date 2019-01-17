package com.ticket.park.dto;


import java.util.List;


import com.ticket.park.enums.ChargeTypeEnum.ChargeType;

public class ChargeTypeDto {
	
	private String id,charge_name,crt_dt;
	private UserDto user_id;
	private ChargeType chargeType;
	private List<ChargeDto> charges;
	
	
	public ChargeTypeDto(String id, String charge_name, String crt_dt, UserDto user_id,
			ChargeType chargeType, List<ChargeDto>  charges) {
		super();
		this.id = id;
		this.charge_name = charge_name;
		this.crt_dt = crt_dt;
		this.user_id = user_id;
		this.chargeType = chargeType;
		this.charges = charges;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	public String getCharge_name() {
		return charge_name;
	}


	public void setCharge_name(String charge_name) {
		this.charge_name = charge_name;
	}


	public String getCrt_dt() {
		return crt_dt;
	}


	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}


	public UserDto getUser_id() {
		return user_id;
	}


	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}


	public ChargeType getChargeType() {
		return chargeType;
	}


	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}


	public List<ChargeDto> getCharges() {
		return charges;
	}


	public void setCharges(List<ChargeDto> charges) {
		this.charges = charges;
	}



	
	
	
	

}
