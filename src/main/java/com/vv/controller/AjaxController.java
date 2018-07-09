package com.vv.controller;

import com.vv.model.Gastos;
import com.vv.model.GastosInmueble;
import com.vv.service.GastosInmuebleService;
import com.vv.service.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/vvsyscond/")
public class AjaxController {

    @Autowired
    GastosService gastosService;

    @Autowired
    GastosInmuebleService gastosInmuebleService;


    @RequestMapping(value = "autoComplete/{descGM}", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Gastos>> getTags(@PathVariable("descGM") String descGM) {
        List<Gastos> listaFiltrada = gastosService.filtraDescripcionLike(descGM);
        try {
            return new ResponseEntity<List<Gastos>>(listaFiltrada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Gastos>>(listaFiltrada, HttpStatus.BAD_REQUEST);
        }

    }
    @RequestMapping(value = "refreshNombreFecha/{descrGI}/{fecha}/{codigGI}", method = RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity <GastosInmueble> refreshNombreFecha(@PathVariable("descrGI") String descrGI,@PathVariable("fecha") String fecha,@PathVariable("codigGI") String codigGI){
        GastosInmueble gastosInmueble= new GastosInmueble();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            gastosInmueble.setFechaGastosInmueble(formatter.parse(fecha));
        } catch (ParseException e) {
            gastosInmueble.setFechaGastosInmueble(new Date());
        }

        gastosInmueble.setDescrGastosInmueble(descrGI.trim());
        gastosInmueble.setCodigGastosInmueble(Long.parseLong(codigGI));
        gastosInmueble.setGenerado(false);
        gastosInmueble.setCondCondominio(1l);
        gastosInmuebleService.guardarActualizarGastoInmueble(gastosInmueble);

        try {
            return new ResponseEntity<>(gastosInmueble, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(gastosInmueble, HttpStatus.BAD_REQUEST);
        }
    }

}
