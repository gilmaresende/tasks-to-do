package com.condelar.todo.struct;

import com.condelar.todo.app.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public abstract class BaseService<Respository extends JpaRepository, Entidade extends BaseEntidade> {

    @Autowired
    private Respository respository;

    public Respository getRespository() {
        return respository;
    }

    public Entidade save(Entidade ob) {

        if (ob.getDataCadastro() == null) {
            ob.setDataCadastro(LocalDate.now());
        }
        return (Entidade) respository.save(ob);
    }

    public List<Entidade> getAll() {
        return getRespository().findAll();
    }

}
