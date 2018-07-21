package com.vv.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inmueble")
public class Inmueble {

    @Id
    @Column(name = "codig_inmueble",unique=true)
    String codigInmueble;

    @ManyToOne
    @JoinColumn(name = "codig_tipo_inmueble")
    private TipoInmueble codigTipoInmueble;

    @Column(name = "descr_inmuebles")
    String descrInmueble;

    @Column(name = "alicu_inmuebles")
    Double alicuota;

    @Column(name = "id_propietario")
    Integer idPropietario;


  //uno a muchos con mov inmuebles
    @OneToMany(mappedBy = "codigInmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MovimientosInmuebles> movimientosInmuebles;

    public String getCodigInmueble() {
        return codigInmueble;
    }

    public void setCodigInmueble(String codigInmueble) {
        this.codigInmueble = codigInmueble;
    }


    public String getDescrInmueble() {
        return descrInmueble;
    }

    public void setDescrInmueble(String descrInmueble) {
        this.descrInmueble = descrInmueble;
    }

    public Double getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(Double alicuota) {
        this.alicuota = alicuota;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public TipoInmueble getCodigTipoInmueble() {
        return codigTipoInmueble;
    }

    public void setCodigTipoInmueble(TipoInmueble codigTipoInmueble) {
        this.codigTipoInmueble = codigTipoInmueble;
    }
}
