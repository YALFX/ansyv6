
package edu.sena.sendmail.ansyt;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {

    private String username = "yinsena@outlook.es";
    private String passWord = "Cc147852369";
    private String vmessage = "MENSAJE";
    private Address[] receptores;
    private String subject = "ASUNTO";

    
    
   public void SendMail(String personas) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", 587);
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passWord);
            }
        }
        );
        
        
           try {
//            receptores = 
//            new Address[]{new InternetAddress("jarincon808@misena.edu.co")           
//            };
            receptores = 
            new Address[]{new InternetAddress("jarincon808@misena.edu.co"),new InternetAddress("ginagonzalez005@gmail.com")};
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            String[] recipientsList = personas.split(",");
            InternetAddress[] recipientsAddress = new InternetAddress[recipientsList.length];
            int count = 0;
            for(String recipient : recipientsList){
                recipientsAddress[count] = new InternetAddress(recipient.trim());
                count ++;
            };
            message.setRecipients(Message.RecipientType.TO, recipientsAddress);
            message.setSubject(subject);
            message.setText(this.vmessage);
            Transport.send(message);
           
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
   

    public void setVmessage(String vmessage) {
        this.vmessage = vmessage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    

}
