package pl.podwikagrzegorz.MovieRentalServer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.podwikagrzegorz.MovieRentalServer.model.User;
import pl.podwikagrzegorz.MovieRentalServer.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody
    int addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @PostMapping(path = "/loginUser")
    public @ResponseBody
    String loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
