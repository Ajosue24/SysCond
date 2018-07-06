package com.vv.repository;

import com.vv.model.DetallesGastosInmueble;
import com.vv.model.GastosInmueble;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastosInmuebleDetalladoRepository extends CrudRepository<DetallesGastosInmueble,Long> {

    List<DetallesGastosInmueble> findByCodigGastosInmueble(GastosInmueble nroGasto);
}
