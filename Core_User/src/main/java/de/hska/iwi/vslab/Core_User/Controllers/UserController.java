package de.hska.iwi.vslab.Core_User.Controllers;

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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{input}")
    public User getUser(@PathVariable String input) {
        // get by username
        if(input.replaceAll("\\d","").length() > 0) // only digits in input
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

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/user")
    public void deleteUser(){
        userService.deleteAllUsers();
    }

}
