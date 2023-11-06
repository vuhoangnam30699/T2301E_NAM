package fpt;

import org.apache.commons.text.StringSubstitutor;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Nam1", "Vũ", LocalDate.of(1999, 1, 2), "Ba Dinh, Ha Noi", "vuhoangnam0001@gmail.com"));
        customers.add(new Customer(2, "Nam2", "Vũ", LocalDate.of(2000, 2, 3), "Hoan Kiem, Ha Noi", "vuhoangnam0003@gmail.com"));
        customers.add(new Customer(3, "Nam3", "Vũ", LocalDate.of(2001, 3, 4), "Hoang Mai, Ha Noi", "vuhoangnam0002@gmail.com"));

        for (Customer customer : customers) {
            Map<String, Object> subtitutors = new HashMap<>();
            subtitutors.put("firstName", customer.getFirstName());
            subtitutors.put("lastName", customer.getLastName());
            subtitutors.put("address", customer.getAddress());
            System.out.println(subtitutors);
            sendEmail(customer.getEmail(), "HAPPY_NEW_YEAR", subtitutors);

        }
    }

    public static void sendEmail(String recipient, String templateCode, Map<String, Object> substitutors) {
        List<EmailTemplate> emailTemplates = List.of(
                new EmailTemplate(1, "HAPPY_NEW_YEAR", "Chúc mừng năm mới", "<p>Ch&agrave;o ${firstName} ${lastName},</p> <p>Nh&acirc;n ng&agrave;y đầu năm mới, ch&uacute;c sức khoẻ qu&yacute; kh&aacute;ch. C&ocirc;ng ty ch&uacute;ng t&ocirc;i c&oacute; một phần qu&agrave; gửi đến qu&yacute; kh&aacute;ch.</p> <p>Vui l&ograve;ng x&aacute;c nhận địa chỉ &ldquo;${address}&rdquo; l&agrave; ch&iacute;nh x&aacute;c bằng c&aacute;ch trả lời email n&agrave;y.</p> <p>Tr&acirc;n trọng,</p> <p>FPT Aptech</p> <p><img src=\"https://inkythuatso.com/uploads/thumbnails/800/2021/11/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg\" alt=\"\" /></p>"),
                new EmailTemplate(2, "WELCOME", "Chào bạn", "Chào"),
                new EmailTemplate(3, "PAYMENT_REQUIRED", "Yêu cầu thanh toán", "Xin chào ${firstName} ${lastName}, trả tiền đi")
        );

        Optional<EmailTemplate> emailTemplate = emailTemplates.stream().filter(e -> e.getCode().equals(templateCode))
                .findFirst();

        if (emailTemplate.isEmpty()) {
            return;
        }

        String subject = emailTemplate.get().getSubject();
        String body = emailTemplate.get().getBody();
        String customerBody = StringSubstitutor.replace(body, substitutors);

        final String fromEmail = "vuhoangnam30699@gmail.com"; //requires valid gmail id
        final String password = "vyed lvyb yxdj vwwh"; // correct password for gmail id

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

        EmailUtil.sendEmail(session, recipient, subject, customerBody);


    }

}