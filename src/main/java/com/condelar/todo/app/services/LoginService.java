package com.condelar.todo.app.services;

import com.condelar.todo.app.dto.entity.LoginDTO;
import com.condelar.todo.app.entity.Login;
import com.condelar.todo.app.repositories.LoginRepository;
import com.condelar.todo.struct.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService extends BaseService<LoginRepository, Login, LoginDTO> {

    public Login findByLogin(String login) {
        Optional<Login> op = getRespository().findByLogin(login);
        return op.get();
    }

    @Override
    public Login newOb() {
        return new Login();
    }

    @Override
    public Login toOb(LoginDTO dto, Login ob) {
        ob.setLogin(dto.getLogin());
        ob.setPassword(dto.getPassword());
        return ob;
    }

    @Override
    public LoginDTO toDTO(Login ob) {
        return new LoginDTO(ob);
    }
}
