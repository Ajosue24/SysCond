package com.vv.service;

import com.vv.model.GastosInmueble;
import com.vv.repository.GastosInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GastosInmuebleImpl implements GastosInmuebleService{

    @Autowired
    GastosInmuebleRepository gastosInmuebleRepository;


    @Override
    public void guardarActualizarGastoInmueble(GastosInmueble gastosInmueble) {
        gastosInmuebleRepository.save(gastosInmueble);
    }

    @Override
    public GastosInmueble obtenerGastoInmuebleSiNofinalizado() {
        return gastosInmuebleRepository.findFirstByOrderByCodigGastosInmuebleDesc();
    }
}
