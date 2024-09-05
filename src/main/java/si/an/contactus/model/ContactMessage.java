package si.an.contactus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.ZonedDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_messages")
public class ContactMessage {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Message cannot be null")
    @Size(min = 1, max = 500, message = "Message must be between 1 and 500 characters")
    @Column(nullable = false)
    private String message;

    @NotNull
    @Column(name = "sent_at", nullable = false)
    private ZonedDateTime sentAt = ZonedDateTime.now();
}
