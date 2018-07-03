package com.vv.repository;

import com.vv.model.Gastos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GastosRepository extends CrudRepository<Gastos,Long> {

    List<Gastos> findByDescrGastosContainingIgnoreCase(String gastos);
        }
