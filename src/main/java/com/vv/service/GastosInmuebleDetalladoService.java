package com.vv.service;

import com.vv.model.DetallesGastosInmueble;

import java.util.List;

public interface GastosInmuebleDetalladoService {

    public void actualizaYGuardaGastoDetallado(DetallesGastosInmueble detallesGastosInmueble);

    public void eliminarGastoDetallado(long codigDetallesGastInmue);

    public List<DetallesGastosInmueble> listaDetallesActuales(long nroRecibo);



}
