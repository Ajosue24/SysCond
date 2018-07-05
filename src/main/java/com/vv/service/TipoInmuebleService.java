package com.vv.service;

/**
 * Interfaz
 */

import com.vv.model.TipoInmueble;

import java.util.List;

public interface TipoInmuebleService {

    public List<TipoInmueble> listaTipoInmueble();
    public void actualizaYGuarda(TipoInmueble tipoInmueble);
    public void eliminarTipoInmueble(long idTipoInmueble);

    public TipoInmueble obtenerTipoInmueble(long idTipoInmueble);
}