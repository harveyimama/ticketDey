package com.ticket.park.dto;

public class EventDto {
	
	private String id,event_name,event_date_start,event_date_end,poster_path,approval_status,approver_comment;
	private String customer_care_phone,bank_account_no,crt_dt,eventCode;
	private ChargeDto charge;
	private BankDto bank;
	private EventTypeDto event_type_id;
	private DiscountDto charge_discount,event_discount;
	private UserDto approver_id,user_id;
	
	public EventDto(String id, String event_name, EventTypeDto event_type_id, String event_date_start, String event_date_end,
			String poster_path, String approval_status, String approver_comment, String customer_care_phone,
			String bank_account_no, String crt_dt, ChargeDto charge, BankDto bank, DiscountDto charge_discount,
			DiscountDto event_discount, UserDto approver_id, UserDto user_id,String eventCode) {
		super();
		this.id = id;
		this.event_name = event_name;
		this.event_type_id = event_type_id;
		this.event_date_start = event_date_start;
		this.event_date_end = event_date_end;
		this.poster_path = poster_path;
		this.approval_status = approval_status;
		this.approver_comment = approver_comment;
		this.customer_care_phone = customer_care_phone;
		this.bank_account_no = bank_account_no;
		this.crt_dt = crt_dt;
		this.charge = charge;
		this.bank = bank;
		this.charge_discount = charge_discount;
		this.event_discount = event_discount;
		this.approver_id = approver_id;
		this.user_id = user_id;
		this.eventCode= eventCode;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public EventTypeDto getEvent_type_id() {
		return event_type_id;
	}
	public void setEvent_type_id(EventTypeDto event_type_id) {
		this.event_type_id = event_type_id;
	}
	public String getEvent_date_start() {
		return event_date_start;
	}
	public void setEvent_date_start(String event_date_start) {
		this.event_date_start = event_date_start;
	}
	public String getEvent_date_end() {
		return event_date_end;
	}
	public void setEvent_date_end(String event_date_end) {
		this.event_date_end = event_date_end;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	public String getApprover_comment() {
		return approver_comment;
	}
	public void setApprover_comment(String approver_comment) {
		this.approver_comment = approver_comment;
	}
	public String getCustomer_care_phone() {
		return customer_care_phone;
	}
	public void setCustomer_care_phone(String customer_care_phone) {
		this.customer_care_phone = customer_care_phone;
	}
	public String getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	public String getCrt_dt() {
		return crt_dt;
	}
	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}
	public ChargeDto getCharge() {
		return charge;
	}
	public void setCharge(ChargeDto charge) {
		this.charge = charge;
	}
	public BankDto getBank() {
		return bank;
	}
	public void setBank(BankDto bank) {
		this.bank = bank;
	}
	public DiscountDto getCharge_discount() {
		return charge_discount;
	}
	public void setCharge_discount(DiscountDto charge_discount) {
		this.charge_discount = charge_discount;
	}
	public DiscountDto getEvent_discount() {
		return event_discount;
	}
	public void setEvent_discount(DiscountDto event_discount) {
		this.event_discount = event_discount;
	}
	public UserDto getApprover_id() {
		return approver_id;
	}
	public void setApprover_id(UserDto approver_id) {
		this.approver_id = approver_id;
	}
	public UserDto getUser_id() {
		return user_id;
	}
	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}
	
	
	
	

}
