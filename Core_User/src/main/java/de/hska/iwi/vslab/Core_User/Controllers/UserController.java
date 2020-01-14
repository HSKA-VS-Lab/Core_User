package de.hska.iwi.vslab.Core_User.Controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import de.hska.iwi.vslab.Core_User.Models.User;
import de.hska.iwi.vslab.Core_User.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @HystrixCommand(fallbackMethod = "getFallbackRoles")
    public User[] getAllUsers() {
        try
        {
            return userService.getAllUsers();
        } catch (
                Exception e) {
            return null;
        }
    }

    public User[] getFallbackUsers() {
        User user1 = new User("userFallback1", "max", "mustermann","pw123", 0);
        User user2 = new User("userFallback2", "marie", "musterfrau","pw123", 0);
        User[] userA = new User[2];
        userA[0] = user1;
        userA[1] = user2;
        return userA;
    }

    @GetMapping("/user/{input}")
    public User getUser(@PathVariable String input) {
        // get by username
        if (input.replaceAll("\\d", "").length() > 0) // only digits in input
            return userService.getUser(input);
        // get by id
        else
            return userService.getUser(Integer.parseInt(input));
    }

    private boolean onlyContainsNumbers(String text) {
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @PostMapping(path = "/user", consumes = "application/json")
    public void addUser(@RequestBody(required = true) User user) {
        userService.addUser(user);
    }

    @RequestMapping(path = "/user/{id}", method=RequestMethod.PUT, consumes = "application/json")
    public void updateUser(@PathVariable int id, @RequestBody(required = true) User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/user")
    public void deleteUser() {
        userService.deleteAllUsers();
    }

}
