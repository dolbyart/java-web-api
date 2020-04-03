package com.exn5.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "USERS")

public class User {
    private UUID userId;
    private String fullName;
    private String password;
    private String email;
    private String token;
    private Date created;

    public User() {
    }

    public User(UUID userId, String fullName, String password, String email, String token, Date created) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.token = token;
        this.created = created;
    }

    /*public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
    }*/

    @Id
    @Column(name = "USERID", unique = true, nullable = true)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Column(name = "FULLNAME", nullable = false, length = 500)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "PASSWORD", nullable = false, length = 125)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "EMAIL", nullable = false, unique = true, length = 250)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "CREATED", nullable = true)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        // return super.toString();
        return "User [userId=" + userId + ", fullName=" + fullName + ", password=" + password + ", email=" + email
                + ", token=" + token + ", created=" + created + "]";
    }


}
