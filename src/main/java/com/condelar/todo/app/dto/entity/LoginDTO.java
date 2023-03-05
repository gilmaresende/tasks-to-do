package com.condelar.todo.app.dto.entity;

import com.condelar.todo.app.entity.Login;
import lombok.Data;

@Data
public class LoginDTO {
    private String login;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(Login ob) {
        setLogin(ob.getLogin());
        setPassword(ob.getPassword());
    }
}
