package com.vv.controller;

import com.vv.model.Gastos;
import com.vv.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/vvsyscond/")
public class AjaxController {

    @Autowired
    GastosService gastosService;


    @RequestMapping(value = "autoComplete/{descGM}", method = RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Gastos>> getTags(@PathVariable("descGM") String descGM) {
        List<Gastos> listaFiltrada = gastosService.filtraDescripcionLike(descGM);
        try {
            return new ResponseEntity<List<Gastos>>(listaFiltrada, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Gastos>>(listaFiltrada, HttpStatus.BAD_REQUEST);
        }

    }
}
