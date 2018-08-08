package com.vv.service;

import com.vv.model.GastosInmueble;
import com.vv.model.Inmueble;
import com.vv.model.MovimientosInmuebles;

import java.util.List;

public interface MovimientosInmuebleService {

    void guardarMovimientosInmueble(MovimientosInmuebles movimientosInmuebles);

    List<MovimientosInmuebles> listarPorNumeroDeRecibo(GastosInmueble numeroRecibo);

    MovimientosInmuebles obtenerMovPorReciboEInmueble(GastosInmueble numeroRecibo, Inmueble inmueble);
    
}
