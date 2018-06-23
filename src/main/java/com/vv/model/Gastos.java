package com.vv.model;

import javax.persistence.*;

@Entity
@Table(name="gastos")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_gastos")
    long codigGastos;
    @Column(name = "descr_gastos")
    String descrGastos;
    @Column(name = "iffijo_gastos")
    Boolean isfijo;

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

    public Boolean isIsfijo() {
        return isfijo;
    }

    public void setIsfijo(Boolean isfijo) {
        this.isfijo = isfijo;
    }
}