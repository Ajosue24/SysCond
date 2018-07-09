package com.vv.service;

import com.vv.model.DetallesGastosInmueble;
import com.vv.model.GastosInmueble;

import java.util.List;

public interface GastosInmuebleDetalladoService {

    public void actualizaYGuardaGastoDetallado(DetallesGastosInmueble detallesGastosInmueble);

    public void eliminarGastoDetallado(Long codigDetallesGastInmue);

    public List<DetallesGastosInmueble> listaDetallesActuales(GastosInmueble nroRecibo);

    public DetallesGastosInmueble buscarDetallesGastosInmueblePorId(Long codigDetallesGastInmue);



}
