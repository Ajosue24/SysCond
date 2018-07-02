package com.vv.service;

import com.vv.model.Gastos;
import com.vv.repository.GastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Colocar las anotaciones para usar el autowired
 * @Service
 * @Transactional(Obligatorio)
 */
@Service
@Transactional
public class GastosServiceImpl implements GastosService {

    @Autowired
    GastosRepository gastosRepository;



    @Override
    public List<Gastos> listaGastos() {
        return (List<Gastos>)gastosRepository.findAll();
    }

    @Override
    public void actualizaYGuarda(Gastos gastos) {
        try {
            gastosRepository.save(gastos);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminarGasto(long idGastos) {
        try {
            gastosRepository.deleteById(idGastos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Gastos obtenerGasto(long idGastos) {
        return gastosRepository.findById(idGastos).get();
    }

    public List<Gastos> filtraDescripcionLike(String descripcion){
        List<Gastos> listaGastos = gastosRepository.findByDescrGastosContainingIgnoreCase(descripcion);
        return listaGastos;
    }

}