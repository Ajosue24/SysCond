package com.vv.service;

import com.vv.model.DetallesGastosInmueble;
import com.vv.model.GastosInmueble;

import java.util.List;

public interface GastosInmuebleDetalladoService {

    public void actualizaYGuardaGastoDetallado(DetallesGastosInmueble detallesGastosInmueble);

    public void eliminarGastoDetallado(long codigDetallesGastInmue);

    public List<DetallesGastosInmueble> listaDetallesActuales(GastosInmueble nroRecibo);



}
