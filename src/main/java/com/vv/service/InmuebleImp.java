package com.vv.service;

import com.vv.model.Inmueble;
import com.vv.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InmuebleImp implements InmuebleService{

    @Autowired
    InmuebleRepository inmuebleRepository;

    @Override
    public List<Inmueble> obtenerListaInmuebles() {
        return (List<Inmueble>)inmuebleRepository.findAll();
    }

    @Override
    public Inmueble obtenerInmueble(String inmueble) {
        return inmuebleRepository.findById(inmueble).get();
    }

    @Override
    public void borrarInmueble(String nombreInmueble) {
        try{inmuebleRepository.deleteById(nombreInmueble);}
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void guardarEditarInmueble(Inmueble inmueble) {
        try{
            inmueble.setCodigInmueble(inmueble.getCodigInmueble().trim());
            inmueble.setDescrInmueble(inmueble.getDescrInmueble().trim());
            inmuebleRepository.save(inmueble);}catch (Exception e){e.printStackTrace();}
    }
}
