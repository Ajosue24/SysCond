package com.vv.service;

import com.vv.model.MovimientosInmuebles;
import com.vv.repository.MovimientosInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovimientosInmuebleImp implements MovimientosInmuebleService{

    @Autowired
    MovimientosInmuebleRepository movimientosInmuebleRepository;

    @Override
    public void guardarMovimientosInmueble(MovimientosInmuebles movimientosInmuebles) {
        movimientosInmuebleRepository.save(movimientosInmuebles);
    }
}
