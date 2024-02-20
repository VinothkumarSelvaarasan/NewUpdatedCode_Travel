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
        User registeredUser = userService.registerUser(user);
        if (registeredUser.getUserType().equals("BLOGGERS")) {
            Business business = new Business();

            business.setName(registeredUser.getUsername());
            business.setEmail(user.getEmail());
            businessService.registerBusiness(business);
            return ResponseEntity.ok(business);
        } else  {
            Customer customer = new Customer();
            customer.setName(registeredUser.getUsername());
            customer.setEmail(user.getEmail());
            return ResponseEntity.ok(customerService.createCustomer(customer));
        }

       
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails.getUsername());
        User user = userService.getUserByUsername(loginRequest.getUsername());
        return ResponseEntity.ok(new LoginResponse(token,user.getId(), user.getUsername(), user.getEmail(), user.getUserType()));
    }


}
