package backend.inventory_app.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Setter
@Getter
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }
}
