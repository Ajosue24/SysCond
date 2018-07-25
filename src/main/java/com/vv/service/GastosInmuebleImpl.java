package com.vv.service;

import com.vv.model.Gastos;
import com.vv.model.GastosInmueble;
import com.vv.repository.GastosInmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GastosInmuebleImpl implements GastosInmuebleService{

    @Autowired
    GastosInmuebleRepository gastosInmuebleRepository;



    @Override
    public void guardarActualizarGastoInmueble(GastosInmueble gastosInmueble) {
        gastosInmuebleRepository.save(gastosInmueble);
    }

    @Override
    public GastosInmueble obtenerGastoInmuebleSiNofinalizado() {
        GastosInmueble g = new GastosInmueble();
        g.setCondCondominio(1l);
        g=gastosInmuebleRepository.findFirstByOrderByCodigGastosInmuebleDesc();
        try{
            if(g==null){
                //si no existe no explote
                g = new GastosInmueble();
                //TODO
                g.setCondCondominio(1l);
                g.setGenerado(false);
                guardarActualizarGastoInmueble(g);
                return gastosInmuebleRepository.findFirstByOrderByCodigGastosInmuebleDesc();
            }else{
                return g;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GastosInmueble> obtenerListaGastosInmuebleFinalizados() {
        return gastosInmuebleRepository.findByIsGeneradoTrue();
    }

    @Override
    public List<GastosInmueble> obtenerListaGastosInmuebleNoFinalizados() {
       return gastosInmuebleRepository.findByIsGeneradoFalse();
    }


}
