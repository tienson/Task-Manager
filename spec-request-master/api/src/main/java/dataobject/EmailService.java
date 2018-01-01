package dataobject;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import config.Config;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmailService {

    private static String from = Config.USERNAME_EMAIL;  // GMail user name (just the part before "@gmail.com")
    private static String pass = Config.PASSWORD_EMAIL; // GMail password

    public void sendFromGMail(String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        
        System.out.println("1");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            System.out.println("2");
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            System.out.println("3");
            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            System.out.println("4");

            message.setSubject(subject, "utf-8");
            message.setText(body, "utf-8");
            System.out.println("5");
            Transport transport = session.getTransport("smtp");
            System.out.println("6");
            transport.connect(host, from, pass);
            System.out.println("7");
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("8");
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
