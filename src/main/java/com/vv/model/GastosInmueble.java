package com.vv.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gastos_inmueble")
public class GastosInmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codig_gast_inmue")
    long codigGastosInmueble;

    @Column(name = "descr_gast_inmue")
    String descrGastosInmueble;

    @Column(name = "fecha_gast_inmue")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fechaGastosInmueble;

    @Column(name="subt_gast_inmue", columnDefinition="Decimal(10,2)")
    Double montoSubTotalGastosInmueble;
    @Column(name="total_gast_inmue", columnDefinition="Decimal(10,2)")
    Double montoTotalGastosInmueble;

    @NotNull
    @Column(name = "codig_condominio")
    Long condCondominio;

    @Column(name="if_generado", columnDefinition="BOOLEAN DEFAULT false")
    Boolean isGenerado;

    @OneToMany(mappedBy = "codigGastosInmueble", fetch = FetchType.EAGER)
    private List<DetallesGastosInmueble> detallesGastosInmueble;

    @OneToMany(mappedBy = "codigGastosInmueble", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimientosInmuebles> movimientosInmuebles;

    public long getCodigGastosInmueble() {
        return codigGastosInmueble;
    }

    public void setCodigGastosInmueble(long codigGastosInmueble) {
        this.codigGastosInmueble = codigGastosInmueble;
    }

    public String getDescrGastosInmueble() {
        return descrGastosInmueble;
    }

    public void setDescrGastosInmueble(String descrGastosInmueble) {
        this.descrGastosInmueble = descrGastosInmueble;
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

    public Boolean getGenerado() {
        return isGenerado;
    }

    public void setGenerado(Boolean generado) {
        isGenerado = generado;
    }
}