
package com.ticket.park.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * Resource object for retrieving database connections from the configurations of the web server through JNDI.
 * 
 * 
 * Created 14 - 01 - 07
 * @author Seye Cole
 * */
public class Env
{
	/**
	 * Statis varaible for getting context configurations.
	 * Used by all methods to retrieve the environment context.
	 * */
	private static Context initCtx;
	private static Context envCtx;
	private static Connection con;
	
	/*private static String url ="jdbc:mysql://172.16.0.2:3306/brickms";
	private static String url_refdb = "jdbc:mysql://172.16.0.2:3306/brick_ref";
	private static String username = "harvey";
	private static String pwd = "1w2w1s";
	*/
	
	/*
	 * Static block for context environment connection.
	 * */
	static
	{
		try
		{
			//live
			//initCtx = new InitialContext();
			//envCtx = (Context)initCtx.lookup("java:comp/env");
			
			//test
			getConnectionTicketParkTest();
		}
		catch(Exception ex)
		{
			System.out.println("Error initailizing the context environment...");
			ex.printStackTrace();
		}
	}
	
	//for braLaw
	/**
	 * @return java.sql.Connection
	 * */
	public static Connection getConnectionTicketPark(){
		try
		{
			DataSource ds = (DataSource)envCtx.lookup("jdbc/ticketPark");
			Connection con = ds.getConnection();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			
			/*Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url,username,pwd);
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);*/
			return con;
		}
		catch(Exception ex)
		{
			System.out.println("Error retrieving the data source from the context...");
			ex.printStackTrace();
			return  reconnectTicketPark();
		}  
	}
	
	/**
	 * Reconnects the connection object to the database.
	 * */
	public static Connection reconnectTicketPark()
	{
		try
		{
			DataSource ds = (DataSource)envCtx.lookup("jdbc/ticketPark");
			Connection con = ds.getConnection();
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			
			/*Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url,username,pwd);
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);*/
			
			return con;
		}
		catch(Exception ex)
		{
			System.out.println("Error retrieving the data source from the context...");
			ex.printStackTrace();
			return null;
		}
	}
	
	public static Connection getConnectionTicketParkTest(){
	
		try
		{
			 con =
				       DriverManager.getConnection("jdbc:mysql://localhost/ticket_dey?user=root&password=1W2w1s500.&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			 
			 
		}
		catch(Exception ex)
		{
			System.out.println("Error retrieving the data source from the context...");
			ex.printStackTrace();
			
		}  
		
		return  con;
	}
	
}
