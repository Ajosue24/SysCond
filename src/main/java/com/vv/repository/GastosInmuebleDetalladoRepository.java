package com.vv.repository;

import com.vv.model.DetallesGastosInmueble;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastosInmuebleDetalladoRepository extends CrudRepository<DetallesGastosInmueble,Long> {

    List<DetallesGastosInmueble> findDetallesGastosInmuebleByCodigGastosInmuebleEquals(long nroGasto);
}
