package com.topguide.topguide.model;

/**
 * Created by Igor on 6/20/2017.
 */

public class User {

    public enum Role {
        TOURIST,
        GUIDE,
        GUEST
    }

    private String username;

    private String password;

    private Role role;

    public User() {
        username = null;
        password = null;
        role = Role.GUEST;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        switch (role) {
            case 0:
                this.role = Role.TOURIST;
                break;
            case 1:
                this.role = Role.GUIDE;
                break;
            default:
                this.role = Role.GUEST;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
