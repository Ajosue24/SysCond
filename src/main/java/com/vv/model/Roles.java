package com.vv.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="authorities")
public class Roles {

        @Id
        @Column(name="user_id")
        String idUsuario;
        @Column(name="authority")
        String authority;


    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<UserAndRol> userAndRols;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<UserAndRol> getUserAndRols() {
        return userAndRols;
    }

    public void setUserAndRols(List<UserAndRol> userAndRols) {
        this.userAndRols = userAndRols;
    }
}
