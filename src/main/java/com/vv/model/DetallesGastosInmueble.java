package com.vv.model;

import javax.persistence.*;

@Entity
@Table(name = "detalles_gasto_inmueble")
public class DetallesGastosInmueble {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "codig_detalles_gasto_inmueble")
    long codigDetallesGInmueble;



@Column(name = "monto_detalles_gasto_inmueble")
    Double montoGastoInmueble;
@Column(name = "obs_detall_gasto_inmueble")
    String detallesGastoInmueble;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codig_gastos_inmueble")
    private GastosInmueble codigGastosInmueble;

@Column(name = "codig_condominio")
    long codigCondominio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codig_gastos")
    private Gastos codigGastos;

    public long getCodigDetallesGInmueble() {
        return codigDetallesGInmueble;
    }

    public void setCodigDetallesGInmueble(long codigDetallesGInmueble) {
        this.codigDetallesGInmueble = codigDetallesGInmueble;
    }

    public Double getMontoGastoInmueble() {
        return montoGastoInmueble;
    }

    public void setMontoGastoInmueble(Double montoGastoInmueble) {
        this.montoGastoInmueble = montoGastoInmueble;
    }

    public String getDetallesGastoInmueble() {
        return detallesGastoInmueble;
    }

    public void setDetallesGastoInmueble(String detallesGastoInmueble) {
        this.detallesGastoInmueble = detallesGastoInmueble;
    }


    public long getCodigCondominio() {
        return codigCondominio;
    }

    public void setCodigCondominio(long codigCondominio) {
        this.codigCondominio = codigCondominio;
    }

    public Gastos getCodigGastos() {
        return codigGastos;
    }

    public void setCodigGastos(Gastos codigGastos) {
        this.codigGastos = codigGastos;
    }

    public GastosInmueble getCodigGastosInmueble() {
        return codigGastosInmueble;
    }

    public void setCodigGastosInmueble(GastosInmueble codigGastosInmueble) {
        this.codigGastosInmueble = codigGastosInmueble;
    }
}
