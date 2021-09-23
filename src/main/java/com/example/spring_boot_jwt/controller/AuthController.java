package com.example.spring_boot_jwt.controller;

import com.example.spring_boot_jwt.authen.UserPrincipal;
import com.example.spring_boot_jwt.entities.Token;
import com.example.spring_boot_jwt.entities.User;
import com.example.spring_boot_jwt.services.TokenService;
import com.example.spring_boot_jwt.services.UserService;
import com.example.spring_boot_jwt.until.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (userService.createUser(user) != null) {
            UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
            Token token = new Token();
            token.setToken(jwtUtil.generateToken(userPrincipal));
            token.setTokenExpDate(jwtUtil.generateExpirationDate());
            token.setCreatedBy(userPrincipal.getUserId());
            tokenService.createToken(token);

            return  ResponseEntity.ok(token.getToken());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Account or password is not valid!");
    }

}
