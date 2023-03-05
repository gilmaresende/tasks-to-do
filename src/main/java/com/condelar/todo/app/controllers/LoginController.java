package com.condelar.todo.app.controllers;

import com.condelar.todo.app.dto.entity.LoginDTO;
import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.services.LoginService;
import com.condelar.todo.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping
    public List<Login> getAll() {
        return service.getAll();
    }

    @PostMapping("/logar")
    public String logar(@RequestBody LoginDTO dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getLogin(),
                dto.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        Login usuario = (Login) authentication.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

    @PostMapping("/save")
    public Login save(@RequestBody LoginDTO dto) {

        dto.setPassword(encoder.encode(dto.getLogin()));

        Login ob = new Login();
        ob.setLogin(dto.getLogin());
        ob.setPassword(dto.getPassword());

        ob = service.save(ob);

        return ob;
    }

}
