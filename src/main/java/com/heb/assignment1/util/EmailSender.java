/**
 * @author Bob Stofko
 * @version $1.0$
 */
 
package com.heb.assignment1.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String recipient, String sender, String subjectLine, String messageText, String smtpHost) {

        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "false");
            //Put below to false, if no https is needed
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", smtpHost);
            properties.put("mail.smtp.port", 25);

            Session session = Session.getInstance(properties);

            // -- Create a new message --
            Message message = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));

            // -- Set the subject and body text --
            message.setSubject(subjectLine);
            message.setText(messageText);
            message.setSentDate(new Date());

            // -- Send the message --
            Transport.send(message);
            //logger.info("\n\n...Email sent to " + to + "\n");

        } catch (Exception e) {
            //logger.error(errors + "\n ...Email failed ");
        }
    }
}
