package com.vv.repository;

import com.vv.model.GastosInmueble;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastosInmuebleRepository extends CrudRepository <GastosInmueble,Long>{

   GastosInmueble findFirstByOrderByCodigGastosInmuebleDesc();

   List<GastosInmueble> findByIsGeneradoFalse();

   List<GastosInmueble> findByIsGeneradoTrue();


}
