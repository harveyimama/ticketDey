package com.ticket.park.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ticket.park.data.DDCategory;
import com.ticket.park.dto.ChargeDto;
import com.ticket.park.dto.DiscountDto;
import com.ticket.park.dto.EventDto;
import com.ticket.park.dto.EventTicketDto;
import com.ticket.park.dto.EventTypeDto;
import com.ticket.park.dto.UserDto;
import com.ticket.park.enums.TicketTypeEnum.TicketType;
import com.ticket.park.jersey.responses.ChargeResponse;
import com.ticket.park.jersey.responses.DiscountResponse;
import com.ticket.park.jersey.responses.ListResponse;
import com.ticket.park.jersey.responses.LoginResponse;
import com.ticket.park.jersey.responses.ServiceResponse;
import com.ticket.park.models.APIService;
import com.ticket.park.utility.EmailUtil;
import com.ticket.park.utility.Hasher;
import com.ticket.park.utility.PasswordUtil;

public class ServicesImp {

	public ListResponse getEventTypes(String discount_code) {
		ListResponse eventList = new ListResponse();
		APIService modelCall = new APIService();

		try {

			ArrayList list = modelCall.getEventTypes(discount_code);
			EventTypeDto eventTypeListResult = null;

			if (list.size() > 0) {
				List<DDCategory> catList = new ArrayList<DDCategory>();
				for (int i = 0; i < list.size(); i++) {
					eventTypeListResult = (EventTypeDto) list.get(i);
					DDCategory cat = new DDCategory();
					cat.setEventTypeDataHold(eventTypeListResult);
					catList.add(cat);
				}

				eventList.setList(catList);
				eventList.setResponseCode(0);
				eventList.setSuccess(true);
				eventList.setMessage("Great! you have a nice array of events types to choose from");

			} else {
				eventList.setResponseCode(1);
				eventList.setSuccess(false);
				eventList.setMessage("Oops! no event list found at this time, please try again soon");
			}

		} catch (Exception e) {

			eventList.setResponseCode(1);
			eventList.setSuccess(false);
			eventList.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return eventList;

	}
	
	
	public ListResponse getEventTickets(String eventId, String eventCode,String discount_code) {
		ListResponse eventList = new ListResponse();
		APIService modelCall = new APIService();

		try {

			ArrayList list = modelCall.getEventTickets(eventId,eventCode,discount_code);
			EventTicketDto eventTypeListResult = null;

			if (list.size() > 0) {
				List<DDCategory> catList = new ArrayList<DDCategory>();
				for (int i = 0; i < list.size(); i++) {
					eventTypeListResult = (EventTicketDto) list.get(i);
					DDCategory cat = new DDCategory();
					cat.setEventTicketDataHold(eventTypeListResult);
					catList.add(cat);
				}

				eventList.setList(catList);
				eventList.setResponseCode(0);
				eventList.setSuccess(true);
				eventList.setMessage("Great! you have a nice array of events types to choose from");

			} else {
				eventList.setResponseCode(1);
				eventList.setSuccess(false);
				eventList.setMessage("Oops! no event list found at this time, please try again soon");
			}

		} catch (Exception e) {

			eventList.setResponseCode(1);
			eventList.setSuccess(false);
			eventList.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return eventList;

	}

	public ListResponse getEvents(String eventType, String approvalStatus, String user, String code,
			String featureLevel, String nameLike) {
		ListResponse eventList = new ListResponse();
		APIService modelCall = new APIService();

		try {

			ArrayList list = modelCall.getEvents(eventType, approvalStatus, user, code, featureLevel, nameLike);
			EventDto eventListResult = null;

			if (list.size() > 0) {
				List<DDCategory> catList = new ArrayList<DDCategory>();
				for (int i = 0; i < list.size(); i++) {
					eventListResult = (EventDto) list.get(i);
					DDCategory cat = new DDCategory();
					cat.setEventDataHold(eventListResult);  
					catList.add(cat);
				}

				eventList.setList(catList);
				eventList.setResponseCode(0);
				eventList.setSuccess(true);
				eventList.setMessage("Great! you have a nice array of events to choose from");

			} else {
				eventList.setResponseCode(1);
				eventList.setSuccess(false);
				eventList.setMessage("Oops! no event list found at this time, please try again soon");
			}

		} catch (Exception e) {

			eventList.setResponseCode(1);
			eventList.setSuccess(false);
			eventList.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return eventList;

	}
	
	
	
	public ServiceResponse updateEventDiscount(String requestId, String approvalStatus,String approverId	
			) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int msg = modelCall.updateEventDiscount(requestId, approvalStatus,approverId);
		
				if(msg == 0)
				{
				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success, Your request was successfully processed");

			} else if(msg == 1) {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Customers payment has already been made on current charge");
			}
			else
			{
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Oops! system was unable to fulfil request. Please contact admin");
			
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}

	
	public ServiceResponse updateEventCharge(String requestId, String approvalStatus,String approverId	
			) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int msg = modelCall.updateEventCharge(requestId, approvalStatus,approverId);
		
				if(msg == 0)
				{
				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success, Your request was successfully processed");

			} else if(msg == 1) {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Customers payment has already been made on current charge");
			}
			else
			{
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Oops! system was unable to fulfil request. Please contact admin");
			
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}

	
	public ServiceResponse updateEventDiscountRequest(String eventId, String discountId,String userId) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int msg = modelCall.updateEventDiscountRequest(eventId, discountId,userId);
		
				if(msg == 0)
				{
				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success, Your request was successfully processed");

			} 
			else
			{
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Oops! system was unable to fulfil request. Please contact admin");
			
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}

	
	public ServiceResponse updateEventChargeRequest(String eventId, String chargeId,String userId) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int msg = modelCall.updateEventChargeRequest(eventId, chargeId,userId);
		
				if(msg == 0)
				{
				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success, Your request was successfully processed");

			} 
			else
			{
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Oops! system was unable to fulfil request. Please contact admin");
			
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	public ServiceResponse approveEvent(String eventId, String approvalStatus) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int msg = modelCall.approveEvent(eventId, approvalStatus);
		
				if(msg == 0)
				{
				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success, Your request was successfully processed");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Oops! system was unable to fulfil request. Please contact admin");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}


	
	public ListResponse getUserTickets(String userId) {
		ListResponse eventList = new ListResponse();
		APIService modelCall = new APIService();

		try {

			ArrayList list = modelCall.getUserTickets(userId);
			EventTicketDto eventTypeListResult = null;

			if (list.size() > 0) {
				List<DDCategory> catList = new ArrayList<DDCategory>();
				for (int i = 0; i < list.size(); i++) {
					eventTypeListResult = (EventTicketDto) list.get(i);
					DDCategory cat = new DDCategory();
					cat.setEventTicketDataHold(eventTypeListResult);
					catList.add(cat);
				}

				eventList.setList(catList);
				eventList.setResponseCode(0);
				eventList.setSuccess(true);
				eventList.setMessage("Great! you have a nice array of events types to choose from");

			} else {
				eventList.setResponseCode(1);
				eventList.setSuccess(false);
				eventList.setMessage("Oops! no event list found at this time, please try again soon");
			}

		} catch (Exception e) {

			eventList.setResponseCode(1);
			eventList.setSuccess(false);
			eventList.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return eventList;

	}
	
	
	public ListResponse getTicketTypes() {
		ListResponse charges = new ListResponse();
		APIService modelCall = new APIService();


		try {

			    TicketType ttype = null;
				

				List<DDCategory> catList = new ArrayList<DDCategory>();
			
					DDCategory cat = new DDCategory();
					cat.setTicketTypeDataHold(ttype.REGULAR);
					catList.add(cat);
					
					cat = new DDCategory();
					cat.setTicketTypeDataHold(ttype.VIP);
					catList.add(cat);
				

				charges.setList(catList);
				charges.setResponseCode(0);
				charges.setSuccess(true);
				charges.setMessage("Great! you have a nice array of ticket types to choose from");

		

		} catch (Exception e) {

			charges.setResponseCode(1);
			charges.setSuccess(false);
			charges.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return charges;

	}
	
	
	public ListResponse getCharges() {
		ListResponse charges = new ListResponse();
		APIService modelCall = new APIService();
		ChargeDto ch = null;

		try {

			ArrayList list = modelCall.getCharges(); 
				
			if (list.size() > 0) {
				List<DDCategory> catList = new ArrayList<DDCategory>();
				for (int i = 0; i < list.size(); i++) {
					ch = (ChargeDto) list.get(i);
					DDCategory cat = new DDCategory();
					cat.setChargeTypeDataHold(ch);
					catList.add(cat);
				}

				charges.setList(catList);
				charges.setResponseCode(0);
				charges.setSuccess(true);
				charges.setMessage("Great! you have a nice array of charges to choose from");

			} else {
				charges.setResponseCode(1);
				charges.setSuccess(false);
				charges.setMessage("Oops! no charge list found at this time, please try again soon");
			}

		} catch (Exception e) {

			charges.setResponseCode(1);
			charges.setSuccess(false);
			charges.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return charges;

	}
	
	
	public ServiceResponse getAuth(String email, String password,String lastToken) {
		ServiceResponse resp = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			String newTokenCoded = "";
			PasswordUtil newToken = new PasswordUtil();
			Hasher hashcall = new Hasher();
			newTokenCoded = hashcall.getSHA512HashValue(newToken.generateRandomRedeemCode());
			
			String res = modelCall.getToken(email,hashcall.getSHA512HashValue(password), lastToken,newTokenCoded);

				resp.setResponseCode(0);
				resp.setSuccess(true);
				resp.setMessage(res);

			

		} catch (Exception e) {

			resp.setResponseCode(1);
			resp.setSuccess(false);
			resp.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return resp;

	}
	
	public DiscountResponse getDiscount(String discount_code, String eventType) {
		DiscountResponse discount = new DiscountResponse();
		APIService modelCall = new APIService();

		try {

			DiscountDto res = modelCall.getDiscount(discount_code, eventType);

			if (res != null) {

				discount.setAmount(res.getAmount());
				discount.setChargeType(res.getChargeType());
				discount.setCrt_dt(res.getCrt_dt());
				discount.setDiscountType(res.getDiscountType());
				discount.setEnd_date(res.getEnd_date());
				discount.setId(res.getId());
				discount.setNumber_of_transactions(res.getNumber_of_transactions());
				discount.setStart_date(res.getStart_date());
				discount.setUser_id(res.getUser_id());
				discount.setResponseCode(0);
				discount.setSuccess(true);
				discount.setMessage("Success, Discount found");

			} else {
				discount.setResponseCode(1);
				discount.setSuccess(false);
				discount.setMessage("Sorry :( no active discount found for your code");
			}

		} catch (Exception e) {

			discount.setResponseCode(1);
			discount.setSuccess(false);
			discount.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return discount;

	}

	
	public ServiceResponse addTickets (String json)
	{
		ServiceResponse  resp = new ServiceResponse();
		APIService appcall = new APIService();
		
		try {
			
			JSONArray jsonArr = new JSONArray(json);
			
			if(jsonArr.length() > 0)
			{
				for (int i = 0; i < jsonArr.length(); i++) {
					
					appcall.addEventTicket(jsonArr.getJSONObject(i).getString("event_id"),
							jsonArr.getJSONObject(i).getString("ticket_type_id"),
							jsonArr.getJSONObject(i).getString("guest_dsicount_id"),
							jsonArr.getJSONObject(i).getString("guest_amount")
							);
				}
				
				resp.setMessage("Tickest processed Succesfully");
				resp.setResponseCode(0);
				resp.setSuccess(true);
			}
			else
			{
				resp.setMessage("No Tickets to process");
				resp.setResponseCode(1);
				resp.setSuccess(true);
			}
			
		
			
			
		} catch (Exception e) {
			
			resp.setMessage("System error occured while processing tickets contact admin");
			resp.setResponseCode(1);
			resp.setSuccess(true);

			e.printStackTrace();
		}
		
		
		return resp;
	}
	
	
	
	
	public ServiceResponse addDealer(String email, String password, String phone, String fullname, String isTokenized,String isPrepaid) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			
			PasswordUtil passcall = new PasswordUtil();
			String token = passcall.generateRandomRedeemCode();

			int ret = modelCall.addDealer(email, password, phone, fullname, isTokenized,isPrepaid,Hasher.getSHA512HashValue(token));

			if (ret == 0) {
				
				//send email
				String[] to = {email};
				EmailUtil.sendEmail("info@ticketpark.com", to, "Welcome to ticket park", "body here");


				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Welcome on board! your user account has been added to our database. An email has also been sent to "+email+" for verification");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( user could not be created at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	
	public ServiceResponse changePassword(String email, String password,String newPassword,String userId) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			
			Hasher hashcall = new Hasher();

			int ret = modelCall.changePassword(email, hashcall.getSHA512HashValue(password), hashcall.getSHA512HashValue(newPassword), userId);

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success! your user account details have been changes");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( change unsuccessful at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	public ServiceResponse forgotPassword(String email) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			
			
			PasswordUtil passcall = new PasswordUtil();
			String token = passcall.generateRandomRedeemCode();

			int ret = modelCall.forgotPassword(email,Hasher.getSHA512HashValue(token));

			if (ret == 0) {
				
				//send email
				String[] to = {email};
				EmailUtil.sendEmail("info@ticketpark.com", to, "password reset request", "body here");

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success! your user account details have been changes");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( change unsuccessful at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	public LoginResponse login(String email,String password) {
		LoginResponse res = new LoginResponse();
		APIService modelCall = new APIService();

		try {
			
			System.out.println("password = "+password);
			Hasher hashcall = new Hasher();
			UserDto user = modelCall.login(email,hashcall.getSHA512HashValue(password));

			if (user != null) {

				res.setResponseCode(0); 
				res.setSuccess(true);
				res.setMessage("Welcome");
				res.setEmail(user.getEmail());
				res.setCrt_dt(user.getCrt_dt());
				res.setFullname(user.getFullname());
				res.setId(user.getId());
				res.setPhone(user.getPhone());
				res.setUser_id(user.getUser_id());
				res.setUsertype(""+user.getUsertype_id().getId());

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( we could not authenticate you");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	public ServiceResponse verifyEmail(String email,String token) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			
			Hasher hashcall = new Hasher();

			int ret = modelCall.verifyEmail(email,token);

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success! your email has been verified");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( change unsuccessful at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	public ServiceResponse resetPassword(String email,String newPassword) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			
			Hasher hashcall = new Hasher();

			int ret = modelCall.resetPassword(email, hashcall.getSHA512HashValue(newPassword));

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success! your user account details have been changes");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( change unsuccessful at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	public ServiceResponse addUser(String email, String password, String phone, String fullname, String usertype_id,String user_id) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {
			
			Hasher hashcall = new Hasher();
			
			PasswordUtil passcall = new PasswordUtil();
			String token = passcall.generateRandomRedeemCode();

	
			int ret = modelCall.addUser(email, hashcall.getSHA512HashValue(password), phone, fullname,
					usertype_id,Hasher.getSHA512HashValue(token),user_id);

			if (ret == 0) {
				
				//send email
				String[] to = {email};
				EmailUtil.sendEmail("info@ticketpark.com", to, "Welcome to ticket park", "body here");


				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Welcome on board! your user account has been added to our database. An email has also been sent to "+email+" for validation");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( user could not be created at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}
	
	
	
	public ServiceResponse updateTicket(String event_id,String ticket_type_id,
			String guest_dsicount_id,String guest_amount,String id) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int ret = modelCall.updateTicket(event_id,ticket_type_id,guest_dsicount_id,guest_amount,id);

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage("Success! ticket details has been updated");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( ticket could not be updated at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact admin");

			e.printStackTrace();
		}
		return res;

	}


	public ServiceResponse updateEvent(String event_name, String event_type_id, String event_date_start,
			String event_date_end, String poster_path, String customer_care_phone, String bank_account_no,
			String charge_id, String bank_id, String charge_discount_id, String event_discount_id, String user_id,String id) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int ret = modelCall.updateEvent(event_name, event_type_id, event_date_start, event_date_end, poster_path,
					customer_care_phone, bank_account_no, charge_id, bank_id, charge_discount_id, event_discount_id,
					user_id,id);

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage(
						"Success! event has been updated nicely");

			}
			if (ret == 3) 
			{
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( event could not be updated because payment has been confirmed");
			}			
			else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( event could not be updated at this time. Contact Admin");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact Admin");

			e.printStackTrace();
		}
		return res;

	}
	
	
	
	public ServiceResponse addEvent(String event_name, String event_type_id, String event_date_start,
			String event_date_end, String poster_path, String customer_care_phone, String bank_account_no,
			String charge_id, String bank_id, String charge_discount_id, String event_discount_id, String user_id) {
		ServiceResponse res = new ServiceResponse();
		APIService modelCall = new APIService();

		try {

			int ret = modelCall.addEvent(event_name, event_type_id, event_date_start, event_date_end, poster_path,
					customer_care_phone, bank_account_no, charge_id, bank_id, charge_discount_id, event_discount_id,
					user_id);
			
			//	System.out.println(ret);

			if (ret == 0) {

				res.setResponseCode(0);
				res.setSuccess(true);
				res.setMessage(
						"Congratulations! you are on your way to have a great event. We will nofity you when this event is published");

			} else {
				res.setResponseCode(1);
				res.setSuccess(false);
				res.setMessage("Sorry :( event could not be registered at this time");
			}

		} catch (Exception e) {

			res.setResponseCode(1);
			res.setSuccess(false);
			res.setMessage("Oops! some error occured, please contact customer care");

			e.printStackTrace();
		}
		return res;

	}


}
