package com.example.demo.controller;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.entity.ApplicationUserRole;
import com.example.demo.entity.dto.JwtResponse;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.repo.ApplicationUserRepository;
import com.example.demo.repo.ApplicationUserRoleRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final ApplicationUserRepository userRepository;
    private final ApplicationUserRoleRepository roleRepository;

    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor("SECUREOFFNOSECURITYSECUREOFFNOSECURITYSECUREOFFNOSECURITYSECUREOFFNOSECURITYSECUREOFFNOSECURITYSECUREOFFNOSECURITY".getBytes());
    }
    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO user){
        ApplicationUserRole role = roleRepository.findFirstByName("USER");

        String token = Jwts.builder()
                        .setSubject(user.getUsername())// setting the username
                        .claim("authorities", Set.of(role))                  //
                        // setting the authority
                        .setIssuedAt(new Date())                                                    // issued at current time
                        .setExpiration(java.sql.Date.valueOf(
                                        LocalDate.now().plusDays(7)
                        ))                                                                          // setting the expiration date to  2 weeks
                        .signWith(secretKey())
                        // signing with
                                        // the secret key
                        .compact();

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register") // register a new user ,expects {username,password} object
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user)  {

        String name = user.getUsername();
        String email = user.getUsername();

        ApplicationUserRole role = roleRepository.findFirstByName("USER");
        ApplicationUser user1= ApplicationUser.builder()
                        .email(name)
                        .password(email)
                        .roles(Set.of(role))
                        .build();

            userRepository.save(user1);

            String token = Jwts.builder()
                        .setSubject(user1.getEmail())                                           // setting the username
                        .claim("authorities", Set.of(role))                  //
                        // setting the authority
                        .setIssuedAt(new Date())                                                    // issued at current time
                        .setExpiration(java.sql.Date.valueOf(
                                        LocalDate.now().plusDays(7)
                        ))                                                                          // setting the expiration date to  2 weeks
                        .signWith(secretKey())                                                        // signing with
                                        // the secret key
                        .compact();
            return ResponseEntity.ok(new JwtResponse(token));
    }
}
