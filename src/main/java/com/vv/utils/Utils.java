package com.vv.utils;

import com.vv.model.GastosInmueble;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public List<String> convertirStringInObj(String stringVista){
        String[] listStringSeparados= stringVista.split("&");
        List<String> listStringObj= new ArrayList<>();
        for (String obj:listStringSeparados) {
            listStringObj.add(obj.substring(obj.indexOf("=")+1,obj.length()));
        }

        return listStringObj;
    }
}
