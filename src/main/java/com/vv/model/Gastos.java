package com.vv.model;

import javax.persistence.*;

@Entity
@Table(name="gastos")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_gastos")
    long idGastos ;
    @Column(name="nombre")
    String nombre;
    @Column(name ="descripcion")
    String descripcion;

    public long getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(long idGastos) {
        this.idGastos = idGastos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
