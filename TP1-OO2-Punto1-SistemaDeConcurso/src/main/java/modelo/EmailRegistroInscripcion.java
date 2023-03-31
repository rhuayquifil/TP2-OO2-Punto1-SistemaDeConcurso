package modelo;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailRegistroInscripcion implements Notificacion {

	private String email;

	public EmailRegistroInscripcion(String email) {
		super();
		this.email = email;
	}

	@Override
	public void enviarCorreo() {
		// provide recipient's email ID
		String correoDestinatario = email;

		// provide sender's email ID
		String from = "miPrimerPruebaEmail@rodrigohuayquifil.com";

		// provide Mailtrap's username
		final String username = "524def57d07409";

		// provide Mailtrap's password
		final String password = "a0f84bcbd4913c";

		// provide Mailtrap's host address
		String host = "sandbox.smtp.mailtrap.io";

		// configure Mailtrap's SMTP server details
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// create the Session object
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(from));
			// set To email field
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
			// set email subject field
			message.setSubject("yepa");
			// set the content of the email message
			message.setText("anasheiiiiii");
			// send the email message
			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
