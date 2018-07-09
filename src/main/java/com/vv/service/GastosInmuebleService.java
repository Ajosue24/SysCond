package com.vv.service;

import com.vv.model.GastosInmueble;

import java.util.List;

public interface GastosInmuebleService {


    public void guardarActualizarGastoInmueble(GastosInmueble gastosInmueble);

   public GastosInmueble obtenerGastoInmuebleSiNofinalizado();

   public List<GastosInmueble> obtenerListaGastosInmuebleNoFinalizados();
}
