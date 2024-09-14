package backend.inventory_app.Service;

import backend.inventory_app.Model.AuthenticationResponse;
import backend.inventory_app.Model.User;
import backend.inventory_app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new DataIntegrityViolationException("Username already exists.");
        }
        User user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole());
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(
                token,
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getRole().toString()
        );
    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(STR."User not found with username: \{request.getUsername()}"));
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(
                token,
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getRole().toString()
        );
    }
}
