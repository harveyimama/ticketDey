package com.ticket.park.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

import org.apache.commons.lang3.StringUtils;

/**
 * Utility class to hash string values.
 * */
public class Hasher
{
	public static String getHashValue(String val)
	{
        StringBuilder sb = new StringBuilder();
        
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            byte[] bs;
            bs = messageDigest.digest(val.getBytes());
            for(int i = 0; i < bs.length; i++)
            {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if(hexVal.length() == 1) 
                {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        }
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, "exception caught", ex);
        }
        return sb.toString();
    }
	
	public static String formatMSISDN(String msisdn)
	{
		String ret = msisdn;
		if(ret != null)
		{
			if(ret.startsWith("0"))
				ret = "234" + ret.substring(1);
			else if(ret.length()==10)
				ret = "234" + ret;
		}
		
		return ret;
	}
	
	
	public static String getSHA1HashValue(String val)
	{
        StringBuilder sb = new StringBuilder();
        
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            byte[] bs;
            bs = messageDigest.digest(val.getBytes());
            for(int i = 0; i < bs.length; i++)
            {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if(hexVal.length() == 1) 
                {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        }
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, "exception caught", ex);
        }
        return sb.toString();
    }
	
	public static String getSHA512HashValue(String val)
	{
        StringBuilder sb = new StringBuilder();
        
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            byte[] bs;
            bs = messageDigest.digest(val.getBytes());
            for(int i = 0; i < bs.length; i++)
            {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if(hexVal.length() == 1) 
                {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        }
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, "exception caught", ex);
        }
        return sb.toString();
    }
	
	
	public static String getMD5HashValue(String val)
	{
        StringBuilder sb = new StringBuilder();
        
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bs;
            bs = messageDigest.digest(val.getBytes());
            for(int i = 0; i < bs.length; i++)
            {
                String hexVal = Integer.toHexString(0xFF & bs[i]);
                if(hexVal.length() == 1) 
                {
                    sb.append("0");
                }
                sb.append(hexVal);
            }
        }
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, "exception caught", ex);
        }
        return sb.toString();
    }
	
	
	public static String generateHashedStringSHA512(String toBeHashed) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
        messageDigest.update(toBeHashed.getBytes());
        byte[] echoData = messageDigest.digest();
        String out = StringUtils.EMPTY;
        StringBuilder sb = new StringBuilder();
        for (byte element : echoData) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        out = sb.toString();
        return out;
    }
 private static final String SHA_512 = "SHA-512";
 
 
 
 
 private static final String ALGO = "AES";
 private static final byte[] keyValue = 
     new byte[] { 'H', 'a', 'v', 'e', 'I', 'm', 'o',
'n', 'a', 'I', 'm','a', 'm', 'a', 'I', 'T' };
 
 
 private static final byte[] keyValue2 = 
     new byte[] { 'W', '@', 'l', 'l', 'e', 't', 'f',
'e', 't', 'S', '.','1', '2', '3', '!', '#' };

 /*
public static String encrypt(String Data) throws Exception {
     Key key = generateKey();
     Cipher c = Cipher.getInstance(ALGO);
     c.init(Cipher.ENCRYPT_MODE, key);
     byte[] encVal = c.doFinal(Data.getBytes());
     String encryptedValue = new BASE64Encoder().encode(encVal);
     return encryptedValue;
 }



 public static String decrypt(String encryptedData) throws Exception {
     Key key = generateKey();
     Cipher c = Cipher.getInstance(ALGO);
     c.init(Cipher.DECRYPT_MODE, key);
     byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
     byte[] decValue = c.doFinal(decordedValue);
     String decryptedValue = new String(decValue);
     return decryptedValue;
 }
 
 public static String decrypt2(String encryptedData) throws Exception {
     Key key = generateKey2();
     Cipher c = Cipher.getInstance(ALGO);
     c.init(Cipher.DECRYPT_MODE, key);
     byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
     byte[] decValue = c.doFinal(decordedValue);
     String decryptedValue = new String(decValue);
     return decryptedValue;
 }
 
 */
 
 private static Key generateKey() throws Exception {
     Key key = new SecretKeySpec(keyValue, ALGO);
     return key;
}
 
 private static Key generateKey2() throws Exception {
     Key key = new SecretKeySpec(keyValue2, ALGO);
     return key;
}

 
 
 
	
}
