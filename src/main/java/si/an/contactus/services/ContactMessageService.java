package si.an.contactus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import si.an.contactus.model.ContactMessage;
import si.an.contactus.repository.ContactMessageRepository;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;
    @Autowired
    private JavaMailSender mailSender;

    public ContactMessage saveMessage(ContactMessage contactMessage) {
        ContactMessage savedMessage = contactMessageRepository.save(contactMessage);

        sendContactEmail(savedMessage);

        return savedMessage;
    }

    private void sendContactEmail(ContactMessage contactMessage) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String contactEmail = "contacto@tuempresa.com";

        mailMessage.setTo(contactEmail);
        mailMessage.setSubject("Nuevo mensaje de contacto recibido");
        mailMessage.setText("Has recibido un nuevo mensaje de contacto:\n\n" +
                            "Nombre: " + contactMessage.getName() + "\n" +
                            "Email: " + contactMessage.getEmail() + "\n" +
                            "Mensaje: " + contactMessage.getMessage() + "\n" +
                            "Enviado en: " + contactMessage.getSentAt());

        mailSender.send(mailMessage);
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    public ContactMessage getMessageById(Long id) {
        return contactMessageRepository.findById(id).orElse(null);
    }

    public void deleteMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}