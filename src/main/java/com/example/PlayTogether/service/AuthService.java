package com.example.PlayTogether.service;

public interface AuthService {
    boolean validateCredentials(String username, String password);
}