package com.vv.service;

import com.vv.model.GastosInmueble;

public interface GastosInmuebleService {


    public void guardarActualizarGastoInmueble(GastosInmueble gastosInmueble);

   public GastosInmueble obtenerGastoInmuebleSiNofinalizado();
}
