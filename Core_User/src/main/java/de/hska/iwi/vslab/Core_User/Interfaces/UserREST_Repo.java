package de.hska.iwi.vslab.Core_User.Interfaces;

import de.hska.iwi.vslab.Core_User.Models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserREST_Repo extends PagingAndSortingRepository<User, Long> {

    List<User> findByUsername(@Param("username") String username);

    List<User> findAll();
}