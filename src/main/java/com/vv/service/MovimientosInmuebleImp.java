package com.vv.service;

import com.vv.model.GastosInmueble;
import com.vv.model.Inmueble;
import com.vv.model.MovimientosInmuebles;
import com.vv.repository.MovimientosInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovimientosInmuebleImp implements MovimientosInmuebleService{

    @Autowired
    MovimientosInmuebleRepository movimientosInmuebleRepository;

    @Override
    public void guardarMovimientosInmueble(MovimientosInmuebles movimientosInmuebles) {
        movimientosInmuebleRepository.save(movimientosInmuebles);
    }

    @Override
    public List<MovimientosInmuebles> listarPorNumeroDeRecibo(GastosInmueble numeroRecibo) {
        return movimientosInmuebleRepository.findAllByCodigGastosInmuebleEquals(numeroRecibo);
    }

    @Override
    public MovimientosInmuebles obtenerMovPorReciboEInmueble(GastosInmueble numeroRecibo, Inmueble inmueble) {
        return movimientosInmuebleRepository.findByCodigGastosInmuebleAndCodigInmueble(numeroRecibo,inmueble);
    }


}
