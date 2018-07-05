package com.vv.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "tipo_inmueble")
public class TipoInmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="codig_tipo_inmueble")
    long codigTipoInmueble;
    @Column(name="descr_tipo_inmueble")
    String descrTipoInmueble;

    public long getCodigTipoInmueble() {
        return codigTipoInmueble;
    }

    public void setCodigTipoInmueble(long codigTipoInmueble) {
        this.codigTipoInmueble = codigTipoInmueble;
    }

    public String getDescrTipoInmueble() {
        return descrTipoInmueble;
    }

    public void setDescrTipoInmueble(String descrTipoInmueble) {
        this.descrTipoInmueble = descrTipoInmueble;
    }
}
