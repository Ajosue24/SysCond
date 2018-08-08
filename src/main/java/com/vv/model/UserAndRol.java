package com.vv.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario_sistema")
public class UserAndRol {

    @Id
    @NotNull
    @Column(name="user_id")
    String idUsuario;
    @Column(name="password")
    String password;
    @Column(name="habilitado")
    Boolean habilitado;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

}
