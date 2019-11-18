package de.hska.iwi.vslab.Core_User.Services;

import de.hska.iwi.vslab.Core_User.Interfaces.UserRepository;
import de.hska.iwi.vslab.Core_User.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> getAllUsers(){
        List users = new ArrayList<User>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    public User getUser(String name){
        return userRepo.findByUsername(name);
    }

    public User getUser(int id){
        return userRepo.findById(id);
    }

    public void addUser(User user){
        userRepo.save(user);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }

    public long deleteAllUsers(){
        long deleted = 0;
        for(User user: userRepo.findAll())
            deleted += userRepo.deleteById(user.getId());
        return deleted;
    }

    public long deleteUser(String name){
        return userRepo.deleteByUsername(name);
    }

    public long deleteUser(int id){
        return userRepo.deleteById(id);
    }

}
