package com.vv.service;

import com.vv.model.DetallesGastosInmueble;
import com.vv.repository.GastosInmuebleDetalladoRepository;
import com.vv.repository.GastosInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GastosInmuebleDetalladoImpl implements GastosInmuebleDetalladoService{

    @Autowired
    GastosInmuebleDetalladoRepository gastosInmuebleDetallado;

    @Override
    public void actualizaYGuardaGastoDetallado(DetallesGastosInmueble detallesGastosInmueble) {
        gastosInmuebleDetallado.save(detallesGastosInmueble);
    }

    @Override
    public void eliminarGastoDetallado(long codigDetallesGastInmue) {
        gastosInmuebleDetallado.deleteById(codigDetallesGastInmue);
    }

    @Override
    public List<DetallesGastosInmueble> listaDetallesActuales(long nroRecibo) {
        return (List<DetallesGastosInmueble>)gastosInmuebleDetallado.findDetallesGastosInmuebleByCodigGastosInmuebleEquals(nroRecibo);

    }
}
