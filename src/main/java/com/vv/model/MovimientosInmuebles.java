package com.vv.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="movimientos_inmuebles")
public class MovimientosInmuebles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_movimientos_inmu")
     Integer codMovInmueble;



    @Column(name = "monto_mes_mov_inmu")
    Double MontoMensualMov;

    @Column(name = "fecha_mov_inmu")
    Date fechaMov;

    @Column(name = "if_cancelado")
     boolean ifCancelado;

    //muchos a uno Inmueble
    @ManyToOne
    @JoinColumn(name = "codig_inmueble")
    private Inmueble codigInmueble;
    //Muchos a uno GastosInmueble
    @ManyToOne
    @JoinColumn(name = "codig_gast_inmu")
    private GastosInmueble codigGastosInmueble;
    public Integer getCodMovInmueble() {
        return codMovInmueble;
    }

    public void setCodMovInmueble(Integer codMovInmueble) {
        this.codMovInmueble = codMovInmueble;
    }

    public Inmueble getCodigInmueble() {
        return codigInmueble;
    }

    public void setCodigInmueble(Inmueble codigInmueble) {
        this.codigInmueble = codigInmueble;
    }


    public Double getMontoMensualMov() {
        return MontoMensualMov;
    }

    public void setMontoMensualMov(Double montoMensualMov) {
        MontoMensualMov = montoMensualMov;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public boolean isIfCancelado() {
        return ifCancelado;
    }

    public void setIfCancelado(boolean ifCancelado) {
        this.ifCancelado = ifCancelado;
    }

    public GastosInmueble getCodigGastosInmueble() {
        return codigGastosInmueble;
    }

    public void setCodigGastosInmueble(GastosInmueble codigGastosInmueble) {
        this.codigGastosInmueble = codigGastosInmueble;
    }
}
