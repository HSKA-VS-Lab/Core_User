package de.hska.iwi.vslab.Core_User.Interfaces;

import de.hska.iwi.vslab.Core_User.Models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();

    User findById(int id);

    long deleteById(int id);

    long deleteByUsername(String username);
}