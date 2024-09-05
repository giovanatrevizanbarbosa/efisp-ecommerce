package efisp.efispecommerce.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {
    private final String host;
    private final String port;
    private final String username;
    private final String password;

    public EmailSender() throws IOException {
        Properties props = new Properties();
        String configFilePath = Util.CONFIG_FILE.value() + "/config.properties";
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            props.load(input);
        }

        this.host = "smtp.gmail.com";
        this.port = "587";
        this.username = props.getProperty("email.username");
        this.password = props.getProperty("email.password");
    }

    public void sendEmail(String toEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
