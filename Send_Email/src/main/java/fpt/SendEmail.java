package fpt;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "vuhoangnam30699@gmail.com"; //requires valid gmail id
        final String password = "vyed lvyb yxdj vwwh"; // correct password for gmail id
        final String toEmail = "vuhoangnam0001@gmail.com"; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject",
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<title>Send Email Tutorial</title>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h1>VU HOANG NAM</h1>\n" +
                        "<p>T2301E</p>\n" +
                        "<img src=\"https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1119px-Java_programming_language_logo.svg.png\"  width=\"500\" height=\"600\">" +
                        "\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
