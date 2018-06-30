package com.vv.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gastos")
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_gastos")
    long codigGastos;
    @Column(name = "descr")
    String descrGastos;
    @Column(name = "iffijo")
    Boolean isfijo;

    //uno a muchos con la tabla detalles gasto inmueble
    @OneToMany(mappedBy = "codigGastos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<DetallesGastosInmueble> detallesGastosInmuebles;

    public long getCodigGastos() {
        return codigGastos;
    }

    public void setCodigGastos(long codigGastos) {
        this.codigGastos = codigGastos;
    }

    public String getDescrGastos() {
        return descrGastos;
    }

    public void setDescrGastos(String descrGastos) {
        this.descrGastos = descrGastos;
    }

    public Boolean getIsfijo() {
        return isfijo;
    }

    public void setIsfijo(Boolean isfijo) {
        this.isfijo = isfijo;
    }
}