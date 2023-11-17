package com.czp.rabbitmqdemo.pojo;

public class User {
    String id;
    String name;
    String email;
    String password;
    String postTime;

    public User(String id, String name, String email, String password, String postTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", postTime='" + postTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPostTime() {
        return postTime;
    }
    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }
}
