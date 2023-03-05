package com.condelar.todo.app.repositories;

import com.condelar.todo.app.entity.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends MongoRepository<Login, String> {

    Optional<Login> findByLogin(String login);

}
