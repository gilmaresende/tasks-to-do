package com.condelar.todo.struct;


import java.io.Serializable;
import java.time.LocalDate;

public abstract class BaseEntidade implements Serializable {

    public abstract LocalDate getDataCadastro();

    public abstract void setDataCadastro(LocalDate dataCadastro);

}
