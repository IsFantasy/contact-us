package si.an.contactus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import si.an.contactus.model.ContactMessage;
import si.an.contactus.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${MAIL_CONTACT}")
    private String contactEmail;

    public ContactMessage saveMessage(ContactMessage contactMessage) {
        ContactMessage savedMessage = contactMessageRepository.save(contactMessage);
        sendContactEmail(savedMessage);

        return savedMessage;
    }

    private void sendContactEmail(ContactMessage contactMessage) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(contactEmail);
        mailMessage.setSubject("New contact message received");
        mailMessage.setText("You have received a new contact message:\n\n" +
                            "Name: " + contactMessage.getName() + "\n" +
                            "Mail: " + contactMessage.getEmail() + "\n" +
                            "Message: " + contactMessage.getMessage() + "\n" +
                            "Sent in: " + contactMessage.getSentAt());

        mailSender.send(mailMessage);
    }
}