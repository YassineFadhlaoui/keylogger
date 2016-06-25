package com.sassouki.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mailMe {
 
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage msg;
 
 
    public void generateAndSendEmail(Session session, String toEmail, String subject,
            String body,String filename) {
        try {
            MimeMessage crunchifyMessage = new MimeMessage(session);
            crunchifyMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
            crunchifyMessage.addHeader("format", "flowed");
            crunchifyMessage.addHeader("Content-Transfer-Encoding", "8bit");
 
            crunchifyMessage.setFrom(new InternetAddress("mailId@gmail.com",
                    "Anonymous"));
            crunchifyMessage.setReplyTo(InternetAddress.parse("receiver@gmail.com", false));
            crunchifyMessage.setSubject(subject, "UTF-8");
            crunchifyMessage.setSentDate(new Date());
            crunchifyMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail, false));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
 
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<br><h3>Here is the file</h3>"
                    , "text/html");
            multipart.addBodyPart(messageBodyPart);
            crunchifyMessage.setContent(multipart);

            Transport.send(crunchifyMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
