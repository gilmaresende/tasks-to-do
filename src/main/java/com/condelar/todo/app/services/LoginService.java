package com.condelar.todo.app.services;

import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.repositories.LoginRepository;
import com.condelar.todo.struct.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService extends BaseService<LoginRepository, Login> {

    public Login findByLogin(String login){
        Optional<Login> op = getRespository().findByLogin(login);
        return op.get();
    }

}
