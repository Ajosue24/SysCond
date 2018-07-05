package com.vv.service;

/**
 * Implementacion
 */

import com.vv.model.TipoInmueble;
import com.vv.repository.TipoInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoInmuebleServiceImpl implements TipoInmuebleService {

    @Autowired
    TipoInmuebleRepository tipoInmuebleRepository;

    @Override
    public List<TipoInmueble> listaTipoInmueble() {
        return (List<TipoInmueble>)tipoInmuebleRepository.findAll();
    }
    @Override
    public void actualizaYGuarda(TipoInmueble tipoInmueble){
        try {
            tipoInmuebleRepository.save(tipoInmueble);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void eliminarTipoInmueble(long idTipoInmueble) {
        try{
            tipoInmuebleRepository.deleteById(idTipoInmueble);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public TipoInmueble obtenerTipoInmueble(long idTipoInmueble) {
        return tipoInmuebleRepository.findById(idTipoInmueble).get();
    }
}
