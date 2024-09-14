package backend.inventory_app.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String role;

}
