package com.vv.model;

import javax.persistence.*;

@Entity
@Table(name = "detalles_gasto_inmueble")
public class DetallesGastosInmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_detalles_gast_inmue")
    long codigDetallesGastInmue;


    @Column(name = "monto_gast")
    Double montoGasto;

    @Column(name = "obs_detalles")
    String detallesGastoInmueble;

    //muchos gastos inmueble
    @ManyToOne
    @JoinColumn(name = "codig_gast_inmue")
    private GastosInmueble codigGastosInmueble;

//Muchos gastos
    @ManyToOne
    @JoinColumn(name = "codig_gastos")
    private Gastos codigGastos;

    public long getCodigDetallesGastInmue() {
        return codigDetallesGastInmue;
    }

    public void setCodigDetallesGastInmue(long codigDetallesGastInmue) {
        this.codigDetallesGastInmue = codigDetallesGastInmue;
    }

    public Double getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(Double montoGasto) {
        this.montoGasto = montoGasto;
    }

    public String getDetallesGastoInmueble() {
        return detallesGastoInmueble;
    }

    public void setDetallesGastoInmueble(String detallesGastoInmueble) {
        this.detallesGastoInmueble = detallesGastoInmueble;
    }

    public GastosInmueble getCodigGastosInmueble() {
        return codigGastosInmueble;
    }

    public void setCodigGastosInmueble(GastosInmueble codigGastosInmueble) {
        this.codigGastosInmueble = codigGastosInmueble;
    }

    public Gastos getCodigGastos() {
        return codigGastos;
    }

    public void setCodigGastos(Gastos codigGastos) {
        this.codigGastos = codigGastos;
    }
}