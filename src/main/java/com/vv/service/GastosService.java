package com.vv.service;

import com.vv.model.Gastos;

import java.util.List;

public interface GastosService {

    public List<Gastos> listaGastos();
    public void actualizaYGuarda(Gastos gastos);
    public void eliminarGasto(long idGastos);

    public Gastos obtenerGasto(long idGastos);

    public List<Gastos> filtraDescripcionLike(String descripcion);

}
