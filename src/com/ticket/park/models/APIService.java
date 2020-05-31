package com.ticket.park.models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ticket.park.data.DDCategory;
import com.ticket.park.dto.BankDto;
import com.ticket.park.dto.ChargeDto;
import com.ticket.park.dto.ChargeTypeDto;
import com.ticket.park.dto.DiscountDto;
import com.ticket.park.dto.EventDto;
import com.ticket.park.dto.EventTicketDto;
import com.ticket.park.dto.EventTypeDto;
import com.ticket.park.dto.UserDto;
import com.ticket.park.enums.ChargeTypeEnum;
import com.ticket.park.enums.ChargeTypeEnum.ChargeType;
import com.ticket.park.enums.DiscountTypeEnum;
import com.ticket.park.enums.DiscountTypeEnum.DiscountType;
import com.ticket.park.enums.TicketTypeEnum;
import com.ticket.park.enums.TicketTypeEnum.TicketType;
import com.ticket.park.enums.UserTypeEnum;
import com.ticket.park.enums.UserTypeEnum.UserType;
import com.ticket.park.utility.ApplicationListener;
import com.ticket.park.utility.Env;

public class APIService {

	Connection con, con_macalla;
	Statement stat, stat_macalla;
	ResultSet result, result2, result3;
	String empty = "";

	CallableStatement stored_procedure, stored_procedure2, stored_procedure3;

	ApplicationListener app = new ApplicationListener();
	String from = "";
	String[] to = new String[1];

	public APIService() {

	}

	public void connectDB() throws SQLException {
		closeConnection();

		con = Env.getConnectionTicketParkTest();
	}

	public void closeConnection() {
		if (result != null) {
			try {
				result.close();
				result = null;
			} catch (Exception ex) {
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (Exception e) {
			}
		}
	}

	public ArrayList getEventTypes(String discount_code) {

		ArrayList list = new ArrayList();

		String msisdn = "";

		try {

			connectDB();

			stored_procedure = con.prepareCall("{call get_event_types_sp()}");

			result = stored_procedure.executeQuery();

			while (result.next()) {

				stored_procedure2 = con.prepareCall("{call get_charge_types_by_event_id_sp(?)}");
				stored_procedure2.setString(1, result.getString(1));
				result2 = stored_procedure2.executeQuery();

				ChargeTypeDto chargeType = null;

				while (result2.next()) {
					stored_procedure3 = con.prepareCall("{call get_charges_by_charge_type_id_sp(?)}");
					stored_procedure3.setString(1, result2.getString(1));
					result3 = stored_procedure3.executeQuery();

					List<ChargeDto> charges = new ArrayList<ChargeDto>();

					while (result3.next()) {

						UserDto user2 = new UserDto(result3.getString(11), null, null, null, null, null, null, null);
						ChargeTypeEnum ne = new ChargeTypeEnum();
						ChargeType dealer_comm_type = ne.setChargeType(result3.getInt(9));
						ChargeType agent_comm_type = ne.setChargeType(result3.getInt(10));

						ChargeDto ch = new ChargeDto(result3.getString(1), result3.getString(2), result3.getString(3),
								result3.getString(4), result3.getString(5), result3.getString(6), result3.getString(7),
								result3.getString(8), dealer_comm_type, agent_comm_type, user2,result3.getString(11));

						charges.add(ch);

					}

					ChargeTypeEnum ne1 = new ChargeTypeEnum();
					ChargeType cType = ne1.setChargeType(result2.getInt(5));
					UserDto user1 = new UserDto(result2.getString(4), null, null, null, null, null, null, null);

					chargeType = new ChargeTypeDto(result2.getString(1), result2.getString(2), result2.getString(3),
							user1, cType, charges);

				}

				UserDto user0 = new UserDto(result.getString(6), null, null, null, null, null, null, null);

				DiscountDto discount = null;
				EventTypeDto eventTypes = new EventTypeDto(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4), result.getString(5), chargeType, user0, discount);

				stored_procedure2 = con.prepareCall("{call get_discount_by_event_id_sp(?,?)}");
				stored_procedure2.setString(1, result.getString(1));
				stored_procedure2.setString(2, discount_code);
				result2 = stored_procedure2.executeQuery();

				while (result2.next()) {

					user0 = new UserDto(result2.getString(9), null, null, null, null, null, null, null);
					ChargeTypeEnum ne2 = new ChargeTypeEnum();
					ChargeType cType2 = ne2.setChargeType(result3.getInt(7));
					DiscountTypeEnum ne3 = new DiscountTypeEnum();
					DiscountType dType2 = ne3.setDiscountType(result3.getInt(8));

					discount = new DiscountDto(result2.getString(1), result2.getString(2), result2.getString(3),
							result2.getString(4), result2.getString(5), result2.getString(6), cType2, dType2, user0);

				}

				eventTypes.setDiscount(discount);

				list.add(eventTypes);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return list;

	}

	
	public ArrayList getUserTickets(String userId) {

		ArrayList list = new ArrayList();

		

		try {

			connectDB();
			
			EventDto event  = null;

			stored_procedure = con.prepareCall("{call get_user_tickets_sp(?,?)}");
			stored_procedure.setString(1, userId);
			result = stored_procedure.executeQuery();

			while (result.next()) {

				stored_procedure2 = con.prepareCall("{call get_event_by_id_sp(?)}");
				stored_procedure2.setString(1, result.getString(1));
				result2 = stored_procedure2.executeQuery();
				
				while (result2.next()) {

				 event = new EventDto(result2.getString(1), result2.getString(2), null, result2.getString(3),
						result2.getString(4), result2.getString(5), result2.getString(6), result2.getString(7),
						result2.getString(8), result2.getString(9), result2.getString(10), null, null, null,
						null, null, null,result2.getString(18));

				}
				
				TicketTypeEnum  tType = new TicketTypeEnum();
				TicketType ticketType = tType.setTicketType(result.getInt(2));
				
				DiscountTypeEnum  dType = new DiscountTypeEnum();
				DiscountType discountType = dType.setDiscountType(result.getInt(3));
				
			EventTicketDto ticket = new EventTicketDto(event,ticketType,discountType,result.getString(4),result.getString(5));

			list.add(ticket);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return list;

	}

	
	
	
	public ArrayList getEventTickets(String eventId, String eventCode,String discount_code) {

		ArrayList list = new ArrayList();

		

		try {

			connectDB();
			
			EventDto event  = null;

			stored_procedure = con.prepareCall("{call get_event_tickets_sp(?,?,?)}");
			stored_procedure.setString(1, eventId);
			stored_procedure.setString(2, eventCode);
			stored_procedure.setString(3, discount_code);
			result = stored_procedure.executeQuery();

			while (result.next()) {

				stored_procedure2 = con.prepareCall("{call get_event_by_id_sp(?)}");
				stored_procedure2.setString(1, result.getString(1));
				result2 = stored_procedure2.executeQuery();
				
				while (result2.next()) {

				 event = new EventDto(result2.getString(1), result2.getString(2), null, result2.getString(3),
						result2.getString(4), result2.getString(5), result2.getString(6), result2.getString(7),
						result2.getString(8), result2.getString(9), result2.getString(10), null, null, null,
						null, null, null,result2.getString(18));

				}
				
				TicketTypeEnum  tType = new TicketTypeEnum();
				TicketType ticketType = tType.setTicketType(result.getInt(2));
				
				DiscountTypeEnum  dType = new DiscountTypeEnum();
				DiscountType discountType = dType.setDiscountType(result.getInt(3));
				
			EventTicketDto ticket = new EventTicketDto(event,ticketType,discountType,result.getString(4),result.getString(5));

			list.add(ticket);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return list;

	}

	
	
	
	public ArrayList getEvents(String eventType, String approvalStatus, String user, String code, String featureLevel,
			String nameLike) {

		ArrayList list = new ArrayList();

		String msisdn = "";

		try {

			connectDB();

			stored_procedure = con.prepareCall("{call get_events_sp(?,?,?,?,?,?)}");
			stored_procedure.setString(1, eventType);
			stored_procedure.setString(2, approvalStatus);
			stored_procedure.setString(3, user);
			stored_procedure.setString(4, code);
			stored_procedure.setString(5, featureLevel);
			stored_procedure.setString(6, nameLike);

			result = stored_procedure.executeQuery();

			while (result.next()) {

				stored_procedure3 = con.prepareCall("{call get_charge_by_event_sp(?)}");
				stored_procedure3.setString(1, result.getString(1));
				result3 = stored_procedure3.executeQuery();

				ChargeDto charge = null;

				while (result3.next()) {

					UserDto user2 = new UserDto(result3.getString(11), null, null, null, null, null, null, null);
					ChargeTypeEnum ne = new ChargeTypeEnum();
					ChargeType dealer_comm_type = ne.setChargeType(result3.getInt(9));
					ChargeType agent_comm_type = ne.setChargeType(result3.getInt(10));

					charge = new ChargeDto(result3.getString(1), result3.getString(2), result3.getString(3),
							result3.getString(4), result3.getString(5), result3.getString(6), result3.getString(7),
							result3.getString(8), dealer_comm_type, agent_comm_type, user2,result3.getString(11));

				}

				stored_procedure3 = con.prepareCall("{call get_user_by_event_sp(?)}");
				stored_procedure3.setString(1, result.getString(1));
				result3 = stored_procedure3.executeQuery();

				UserDto user1 = null;

				while (result3.next()) {

					UserTypeEnum uu = new UserTypeEnum();
					UserType user_type = uu.setUserType(result3.getInt(6));
					UserDto user2 = new UserDto(result3.getString(1), result3.getString(2), null, result3.getString(3),
							result3.getString(4), result3.getString(5), user_type, null);

				}

				DiscountDto charge_discount = null;

				stored_procedure2 = con.prepareCall("{call get_charge_discount_sp(?)}");
				stored_procedure2.setString(1, result.getString(1));
				result2 = stored_procedure2.executeQuery();

				while (result2.next()) {

					UserDto user0 = new UserDto(result2.getString(9), null, null, null, null, null, null, null);
					ChargeTypeEnum ne2 = new ChargeTypeEnum();
					ChargeType cType2 = ne2.setChargeType(result3.getInt(7));
					DiscountTypeEnum ne3 = new DiscountTypeEnum();
					DiscountType dType2 = ne3.setDiscountType(result3.getInt(8));

					charge_discount = new DiscountDto(result2.getString(1), result2.getString(2), result2.getString(3),
							result2.getString(4), result2.getString(5), result2.getString(6), cType2, dType2, user0);

				}

				DiscountDto event_discount = null;

				stored_procedure2 = con.prepareCall("{call get_event_discount_sp(?)}");
				stored_procedure2.setString(1, result.getString(1));
				result2 = stored_procedure2.executeQuery();

				while (result2.next()) {

					UserDto user0 = new UserDto(result2.getString(9), null, null, null, null, null, null, null);
					ChargeTypeEnum ne2 = new ChargeTypeEnum();
					ChargeType cType2 = ne2.setChargeType(result3.getInt(7));
					DiscountTypeEnum ne3 = new DiscountTypeEnum();
					DiscountType dType2 = ne3.setDiscountType(result3.getInt(8));

					event_discount = new DiscountDto(result2.getString(1), result2.getString(2), result2.getString(3),
							result2.getString(4), result2.getString(5), result2.getString(6), cType2, dType2, user0);

				}

				EventTypeDto event_type = new EventTypeDto(result.getString(11), result.getString(12), null, null, null,
						null, null, null);
				BankDto bank = new BankDto(result.getString(13), result.getString(14), result.getString(15));
				UserDto approver = new UserDto(result.getString(16), null, null, null, result.getString(17), null, null,
						null);
				;

				EventDto event = new EventDto(result.getString(1), result.getString(2), event_type, result.getString(3),
						result.getString(4), result.getString(5), result.getString(6), result.getString(7),
						result.getString(8), result.getString(9), result.getString(10), charge, bank, charge_discount,
						event_discount, user1, approver,result.getString(18));

				list.add(event);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return list;

	}

	public DiscountDto getDiscount(String discount_code, String event_type) {

		String msisdn = "";
		DiscountDto discount = null;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call get_discount_by_event_id_sp(?,?)}");
			stored_procedure2.setString(1, event_type);
			stored_procedure2.setString(2, discount_code);
			result2 = stored_procedure2.executeQuery();

			while (result2.next()) {

				UserDto user0 = new UserDto(result2.getString(9), null, null, null, null, null, null, null);
				ChargeTypeEnum ne2 = new ChargeTypeEnum();
				ChargeType cType2 = ne2.setChargeType(result3.getInt(7));
				DiscountTypeEnum ne3 = new DiscountTypeEnum();
				DiscountType dType2 = ne3.setDiscountType(result3.getInt(8));

				discount = new DiscountDto(result2.getString(1), result2.getString(2), result2.getString(3),
						result2.getString(4), result2.getString(5), result2.getString(6), cType2, dType2, user0);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return discount;

	}
	
	
	
	public String getToken(String email, String password,String lastToken,String newTokenCoded) {


		String resp = "Sorry :(, could not Authorize you. Please check password or last token for correctness.";
		int output = -1;
		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_dealer_token_sp(?,?,?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, password);
			stored_procedure2.setString(3, lastToken);
			stored_procedure2.setString(4, newTokenCoded);
			stored_procedure2.setInt(5, output);

			stored_procedure2.registerOutParameter(5, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(5);

			if (output == 0) {

				resp = newTokenCoded;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return resp;

	}
	
	
	
	public ArrayList getCharges() {

		String msisdn = "";
		ArrayList charges = new ArrayList();

		try {

			connectDB();

			stored_procedure3 = con.prepareCall("{call get_charges_sp()}");
			result3 = stored_procedure3.executeQuery();


			while (result3.next()) {

				UserDto user2 = new UserDto(result3.getString(11), null, null, null, null, null, null, null);
				ChargeTypeEnum ne = new ChargeTypeEnum();
				ChargeType dealer_comm_type = ne.setChargeType(result3.getInt(9));
				ChargeType agent_comm_type = ne.setChargeType(result3.getInt(10));

				ChargeDto ch = new ChargeDto(result3.getString(1), result3.getString(2), result3.getString(3),
						result3.getString(4), result3.getString(5), result3.getString(6), result3.getString(7),
						result3.getString(8), dealer_comm_type, agent_comm_type, user2,result3.getString(11));

				charges.add(ch);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return charges;

	}

	public int addEventTicket(String event_id, String ticket_type_id, String guest_dsicount_id, String guest_amount) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call crt_event_ticket_type_sp(?,?,?,?,?)}");
			stored_procedure2.setString(1, event_id);
			stored_procedure2.setString(2, ticket_type_id);
			stored_procedure2.setString(3, guest_dsicount_id);
			stored_procedure2.setString(4, guest_amount);
			stored_procedure2.setInt(5, output);

			stored_procedure2.registerOutParameter(5, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(5);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	public int updateTicket(String event_id,String ticket_type_id,
			String guest_dsicount_id,String guest_amount,String id) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_ticket_sp(?,?,?,?,?,?)}");
			stored_procedure2.setString(1, event_id);
			stored_procedure2.setString(2, ticket_type_id);
			stored_procedure2.setString(3, guest_dsicount_id);
			stored_procedure2.setString(4, guest_amount);
			stored_procedure2.setString(5, id);
			stored_procedure2.setInt(6, output);

			stored_procedure2.registerOutParameter(6, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(6);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	public int changePassword(String email, String password,String newPassword,String userId) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call change_password_sp(?,?,?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, password);
			stored_procedure2.setString(3, newPassword);
			stored_procedure2.setString(4, userId);
			stored_procedure2.setInt(5, output);

			stored_procedure2.registerOutParameter(5, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(5);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	public int forgotPassword(String email,String token) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call forgot_password_sp(?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setInt(2, output);
			stored_procedure2.setString(3, token);

			stored_procedure2.registerOutParameter(2, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(2);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	public UserDto login(String email,String password) {
		UserDto user = null;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call login(?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, password);

			result3 = stored_procedure2.executeQuery();

			while (result3.next()) {
				
				UserTypeEnum uu = new UserTypeEnum();
				UserType user_type = uu.setUserType(result3.getInt(6));
				user = new UserDto(result3.getString(1), result3.getString(2), null, result3.getString(3),
						result3.getString(4), result3.getString(5), user_type, null);
			
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		
		return user;

	}
	
	
	public int verifyEmail(String email,String token) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call verify_email_sp(?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setInt(2, output);
			stored_procedure2.setString(1, token);

			stored_procedure2.registerOutParameter(2, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(2);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	public int resetPassword(String email,String newPassword) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call reset_password_sp(?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, newPassword);
			stored_procedure2.setInt(3, output);

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	public int addUser(String email, String password, String phone, String fullname, String usertype_id,String token,String user_id) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call crt_user_sp(?,?,?,?,?,?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, password);
			stored_procedure2.setString(3, phone);
			stored_procedure2.setString(4, fullname);
			stored_procedure2.setString(5, usertype_id);
			stored_procedure2.setInt(6, output);
			stored_procedure2.setString(7, token);
			stored_procedure2.setString(8, user_id);
			

			stored_procedure2.registerOutParameter(6, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(6);
		
			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	public int addDealer(String email, String password, String phone, String fullname, String isTokenized,String isPrepaid,String token) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call crt_dealer_sp(?,?,?,?,?,?,?,?)}");
			stored_procedure2.setString(1, email);
			stored_procedure2.setString(2, password);
			stored_procedure2.setString(3, phone);
			stored_procedure2.setString(4, fullname);
			stored_procedure2.setString(5, isTokenized);
			stored_procedure2.setInt(6, output);
			stored_procedure2.setString(7, isPrepaid);
			stored_procedure2.setString(8, token);

			stored_procedure2.registerOutParameter(6, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(6);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	
	public int updateEventDiscount(String requestId, String approvalStatus,String approverId) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_event_discount_sp(?,?,?,?)}");
			stored_procedure2.setString(1, requestId);
			stored_procedure2.setString(2, approvalStatus);
			stored_procedure2.setInt(3, output);
			stored_procedure2.setString(4, approverId);
			

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	public int updateEventCharge(String requestId, String approvalStatus,String approverId) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_event_charge_sp(?,?,?,?)}");
			stored_procedure2.setString(1, requestId);
			stored_procedure2.setString(2, approvalStatus);
			stored_procedure2.setInt(3, output);
			stored_procedure2.setString(4, approverId);
			

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	public int updateEventDiscountRequest(String eventId, String discountId,String userId) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_event_discount_request_sp(?,?,?,?)}");
			stored_procedure2.setString(1, eventId);
			stored_procedure2.setString(2, discountId);
			stored_procedure2.setInt(3, output);
			stored_procedure2.setString(4, userId);
			

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	public int updateEventChargeRequest(String eventId, String chargeId,String userId) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_event_charge_request_sp(?,?,?,?)}");
			stored_procedure2.setString(1, eventId);
			stored_procedure2.setString(2, chargeId);
			stored_procedure2.setInt(3, output);
			stored_procedure2.setString(4, userId);
			

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	

	public int approveEvent(String eventId, String approvalStatus) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call approve_event_sp(?,?,?)}");
			stored_procedure2.setString(1, eventId);
			stored_procedure2.setString(2, approvalStatus);
			stored_procedure2.setInt(3, output);

			stored_procedure2.registerOutParameter(3, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(3);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}


	public int addEvent(String event_name, String event_type_id, String event_date_start, String event_date_end,
			String poster_path, String customer_care_phone, String bank_account_no, String charge_id, String bank_id,
			String charge_discount_id, String event_discount_id, String user_id) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call crt_event_sp(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stored_procedure2.setString(1, event_name);
			stored_procedure2.setString(2, event_type_id);
			stored_procedure2.setString(3, event_date_start);
			stored_procedure2.setString(4, event_date_end);
			stored_procedure2.setString(5, poster_path);
			stored_procedure2.setString(6, customer_care_phone);
			stored_procedure2.setString(7, bank_account_no);
			stored_procedure2.setString(8, charge_id);
			stored_procedure2.setString(9, bank_id);
			stored_procedure2.setString(10, charge_discount_id);
			stored_procedure2.setString(11, event_discount_id);
			stored_procedure2.setString(12, user_id);
			stored_procedure2.setInt(13, output);

			stored_procedure2.registerOutParameter(13, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(13);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}
	
	
	
	public int updateEvent(String event_name, String event_type_id, String event_date_start, String event_date_end,
			String poster_path, String customer_care_phone, String bank_account_no, String charge_id, String bank_id,
			String charge_discount_id, String event_discount_id, String user_id,String id) {

		int output = -1;

		try {

			connectDB();

			stored_procedure2 = con.prepareCall("{call up_event_sp(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			stored_procedure2.setString(1, event_name);
			stored_procedure2.setString(2, event_type_id);
			stored_procedure2.setString(3, event_date_start);
			stored_procedure2.setString(4, event_date_end);
			stored_procedure2.setString(5, poster_path);
			stored_procedure2.setString(6, customer_care_phone);
			stored_procedure2.setString(7, bank_account_no);
			stored_procedure2.setString(8, charge_id);
			stored_procedure2.setString(9, bank_id);
			stored_procedure2.setString(10, charge_discount_id);
			stored_procedure2.setString(11, event_discount_id);
			stored_procedure2.setString(12, user_id);
			stored_procedure2.setInt(13, output);
			stored_procedure2.setString(12, id);
			
			stored_procedure2.registerOutParameter(13, java.sql.Types.INTEGER);

			stored_procedure2.execute();

			output = stored_procedure2.getInt(13);

			if (output == 0) {
				//con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			closeConnection();

		} finally {
			closeConnection();
		}
		return output;

	}


}
