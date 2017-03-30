package my.example.cassandra.web;

import my.example.cassandra.entity.User;
import my.example.cassandra.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author olch0615
 *         Date: 3/30/2017
 *         Time: 5:27 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Map<String, String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return Collections.singletonMap("status", "true");
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

}