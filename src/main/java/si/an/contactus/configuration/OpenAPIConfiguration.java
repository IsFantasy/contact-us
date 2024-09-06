package si.an.contactus.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       Server server = new Server();
       server.setUrl("https://api-contact-us.netlify.app");
       server.setDescription("Development");

       Contact myContact = new Contact();
       myContact.setName("IsFantasy");
       myContact.setEmail("antoniopaiva2608@gmail.com");

       Info information = new Info()
               .title("Contact Us API")
               .version("1.0")
               .description("This API will help you send messages through a contact us form.")
               .contact(myContact);
       return new OpenAPI().info(information).servers(List.of(server));
   }
}