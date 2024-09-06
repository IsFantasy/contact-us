package si.an.contactus.services;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void saveMessage(ContactMessage contactMessage) {
        ContactMessage savedMessage = contactMessageRepository.save(contactMessage);
        sendContactEmail(savedMessage);

    }

    private void sendContactEmail(ContactMessage contactMessage) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo("antonipaiva2608@gmail.com");
        mailMessage.setSubject("New contact message received");
        mailMessage.setText("You have received a new contact message:\n\n" +
                            "Name: " + contactMessage.getName() + "\n" +
                            "Mail: " + contactMessage.getEmail() + "\n" +
                            "Message: " + contactMessage.getMessage() + "\n" +
                            "Sent in: " + contactMessage.getSentAt());

        mailSender.send(mailMessage);
    }
}
