package com.example.investmentapp.controller;

import com.example.investmentapp.repository.UserRepository;
import com.example.investmentapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    //private final UserRepository userRepository;
    private UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;
/*
    @Autowired
    public UserController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

 */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(userRepository.findByUsername(user.getUsername())!= null){
            return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует.");
        }
        userRepository.save(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован.");
    }
    @GetMapping("/register")
    public ResponseEntity<String> handleGetRequest(){
        return ResponseEntity.badRequest().body("Метод GET не поддерживается для этого эндпоинта. Используйте POST.");
    }

    /*public User registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

     */
}
