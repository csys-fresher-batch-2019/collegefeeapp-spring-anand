package com.chainsys.collegefeeregister.util;

import java.io.IOException;
import java.util.Properties;

//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.chainsys.collegefeeregister.payment.PaymentDetail;

public class MailUtil {
	public static void send(final String from, final String password, String to, String sub, PaymentDetail p)
			throws IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.checkserveridentity", true);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			Multipart multipart = messageBody(p);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Mail sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static Multipart messageBody(PaymentDetail p) throws MessagingException {

		BodyPart messageBodyPart2 = new MimeBodyPart();
		messageBodyPart2.setText("STUDENT REGNO: " + p.getRegno() + "\n");
		BodyPart messageBodyPart3 = new MimeBodyPart();
		messageBodyPart3.setText("FEE PAID: " + p.getAmount() + "\n");
		BodyPart messageBodyPart4 = new MimeBodyPart();
		messageBodyPart4.setText("Regards, \nADMIN \nSt.Xavier's College");

		/*
		 * String filename = "SendAttachment.java"; FileDataSource source = new
		 * FileDataSource("./src/test/java/com/chainsys/PayrollApp/SendMailSSL.java");
		 * messageBodyPart2.setDataHandler(new DataHandler(source));
		 * messageBodyPart2.setFileName(filename);
		 */

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart2);
		multipart.addBodyPart(messageBodyPart3);
		multipart.addBodyPart(messageBodyPart4);
		return multipart;

	}

}