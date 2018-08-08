package com.vv.repository;

import com.vv.model.GastosInmueble;
import com.vv.model.Inmueble;
import com.vv.model.MovimientosInmuebles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovimientosInmuebleRepository extends CrudRepository<MovimientosInmuebles,Long> {

    List<MovimientosInmuebles> findAllByCodigGastosInmuebleEquals(GastosInmueble gi);

    MovimientosInmuebles findByCodigGastosInmuebleAndCodigInmueble(GastosInmueble gi, Inmueble inmueble);
}
