package com.example.netflix.controllers;

import com.example.netflix.models.UserModel;
import com.example.netflix.services.UserService;
import com.example.netflix.utils.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    public UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {return ResponseEntity.ok(userService.getUserById(id));}

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return  ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody AuthDTO authDTO) throws Exception {
        return ResponseEntity.ok(userService.register(authDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody AuthDTO authDTO) throws Exception {
        return ResponseEntity.ok(userService.login(authDTO));
    }

    @PostMapping("/unregister")
    @Transactional
    public ResponseEntity<String> unregister(@RequestBody AuthDTO authDTO) throws Exception {
        return ResponseEntity.ok(userService.unregister(authDTO));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private ResponseEntity<String> handleAllExceptions(Exception e, WebRequest wr) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
