package com.wecp.logisticsmanagementandtrackingsystem.jwt;


import com.wecp.logisticsmanagementandtrackingsystem.entity.User;
import com.wecp.logisticsmanagementandtrackingsystem.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtil {

    private UserRepository userRepository;

    @Autowired
    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final String secret = "secretKey000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    private final int expiration = 86400;

    public String generateToken(String username) {
        // method to generate token
    }

    public Claims extractAllClaims(String token) {
        // extract all claims from token

    }

    public String extractUsername(String token) {
       // extract username from token
    }

    public boolean isTokenExpired(String token) {
        // check if token is expired
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        // validate token
    }
}