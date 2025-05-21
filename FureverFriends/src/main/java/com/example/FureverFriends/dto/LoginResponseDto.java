package com.example.FureverFriends.dto;

public class LoginResponseDto {
    private String token;
    private long id;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    
}
