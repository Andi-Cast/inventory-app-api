package backend.inventory_app.Controller;

import backend.inventory_app.Model.User;
import backend.inventory_app.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
