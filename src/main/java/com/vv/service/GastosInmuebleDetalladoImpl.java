package com.vv.service;

import com.vv.model.DetallesGastosInmueble;
import com.vv.model.GastosInmueble;
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
        List<DetallesGastosInmueble> listDGI = gastosInmuebleDetallado.findByCodigGastosInmueble(detallesGastosInmueble.getCodigGastosInmueble());
        for(DetallesGastosInmueble obj: listDGI){
            if(obj.getCodigGastos().getCodigGastos() == detallesGastosInmueble.getCodigGastos().getCodigGastos()){
                detallesGastosInmueble.setMontoGasto(obj.getMontoGasto()+detallesGastosInmueble.getMontoGasto());
               detallesGastosInmueble.setCodigDetallesGastInmue(obj.getCodigDetallesGastInmue());
            }
        }
        gastosInmuebleDetallado.save(detallesGastosInmueble);
    }

    @Override
    public void eliminarGastoDetallado(long codigDetallesGastInmue) {
        gastosInmuebleDetallado.deleteById(codigDetallesGastInmue);
    }

    @Override
    public List<DetallesGastosInmueble> listaDetallesActuales(GastosInmueble nroRecibo) {
        return (List<DetallesGastosInmueble>)gastosInmuebleDetallado.findByCodigGastosInmueble(nroRecibo);

    }
}
