package com.vv.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gastos_inmueble")
public class GastosInmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_gastos_inmueble")
    long codigGastosInmueble;

    @Column(name = "descr_gastos_inmueble")
    String DescrGastosInmueble;

    @Column(name = "fecha_gastos_inmueble")
    Date fechaGastosInmueble;

    @Column(name = "sub_total_gastos_inmueble")
    Double montoSubTotalGastosInmueble;
    @Column(name = "monto_detalles_gasto_inmueble")
    Double montoTotalGastosInmueble;

    @Column(name = "codig_condominio")
    Long condCondominio;

    @OneToMany(mappedBy = "codigGastosInmueble", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetallesGastosInmueble> detallesGastosInmueble;

    public long getCodigGastosInmueble() {
        return codigGastosInmueble;
    }

    public void setCodigGastosInmueble(long codigGastosInmueble) {
        this.codigGastosInmueble = codigGastosInmueble;
    }

    public String getDescrGastosInmueble() {
        return DescrGastosInmueble;
    }

    public void setDescrGastosInmueble(String descrGastosInmueble) {
        DescrGastosInmueble = descrGastosInmueble;
    }

    public Date getFechaGastosInmueble() {
        return fechaGastosInmueble;
    }

    public void setFechaGastosInmueble(Date fechaGastosInmueble) {
        this.fechaGastosInmueble = fechaGastosInmueble;
    }

    public Double getMontoSubTotalGastosInmueble() {
        return montoSubTotalGastosInmueble;
    }

    public void setMontoSubTotalGastosInmueble(Double montoSubTotalGastosInmueble) {
        this.montoSubTotalGastosInmueble = montoSubTotalGastosInmueble;
    }

    public Double getMontoTotalGastosInmueble() {
        return montoTotalGastosInmueble;
    }

    public void setMontoTotalGastosInmueble(Double montoTotalGastosInmueble) {
        this.montoTotalGastosInmueble = montoTotalGastosInmueble;
    }

    public Long getCondCondominio() {
        return condCondominio;
    }

    public void setCondCondominio(Long condCondominio) {
        this.condCondominio = condCondominio;
    }

    public List<DetallesGastosInmueble> getDetallesGastosInmueble() {
        return detallesGastosInmueble;
    }

    public void setDetallesGastosInmueble(List<DetallesGastosInmueble> detallesGastosInmueble) {
        this.detallesGastosInmueble = detallesGastosInmueble;
    }
}