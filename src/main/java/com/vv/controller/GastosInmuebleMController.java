package com.vv.controller;


import com.vv.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/gastosInmuebleM")
public class GastosInmuebleMController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPages() {
        ModelAndView model = new ModelAndView("gastosInmuebleM");
        Item item = new Item();
        model.addObject("itemForm", item);
        return model;

    }


    @RequestMapping(value = "/autoComplete", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getTags(@RequestParam String tagName) {
        List<String> lista = null;
        lista.add("prueba");
        lista.add("p");
        lista.add("pru");
        return lista;

    }


    @RequestMapping(value = "/refreshItem", method = RequestMethod.GET)
    public String refreshItem(/*@RequestParam("order") String orderId,*/ Model model) {
        Item item = new Item();
        item.setId(1);
        item.setNombre("algo");
        model.addAttribute("itemForm", item);
        return "gastosInmuebleM :: #item";
    }

}
