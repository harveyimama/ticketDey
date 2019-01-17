/**
 * 
 */
package com.ticket.park.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Seye Cole
 *
 */   
public class ApplicationListener implements HttpSessionListener, HttpSessionAttributeListener
{    
	private CallableStatement stored_procedure;
	private Connection con; // object to connect to database
    private ResultSet result;

    private int output = -1; // for procedure return codes...
    private String empty = ""; // for empty string values...
    
    /*
	private static LinkedHashMap<String, RefDTO> country_tb = new LinkedHashMap<String, RefDTO>(); // holds the various countries in the country
	private static LinkedHashMap<String, RefDTO> state_tb = new LinkedHashMap<String, RefDTO>(); // holds the various state
    private static LinkedHashMap<String, RefDTO> gender_tb = new LinkedHashMap<String, RefDTO>(); // holds the various gender types
	private static LinkedHashMap<String, RefDTO> maritalStatus_tb = new LinkedHashMap<String, RefDTO>(); // holds the various marital status types
	private static LinkedHashMap<String, RefDTO> titles_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various titles
	private static LinkedHashMap<String, RefDTO> designation_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various designations
	private static LinkedHashMap<String, RefDTO> institution_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various institutions	
	private static LinkedHashMap<String, RefDTO> transaction_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various transactions
	private static LinkedHashMap<String, RefDTO> member_company_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various memeber companies
	private static LinkedHashMap<String, RefDTO> alluserType_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various get_alluserType_sp
	private static LinkedHashMap<String, RefDTO> question_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various questions
	private static LinkedHashMap<String, RefDTO> leave_type_tb  = new LinkedHashMap<String, RefDTO>(); // holds the various questions
	
	*/
	
	/**
	 * @return the subject_grade_tb
	 */
	public ApplicationListener()
	{       
		loadStartupValues();
	}
	
	/**
	 * Used internally to connect to admission OOU_REF DB the database.
	 * */
	private void connectToDB() throws Exception
	{
		closeConnectionDB();
		con = Env.getConnectionTicketPark();
	}   

	/**
	 * Used internally to close the connection after use. 
	 * */
	private void closeConnectionDB()
	{
		if(result != null)
		{
			try
			{
				result.close();
				result = null;
			}catch(Exception ex){}
		}
		if(con != null)
		{
			try
			{
				con.close();
				con = null;
			}catch(Exception e){}
		}
	}
	
	
	/**
	 * Used internally to connect to admission OOU_REF DB the database.
	 * */
	
	/**
	 * Used internally to close the connection after use. 
	 * */
	private void closeConnectionREF()
	{
		if(result != null)
		{
			try
			{
				result.close();
				result = null;
			}
			catch(Exception ignore){}
		}
		if(con != null)
		{
			try
			{
				con.close();
				con = null;
			}catch(Exception e){}
		}
	}

	/**
	 * Called when an attribute has being added to either a session or to a servlet context.
	 * */
	public void attributeAdded(HttpSessionBindingEvent event)
	{}
	
	/**
	 * Called when an attribute has being removed from either a session or servlet context.
	 * */
	public void attributeRemoved(HttpSessionBindingEvent event)
	{}
	
	/**
	 * Called when the value of an attribute has being replaced by a new one in either a session or servlet context.
	 * */
	public void attributeReplaced(HttpSessionBindingEvent event)
	{}
	
	/**
	 * Called when a new session has being created.
	 * */
	public void sessionCreated(HttpSessionEvent event)
	{
		//HttpSession session = event.getSession();
	}
	
	/**
	 * Called when a session is about ot be destroyed either by timing out or by the user invalidating it.
	 * */
	public void sessionDestroyed(HttpSessionEvent event)
	{
		//HttpSession session = event.getSession();
	}

	/*This is for all the variables to be handled in session*/	
	private void loadStartupValues()
	{
		
		//Runtime rt = Runtime.getRuntime();
		//System.out.println("Maximum memory available is " + rt.maxMemory() );
		
		
		
		/*getStates();
		getMemberCompany();
		getUserTypes();
		getQuestion();
		getMaritalStatus();
		getTitles();
		getGender();
		getLeaveType();*/

		//FetchMail f = new FetchMail();
		//f.initiateTimer();
		 
		
	}
	
	/**
     * Loads all countries in the database
     * */
  /*  private void loadAllCountries()
    {
    	try
    	{
    		connectToREF();
    		
    		
    		
    		stored_procedure = con.prepareCall("{call getallCountries_sp}");
			result = stored_procedure.executeQuery();

			country_tb.clear();
			
			while(result.next())
			{
				RefDTO country = new RefDTO(result.getString(1), result.getString(3).trim(), empty);
			    country_tb.put(""+country.getId(), country);
			}
			
			
        }
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    		closeConnectionREF();
        }
    	finally
    	{
            closeConnectionREF();
        }
    }
	
    public void getStates()
	{
    	try
    	{
    		connectToREF();

    		stored_procedure = con.prepareCall("{call get_allStates_sp()}");
    		
    		//stored_procedure.setString(1,null);
    		
    		result = stored_procedure.executeQuery();
    		
    		state_tb.clear();
    		
    		while(result.next())
    		{
    			try
    			{
    				RefDTO state = new RefDTO(result.getString(1), result.getString(2).trim(),
								result.getString(3).trim());
    				state_tb.put(""+state.getId(), state);
    			}
    			catch(Exception itx)
    			{
    				itx.printStackTrace();
    			}
    		}
    		closeConnectionREF();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    		closeConnectionREF();
    	}
    	finally
    	{
    		closeConnectionREF();
    	}
	}
	
	gets all the marital status in the database
	public void getMaritalStatus()
	{
		try
		{
			connectToREF();
			
			stored_procedure = con.prepareCall("{call get_maritalstatus_sp}");
			result = stored_procedure.executeQuery();
			
			maritalStatus_tb.clear();
			
			while(result.next())
			{
				RefDTO maritalStatus = new RefDTO(result.getString(1),""+result.getObject(2), empty);
				maritalStatus_tb.put(""+maritalStatus.getId(), maritalStatus);
			}
			closeConnectionREF();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionREF();
		}
		finally
		{
			closeConnectionREF();
		}
	}
	 
	*//**
	 * gets all the gender types in the database.
	 * *//*
	public void getGender()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_gender_sp}");
			result = stored_procedure.executeQuery();

			gender_tb.clear();
			
			while(result.next())
			{
				RefDTO gender = new RefDTO(result.getString(1),""+result.getObject(2), empty);
				gender_tb.put(""+gender.getId(), gender);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	 
	loads all the titles from the database
	public void getTitles()
	{
		try
		{
			connectToREF();
				
			stored_procedure = con.prepareCall("{call get_title_sp}");
			result = stored_procedure.executeQuery();
			
			titles_tb.clear();
			
			while(result.next())
			{
				RefDTO t = new RefDTO(result.getString(1), result.getString(2), empty);
				titles_tb.put(""+t.getId(), t);
			}
			closeConnectionREF();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionREF();
		}
		finally
		{
			closeConnectionREF();
		}
	}

	 loads all the designation from the database 
	public void getDesignation()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_designation_sp}");
			result = stored_procedure.executeQuery();
	
			designation_tb.clear();
			
			while(result.next())
			{
				RefDTO designation = new RefDTO(result.getString(1), result.getString(2), empty);
				designation_tb.put(""+designation.getId(), designation);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionDB();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	 loads all the institution from the database 
	public void getInstituion()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_institution_sp}");
			result = stored_procedure.executeQuery();
			
			institution_tb.clear();
			
			while(result.next())
			{
				RefDTO institution = new RefDTO(result.getString(1), result.getString(2), empty);
				institution_tb.put(""+institution.getId(), institution);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	 loads all the transaction types from the database 
	public void getTransaction()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_transaction_sp}");
			result = stored_procedure.executeQuery();

			transaction_tb.clear();
			
			while(result.next())
			{
				RefDTO transaction = new RefDTO(result.getString(1), result.getString(2), empty);
				transaction_tb.put(""+transaction.getId(), transaction);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	 loads all the member companies types from the database 
	public void getMemberCompany()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_comp_sp}");
			result = stored_procedure.executeQuery();

			member_company_tb.clear();
			
			while(result.next())
			{
				RefDTO mem_company = new RefDTO(result.getString(1), result.getString(2), empty);
				member_company_tb.put(""+mem_company.getId(), mem_company);
			}
			closeConnectionDB();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionDB();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	 loads all the user types from the database 
	public void getUserTypes()
	{
		try
		{
			connectToDB();
			
			stored_procedure = con.prepareCall("{call get_alluserType_sp}");
			result = stored_procedure.executeQuery();

			alluserType_tb.clear();
			
			while(result.next())
			{
				RefDTO mem_company = new RefDTO(result.getString(1), result.getString(2), empty);
				alluserType_tb.put(""+mem_company.getId(), mem_company);
			}
			closeConnectionDB();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionDB();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	*//**
	 * gets all the questions in the database.
	 * *//*
	public void getQuestion()
	{
		
		try
		{
			connectToDB();
			stored_procedure = con.prepareCall("{call get_question_sp}");
			
			
			result = stored_procedure.executeQuery();
			while(result.next())
			{
				RefDTO question = new RefDTO(result.getString(1), result.getString(2), empty);
				question_tb.put(question.getId(), question);
			}
			closeConnectionDB();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionDB();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	
	*//**
	 * gets all the questions in the database.
	 * *//*
	public void getLeaveType()
	{
		
		try
		{
			connectToDB();
			stored_procedure = con.prepareCall("{call get_leave_sp}");
			
			
			result = stored_procedure.executeQuery();
			while(result.next())
			{
				RefDTO leave_type = new RefDTO(result.getString(1), result.getString(2), empty);
				leave_type_tb.put(leave_type.getId(), leave_type);
			}
			closeConnectionDB();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			closeConnectionDB();
		}
		finally
		{
			closeConnectionDB();
		}
	}
	
	
	public void checkWhenToSendMail()
	{
		TimerTask fetchMail  = new FetchMail();

	    //perform the task once a day at 9pm, starting today 14th of August 2009
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(fetchMail, getTodayEvening9pm(), fONCE_PER_DAY);
	}
	
	
	*//**
	 * @return the country_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getCountry_tb() {
		return country_tb;
	}

	*//**
	 * @return the state_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getState_tb() {
		return state_tb;
	}

	

	*//**
	 * @return the gender_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getGender_tb() {
		return gender_tb;
	}

	*//**
	 * @return the maritalStatus_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getMaritalStatus_tb() {
		return maritalStatus_tb;
	}

	*//**
	 * @return the titles_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getTitles_tb() {
		return titles_tb;
	}

	*//**
	 * @return the designation_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getDesignation_tb() {
		return designation_tb;
	}

	*//**
	 * @return the institution_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getInstitution_tb() {
		return institution_tb;
	}

	*//**
	 * @return the transaction_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getTransaction_tb() {
		return transaction_tb;
	}

	*//**
	 * @return the member_company_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getMember_company_tb() {
		return member_company_tb;
	}

	*//**
	 * @return the alluserType_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getAlluserType_tb() {
		return alluserType_tb;
	}

	*//**
	 * @return the question_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getQuestion_tb() {
		return question_tb;
	}

	*//**
	 * @return the leave_type_tb
	 *//*
	public static LinkedHashMap<String, RefDTO> getLeave_type_tb() {
		return leave_type_tb;
	}*/
}
