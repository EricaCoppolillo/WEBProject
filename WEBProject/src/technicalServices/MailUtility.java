package technicalServices;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

	public class MailUtility
	{
	  public static void sendMail (String dest, String object, String text) throws MessagingException {
     		String host = "smtp.gmail.com";
			String from = "technoworldcustommersservice@gmail.com";
			String pass = "bsuhdwsgqqonqvhu";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			//String to = dest; // added this line
			
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, dest);
			message.setSubject(object);
			message.setText(text);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
	 }
		    

	    // Creazione del messaggio da inviare
	 
	  
	  /*public static void MailerSend() throws MessagingException{
			String host = "smtp.gmail.com";
			String from = "guastalegname64@gmail.com";
			String pass = "mfrrfohxxdulfcox";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true"); // added this line
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			String[] to = {"antonio.agostino97@gmail.com"}; // added this line

			/*Ecco, questa sotto è la riga che genera l'errore.
			Neppure importando org.apache.catalina.Session
			il problema si risolve. Nel dettaglio, dopo aver digitato
			Session Eclipse mi suggerisce alcune alternative
			con l'autocompletamento ma tra queste manca
			getDefaultInstance.

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for( int i=0; i < to.length; i++ ) { // changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
			}
			System.out.println(Message.RecipientType.TO);

			for( int i=0; i < toAddress.length; i++) { // changed from a while loop
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			message.setSubject("GUARDA CHI BOSS!!");
			message.setText("Ma suchi!!");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			}*/
}

	
