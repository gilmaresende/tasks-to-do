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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.condelar.todo.app.tools.ToolBase.isNull;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private LoginService service;

    @PostMapping("/logar")
    public String logar(@RequestBody LoginDTO dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getLogin(),
                dto.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        Login usuario = (Login) authentication.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

    @PostMapping("/save")
    public LoginDTO save(@RequestBody LoginDTO dto) {
        Login ob = null;
        if (!isNull(dto.getId())) {
            ob = service.get(dto.getId());
        } else {
            ob = service.newOb();
        }
        ob = service.toOb(dto, ob);
        ob.setPassword(encoder.encode(ob.getPassword()));
        ob = service.save(ob);
        dto = service.toDTO(ob);
        return dto;
    }


}
