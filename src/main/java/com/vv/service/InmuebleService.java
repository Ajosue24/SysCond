package com.vv.service;

import com.vv.model.Inmueble;

import java.util.List;

public interface InmuebleService {

     List<Inmueble> obtenerListaInmuebles();

     Inmueble obtenerInmueble(String inmueble);

     void borrarInmueble(String nombreInmueble);

     void guardarEditarInmueble(Inmueble inmueble);
}
