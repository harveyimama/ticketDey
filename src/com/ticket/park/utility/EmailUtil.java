/**
 *
 */
package com.ticket.park.utility;

import java.util.Calendar;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;



import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;


/**
 * @author Seye Cole
 *
 */
public class EmailUtil
{	
	/**
     * Sends an email to the specified email address.
     *
     * @param from The from email address.
     * @param to The recipient of the email.
     * @param subject The subject of the email.
     * @param body The message content of the email.
     * */
    public static synchronized String sendEmail(String from, String[] to, String subject,
            String body)
    {
        String ret = null;
        
        EmailUtil e = new EmailUtil();
        
        try
        {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            Session session = (Session) envCtx.lookup("mail/Session");
            
            String smtp_username = (String)envCtx.lookup("smtp.username");
            String smtp_password = (String)envCtx.lookup("smtp.password");
            
            Authenticator auth = e.new SMTPAuthenticator(smtp_username, smtp_password);
            session = Session.getDefaultInstance(session.getProperties(), auth);
            
            session.setDebug(false);
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from, "Funds & Electronic Transfer Solutions"));
            InternetAddress to_address[] = new InternetAddress[to.length];
            for(int i=0; i<to.length; i++)
            	to_address[i] = new InternetAddress(to[i]);
            message.setRecipients(Message.RecipientType.TO, to_address);
            message.setSubject(subject);
            String msg="<div style='width: 600px; margin-top: 30px; margin-bottom: 20px;'><div style='padding: 10px 15px;border-top-left-radius: 3px;border-top-right-radius: 3px;background-color: #f5f5f5;'><img src='https://fetswallet.com/images/fetswallet-mobile.png' style='width:200px; height:auto' alt=''/></div><div style='padding: 15px; font-family:Arial, Helvetica, sans-serif'>"+body+"<p style='font-size:12px;'>For more information, please email: customercare@fetswallet.com or call fets customer care on <b>0800-CALL-FETS (0800-2255-3387)</b><br><br><b>NB</b><br> - You can visit our website at fetslimited.com</p><p>Thank you!<br><br><b>Funds &amp; Electronic Transfer Solutions Limited. &copy; 2014</b></p></div></div>";
            message.setContent(msg, "text/html");
            message.setSentDate(new java.util.Date());
            Transport.send(message);
            
            ret = "success";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
            String exStr = ex.getMessage();
            try
            {
                exStr = exStr.substring(exStr.lastIndexOf("]")+1);
            }
            catch(Exception ignore){}
            
            ret = "Error: Could not send the email, Message: " + exStr;
        }
        finally
        {
            //nothing to dispose
        }
        
        return ret;
    }
    
    /**
     * Sends an email to the specified email address with attachment.
     *
     * @param from The from email address.
     * @param to The recipient of the email.
     * @param subject The subject of the email.
     * @param body The message content of the email.
     * @param data The byte array of the file to be attached.
     * */
    public static synchronized String sendEmail(String from, String[] to, String subject,
            String body, byte[] data, String fname)
    {
        String ret = null;
        
        EmailUtil e = new EmailUtil();
        
        try
        {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            Session session = (Session) envCtx.lookup("mail/Session");
            
            String smtp_username = (String)envCtx.lookup("smtp.username");
            String smtp_password = (String)envCtx.lookup("smtp.password");
            
            Authenticator auth = e.new SMTPAuthenticator(smtp_username, smtp_password);
            session = Session.getDefaultInstance(session.getProperties(), auth);
            
            session.setDebug(false);
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress to_address[] = new InternetAddress[to.length];
            for(int i=0; i<to.length; i++)
            	to_address[i] = new InternetAddress(to[i]);
            message.setRecipients(Message.RecipientType.TO, to_address);
            message.setSubject(subject);
            
            // create and fill the first message part
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent(body, "text/html; charset=utf-8");

            // create the second message part
            MimeBodyPart mbp2 = new MimeBodyPart();

            // attach the file to the message
            DataSource source = new ByteArrayDataSource(data, "application/pdf");
            mbp2.setDataHandler(new DataHandler(source));
            mbp2.setFileName(fname);

            // create the Multipart and add its parts to it
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);

            // add the Multipart to the message
            message.setContent(mp);
            
            message.setSentDate(new java.util.Date());
            
            Transport.send(message);
            
            ret = "success";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
            String exStr = ex.getMessage();
            try
            {
                exStr = exStr.substring(exStr.lastIndexOf("]")+1);
            }
            catch(Exception ignore){}
            
            ret = "Error: Could not send the email, Message: " + exStr;
        }
        finally
        {
            //nothing to dispose
        }
        
        return ret;
    }
    
    /**
     * Sends an email to the specified email address with attachment.
     *
     * @param from The from email address.
     * @param to The recipient of the email.
     * @param subject The subject of the email.
     * @param body The message content of the email.
     * @param filename The file to be attached.
     * */
    public static synchronized String sendEmail(String from, String to, String subject,
            String body, String filename)
    {
        String ret = null;
        
        EmailUtil e = new EmailUtil();
        
        try
        {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            Session session = (Session) envCtx.lookup("mail/Session");
            
            String smtp_username = (String)envCtx.lookup("smtp.username");
            String smtp_password = (String)envCtx.lookup("smtp.password");
            
           // System.out.print("smtp_username:"+smtp_username+" smtp_password : "+ smtp_password);
            
            Authenticator auth = e.new SMTPAuthenticator(smtp_username, smtp_password);
            session = Session.getDefaultInstance(session.getProperties(), auth);
            
            session.setDebug(false);
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress to_address[] = new InternetAddress[1];

            to_address[0] = new InternetAddress(to);
            message.setRecipients(Message.RecipientType.TO, to_address);
            message.setSubject(subject);
            
            // create and fill the first message part
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setContent("<!doctype html><html><head><meta charset='utf-8'><title>fetswallet</title><link rel='stylesheet' type='text/css' href='css/bootstrap.css'><script src='js/bootstrap.js'></script><link rel='stylesheet' type='text/css' href='css/bootstrap-theme.css'></head><body bgcolor='#e6e6e6'><div class='panel panel-default' style='width: 600px; margin-top: 30px; margin-left: 476px;'><div class='panel-heading'><h3 class='panel-title'><img src='https://fetswallet.com/images/fetswallet-email.png' width='274' height='89' alt=''/></h3></div>", "text/html");

            // create the second message part
            MimeBodyPart mbp2 = new MimeBodyPart();
            mbp2.setContent(body, "text/html");
            
            MimeBodyPart mbp3 = new MimeBodyPart();
            mbp3.setContent("<p>No more information, please email: customercare@fetswallet.com or call fets customer care on <b>0800-CALL-FETS (0800-2255-3387)</b><br><br><b>NB</b><br> - You can visit our website at fetslimited.com</p><p>Thank you!<br><br><b>Funds &amp; Electronic Transfer Solutions Limited. &copy; 2014</b></p></div></div></body></html>", "text/html");
           

            // create the Multipart and add its parts to it
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);
            mp.addBodyPart(mbp3);

            // add the Multipart to the message
            message.setContent(mp);
            
            message.setSentDate(new java.util.Date());
            
            Transport.send(message);
            
            ret = "success";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
            String exStr = ex.getMessage();
            try
            {
                exStr = exStr.substring(exStr.lastIndexOf("]")+1);
            }
            catch(Exception ignore){}
            
            ret = "Error: Could not send the email, Message: " + exStr;
        }
        finally
        {
            //nothing to dispose
        }
        
        System.out.print("ret : "+ret);
        
        return ret;
    }
    
    /**
     * SimpleAuthenticator is used to do simple authentication
     * when the SMTP server requires it.
     */
    private class SMTPAuthenticator extends Authenticator
    {
        private String SMTP_AUTH_USER;
        private String SMTP_AUTH_PWD;
        
        public SMTPAuthenticator(String SMTP_AUTH_USER, String SMTP_AUTH_PWD)
        {
            this.SMTP_AUTH_USER = SMTP_AUTH_USER;
            this.SMTP_AUTH_PWD = SMTP_AUTH_PWD;
        }
        
        public PasswordAuthentication getPasswordAuthentication()
        {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
