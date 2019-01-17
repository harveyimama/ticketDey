package com.ticket.park.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordUtil {
	
	private static String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	//private static String[] speletters = new String[]{"@", "$", "="};
	private static String[] digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public static final int ID_LENGTH = 5;
	public static String generateRandomPIN()
	{
		Random rnd = new Random();
		StringBuilder strB = new StringBuilder();
		
		for(int i=0; i<4; i++)
		{
			int index = rnd.nextInt(digits.length);
			String letter = digits[index];
			strB.append(letter);
		}
		
		return strB.toString();
	}
	
	public static String generateRandomPassword()
	{
		Random rnd = new Random();
		StringBuilder strB = new StringBuilder();
		
		//strB.append(speletters[rnd.nextInt(speletters.length)]);
		for(int i=0; i<3; i++)
		{
			int index = rnd.nextInt(letters.length);
			String letter = letters[index];
			strB.append(letter);
		}
		for(int i=0; i<3; i++)
		{
			int index = rnd.nextInt(digits.length);
			String letter = digits[index];
			strB.append(letter);
		}
		
		return strB.toString();
	}
	
	public static String generateRandomRedeemCode()
	{
		Random rnd = new Random();
		StringBuilder strB = new StringBuilder();
		
		for(int i=0; i<8; i++)
		{
			int index = rnd.nextInt(digits.length);
			String letter = digits[index];
			strB.append(letter);
		}
		
		/*for(int i=0; i<3; i++)
		{
			int index = rnd.nextInt(letters.length);
			String letter = letters[index];
			strB.append(letter);
		}*/
		//strB.append(speletters[rnd.nextInt(speletters.length)]);
		
		return strB.toString();
	}
	
	
	public static String generateCalenderDate()
	{
	Calendar can = Calendar.getInstance();
	String yy = "" + can.get(Calendar.YEAR);
	yy = yy.substring(2);
	String mm = "" + (1 + can.get(Calendar.MONTH));
	if (mm.length() == 1)
		mm = "0" + mm;
	String dd = "" + can.get(Calendar.DATE);
	if (dd.length() == 1)
		dd = "0" + dd;
	String HH = "" + can.get(Calendar.HOUR_OF_DAY);
	if (HH.length() == 1)
		HH = "0" + HH;
	String mmm = "" + can.get(Calendar.MINUTE);
	if (mmm.length() == 1)
		mmm = "0" + mmm;
	String ss = "" + can.get(Calendar.SECOND);
	if (ss.length() == 1)
		ss = "0" + ss;

	return  yy + mm + dd + HH + mmm + ss ;
	
	
	}
	
	
	

	public static String generateUniqueId() {
		
		Date date=new Date();
		//Timestamp timestamp = new Timestamp(date.getTime());
		String uidCheck=RandomStringUtils.randomAlphanumeric(ID_LENGTH)+"_"+date.getTime();
	    return uidCheck;
	}

}
