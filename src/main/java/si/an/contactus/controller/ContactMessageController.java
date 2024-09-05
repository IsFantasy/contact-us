package si.an.contactus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.an.contactus.model.ContactMessage;
import si.an.contactus.services.ContactMessageService;

import java.util.stream.Collectors;

@RestController
@Tag(name = "Contact Us", description = "Endpoint for submitting a contact message. The request body must contain the contact details in JSON format, which will be processed and stored. Upon success, a confirmation message is returned. In case of failure, an error response is provided.")
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping("/api/v1/contact-us")
    @Operation(summary = "Submit a contact message", description = "Receives a contact message from the client, processes it, and stores it. Returns a success message upon successful processing, or an error message in case of failure.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Message sent successfully", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Error sending message", content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> submitContactForm(
            @Valid @RequestBody ContactMessage contactMessage, BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body("Validation failed: " + errorMessage);
        }

        try {
            contactMessageService.saveMessage(contactMessage);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending message");
        }
    }
}
