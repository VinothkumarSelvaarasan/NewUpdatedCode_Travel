package com.wecp.travelmanagementsystem.Controller;

import com.wecp.travelmanagementsystem.dto.LoginRequest;
import com.wecp.travelmanagementsystem.dto.LoginResponse;
import com.wecp.travelmanagementsystem.entity.Business;
import com.wecp.travelmanagementsystem.entity.Customer;
import com.wecp.travelmanagementsystem.entity.User;
import com.wecp.travelmanagementsystem.jwt.JwtUtil;
import com.wecp.travelmanagementsystem.service.BusinessService;
import com.wecp.travelmanagementsystem.service.CustomerService;
import com.wecp.travelmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class RegisterAndLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
          //Complete Code
       
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
         //Complete Code


}
