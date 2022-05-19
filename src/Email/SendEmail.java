package Email;

import java.util.Properties;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;




public class SendEmail {
	String ToEmail = "yusufda3@gmail.com";
	String FromEmail = "kenancngz.300@gmail.com";
	String FromEmailPassword = "Yasufa21";
	String Subject= "Subject";
	
	public SendEmail() {
		System.out.println("Mail gönderiliyor");
	Properties pro = new Properties();

	
	pro.setProperty("mail.transport.protocol", "smtp");
	pro.setProperty("mail.smtp.host", "smtp.gmail.com");
	pro.setProperty("mail.smtp.port", "587");
	pro.setProperty("mail.smtp.user", FromEmail);
	pro.setProperty("mail.smtp.password", FromEmailPassword);
	pro.setProperty("mail.smtp.starttls.enable", "true");
	pro.setProperty("mail.smtp.auth", "true");
	
	

	Session session = Session.getDefaultInstance(pro,
			new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FromEmail, FromEmailPassword);
			}
	});
	
	try {
		
        Transport transport = session.getTransport();

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FromEmail));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
		message.setSubject(Subject);
		message.setText("oldu");
		
		BodyPart msgbody = new MimeBodyPart();
		msgbody.setText("burası mesaj alanı");
		
		MimeBodyPart msgbody2 = new MimeBodyPart();
		String dosyayolu = "C:/Users/yusuf/OneDrive/Masaüstü/tablo.xls";
		DataSource source = new FileDataSource(dosyayolu);
		msgbody2.setDataHandler(new DataHandler(source));
		msgbody2.setFileName(dosyayolu);
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(msgbody);
		multipart.addBodyPart(msgbody2);
		
		message.setContent(multipart);
		
		transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
		
		System.out.println("dfgfdsfds");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
  }
	
}	
