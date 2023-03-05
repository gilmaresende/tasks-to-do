package com.condelar.todo.app.controllers;

import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping
    public List<Login> getAll() {
        return service.getAll();
    }

}
