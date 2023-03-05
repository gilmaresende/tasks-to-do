package com.condelar.todo.config;

import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Start {

    @Autowired
    LoginService loginService;

    @Bean
    public void init(){
        Login l = new Login();
        l.setDataCadastro(LocalDate.now());
        l.setLogin("gflr");
        l.setPassword("123");

       l = loginService.save(l);

        System.out.println(l);
    }
}
