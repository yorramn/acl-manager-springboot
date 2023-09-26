package com.yorramn.gerenciaacl.controllers;

import com.yorramn.gerenciaacl.requests.UserRequest;
import com.yorramn.gerenciaacl.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String findAll() {
        System.out.println("oi");
        return "Salve";
    }

    @PostMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<Object> save(@RequestBody @Valid UserRequest userRequest) {
        var user = this.userService.save(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
