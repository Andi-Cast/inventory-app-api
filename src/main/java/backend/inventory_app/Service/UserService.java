package backend.inventory_app.Service;

import backend.inventory_app.Model.Role;
import backend.inventory_app.Model.User;
import backend.inventory_app.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Member not found."));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) throws IllegalArgumentException {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        User newUser = new User(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getRole());
        return userRepository.save(newUser);
    }

    public User deleteUser(String id) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent())   {
            User user = userOpt.get();
            userRepository.delete(user);
            return user;
        } else {
            throw new IllegalArgumentException(STR."User was not found with id: \{id}");
        }
    }

    public User updateUser(String id, User user) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent())   {
            User userVar = userOpt.get();

            if(user.getFirstname() != null) {
                userVar.setFirstname(user.getFirstname());
            }

            if(user.getLastname() != null) {
                userVar.setLastname(user.getLastname());
            }

            if(user.getUsername() != null) {
                userVar.setUsername(user.getUsername());
            }

            if(user.getRole() != null) {
                try{
                    userVar.setRole(Role.valueOf(String.valueOf(user.getRole()).toUpperCase()));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(STR."Invalid role: \{user.getRole()}");
                }
            }

            return userRepository.save(userVar);
        } else {
            throw new IllegalArgumentException(STR."User was not found with id: \{id}");
        }
    }
}
