package com.condelar.todo.config;

import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Configuration
public class Start {

    @Autowired
    LoginService loginService;


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public void init() {
        Login l = new Login();
        l.setDataCadastro(LocalDate.now());
        l.setLogin("gflr");
        l.setPassword(encoder.encode("123"));

        l = loginService.save(l);

        System.out.println(l);
    }
}
