package user.model;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class EmailSender {

    /**
     *
     * @param toEmail
     * @param subject
     * @param body
     */
    public void sendRegistrationEmail(String toEmail, String subject, String body) {
        Email email = EmailBuilder.startingBlank()
                .from("Luxury Leisure Hotel (LLH)", "email")
                .to(toEmail)
                .withSubject(subject)
                .withPlainText(body)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.office365.com", 587, "email", "password")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);
        System.out.println("Email sent successfully to " + toEmail);
    }
}
