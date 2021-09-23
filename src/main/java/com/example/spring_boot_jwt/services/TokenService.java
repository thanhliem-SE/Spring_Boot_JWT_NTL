package com.example.spring_boot_jwt.services;

import com.example.spring_boot_jwt.entities.Token;

public interface TokenService {
    public Token createToken(Token token);
}
