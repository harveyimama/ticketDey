package com.ticket.park.jersey.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ticket.park.jersey.responses.ChargeResponse;
import com.ticket.park.jersey.responses.DiscountResponse;
import com.ticket.park.jersey.responses.ListResponse;
import com.ticket.park.jersey.responses.LoginResponse;
import com.ticket.park.jersey.responses.ServiceResponse;
import com.ticket.park.services.ServicesImp;

@Path("/")

public class TicketParkServices implements TicketParkServicesI {

	public TicketParkServices() {
	}

	@POST
	@Produces("application/json")
	@Path("getEventTypes")
	public ListResponse getEventTypes(@FormParam("discountCode") String discountCode) {

		return new ServicesImp().getEventTypes(discountCode); 

	}
	
	
	
	@POST
	@Produces("application/json")
	@Path("getEventTickets")
	public ListResponse getEventTickets(@FormParam("eventId") String eventId,@FormParam("eventCode") String  eventCode,
			@FormParam("discountCode") String discountCode) {

		return new ServicesImp().getEventTickets(eventId,eventCode,discountCode); 

	}
	
	
	@POST
	@Produces("application/json")
	@Path("syncEventTickets")
	public ListResponse syncEventTickets(@FormParam("eventId") String eventId) {

		//return new ServicesImp().syncEventTickets(eventId); 
		
		return null;

	}
	

	@POST
	@Produces("application/json")
	@Path("getDiscount")
	public DiscountResponse getDiscount(@FormParam("discountCode") String discountCode,
			@FormParam("eventType") String eventType) {

		return new ServicesImp().getDiscount(discountCode, eventType);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("getCharges")
	public ListResponse getCharges(
		) {
 
		return new ServicesImp().getCharges();

	}
	
	
	@POST
	@Produces("application/json")
	@Path("getTicketTypes")
	public ListResponse getTicketTypes(
		) {
 
		return new ServicesImp().getTicketTypes();

	}

	
	
	@POST
	@Produces("application/json")
	@Path("getUserTickets")
	public ListResponse getUserTickets(@FormParam("userId") String userId
		) {
 
		return new ServicesImp().getUserTickets(userId);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("getEvents")
	public ListResponse getEvents(@FormParam("eventType") String eventType,
			@FormParam("approvalStatus") String approvalStatus, @FormParam("user") String user,
			@FormParam("code") String code, @FormParam("featureLevel") String featureLevel,
			@FormParam("nameLike") String nameLike) {

		return new ServicesImp().getEvents(eventType, approvalStatus, user, null, featureLevel, nameLike);

	}

	
	@POST
	@Produces("application/json")
	@Path("approveEvent")
	public ServiceResponse approveEvent(@FormParam("eventId") String eventId,
			@FormParam("approvalStatus") String approvalStatus) {

		return new ServicesImp().approveEvent(eventId, approvalStatus);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("updateEventChargeRequest")
	public ServiceResponse updateEventChargeRequest(@FormParam("eventId") String eventId,
			@FormParam("chargeId") String chargeId,@FormParam("userId") String userId) {

		return new ServicesImp().updateEventChargeRequest(eventId, chargeId,userId);

	}
	
	
	
	@POST
	@Produces("application/json")
	@Path("updateEventDiscountRequest")
	public ServiceResponse updateEventDiscountRequest(@FormParam("eventId") String eventId,
			@FormParam("discountId") String discountId,@FormParam("userId") String userId) {

		return new ServicesImp().updateEventDiscountRequest(eventId, discountId,userId);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("updateEventCharge")
	public ServiceResponse updateEventCharge(@FormParam("requestId") String requestId,
			@FormParam("approvalStatus") String approvalStatus,@FormParam("approverId") String approverId) {

		return new ServicesImp().updateEventCharge(requestId, approvalStatus,approverId);

	}
	
	@POST
	@Produces("application/json")
	@Path("updateEventDiscount")
	public ServiceResponse updateEventDiscount(@FormParam("requestId") String requestId,
			@FormParam("approvalStatus") String approvalStatus,@FormParam("approverId") String approverId) {

		return new ServicesImp().updateEventDiscount(requestId, approvalStatus,approverId);

	}
	
	
	
	
	
	@POST
	@Produces("application/json")
	@Path("addEvent")
	public ServiceResponse addEvent(@FormParam("event_name") String event_name,
			@FormParam("event_type_id") String event_type_id, @FormParam("event_date_start") String event_date_start,
			@FormParam("event_date_end") String event_date_end, @FormParam("poster_path") String poster_path,
			@FormParam("customer_care_phone") String customer_care_phone,
			@FormParam("bank_account_no") String bank_account_no, @FormParam("charge_id") String charge_id,
			@FormParam("bank_id") String bank_id, @FormParam("charge_discount_id") String charge_discount_id,
			@FormParam("event_discount_id") String event_discount_id, @FormParam("user_id") String user_id) {

		return new ServicesImp().addEvent(event_name, event_type_id, event_date_start, event_date_end, poster_path,
				customer_care_phone, bank_account_no, charge_id, bank_id, charge_discount_id, event_discount_id,
				user_id);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("updateEvent")
	public ServiceResponse updateEvent(@FormParam("event_name") String event_name,
			@FormParam("event_type_id") String event_type_id, @FormParam("event_date_start") String event_date_start,
			@FormParam("event_date_end") String event_date_end, @FormParam("poster_path") String poster_path,
			@FormParam("customer_care_phone") String customer_care_phone,
			@FormParam("bank_account_no") String bank_account_no, @FormParam("charge_id") String charge_id,
			@FormParam("bank_id") String bank_id, @FormParam("charge_discount_id") String charge_discount_id,
			@FormParam("event_discount_id") String event_discount_id, @FormParam("user_id") String user_id
			, @FormParam("id") String id) {

		return new ServicesImp().updateEvent(event_name, event_type_id, event_date_start, event_date_end, poster_path,
				customer_care_phone, bank_account_no, charge_id, bank_id, charge_discount_id, event_discount_id,
				user_id,id);

	}

	@POST
	@Produces("application/json")
	@Path("addUser")
	public ServiceResponse addUser(@FormParam("email") String email, @FormParam("password") String password,
			@FormParam("phone") String phone, @FormParam("fullname") String fullname,
			@FormParam("usertype_id") String usertype_id,@FormParam("user_id") String user_id) {

		return new ServicesImp().addUser(email, password, phone, fullname, usertype_id,user_id);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("changePassword")
	public ServiceResponse changePassword(@FormParam("email") String email, @FormParam("password") String password,
			@FormParam("newPassword") String newPassword, @FormParam("userId") String userId) {

		return new ServicesImp().changePassword(email, password, newPassword, userId);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("resetPassword")
	public ServiceResponse resetPassword(@FormParam("email") String email,
			@FormParam("newPassword") String newPassword) {

		return new ServicesImp().resetPassword(email, newPassword);

	}
	
	
	
	
	@POST
	@Produces("application/json")
	@Path("forgotPassword")
	public ServiceResponse forgotPassword(@FormParam("email") String email) {

		return new ServicesImp().forgotPassword(email);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("login")
	public LoginResponse login(@FormParam("email") String email,@FormParam("password") String password) {

		return new ServicesImp().login(email,password);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("verifyEmail")
	public ServiceResponse verifyEmail(@FormParam("email") String email,@FormParam("token") String token) {

		return new ServicesImp().verifyEmail(email,token);

	}
	
	
	
	
	@POST
	@Produces("application/json")
	@Path("getAuth")
	public ServiceResponse getAuth(@FormParam("email") String email,@FormParam("password") String password,
			@FormParam("lastToken") String lastToken) {

		return new ServicesImp().getAuth(email,password,lastToken);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("addDealer")
	public ServiceResponse addDealer(@FormParam("email") String email, @FormParam("password") String password,
			@FormParam("phone") String phone, @FormParam("fullname") String fullname,
			@FormParam("isTokenized") String isTokenized,	@FormParam("isPrepaid") String isPrepaid) {

		return new ServicesImp().addDealer(email, password, phone, fullname, isTokenized,isPrepaid);

	}
	
	
	@POST
	@Produces("application/json")
	@Path("addTickets")
	public ServiceResponse addTickets(@FormParam("json") String json) {

		return new ServicesImp().addTickets(json); 

	}
	
	
	@POST
	@Produces("application/json")
	@Path("registerThirdPartyTicket")
	public ServiceResponse registerThirdPartyTicket(@FormParam("ticketId") String ticketId,@FormParam("email") String email,
			@FormParam("phone") String phone,@FormParam("fullName") String fullName) {

		//return new ServicesImp().registerThirdPartyTicket(json); 
		return null;

	}
	
	
	
	@POST
	@Produces("application/json")
	@Path("updateTicket")
	public ServiceResponse updateTicket(@FormParam("event_id") String event_id,@FormParam("ticket_type_id") String ticket_type_id,
			@FormParam("guest_dsicount_id") String guest_dsicount_id,@FormParam("guest_amount") String guest_amount,@FormParam("id") String id) {

		return new ServicesImp().updateTicket(event_id,ticket_type_id,guest_dsicount_id,guest_amount,id);  

	}

}
