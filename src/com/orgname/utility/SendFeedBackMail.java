package com.orgname.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.orgname.vo.MailVO;

public class SendFeedBackMail {

	public void sendMail(MailVO mailVO) {

		final String username = "rdl_rjy@yahoo.com";
		final String password = "spvt5088";

		Properties props = new Properties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mail.yahoo.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rdl_rjy@yahoo.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailVO.getEmailID().toString()));
			message.setSubject("Feedback by " + mailVO.getName());
			message.setText(mailVO.getFeedback());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
