package de.hska.iwi.vslab.Core_User.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private int roleId;

    public User() {
    }

    public User(String username, String firstname, String lastname, String password, int roleId) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username='%s', firstname='%s', lastname='%s', password='%s', roleId=%d]", id, username, firstname, lastname, password, roleId);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public int getRoleId() {
        return roleId;
    }
}