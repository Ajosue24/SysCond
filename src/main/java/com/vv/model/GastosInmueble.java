package com.vv.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    String DescrGastosInmueble;

    @Column(name = "fecha_gast_inmue")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date fechaGastosInmueble;

    @Column(name = "subt_gast_inmue")
    Double montoSubTotalGastosInmueble;
    @Column(name = "total_gast_inmue")
    Double montoTotalGastosInmueble;

    @Column(name = "codig_condominio")
    Long condCondominio;

    @Column(name = "is_generado")
    Boolean isGenerado;

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

    public Boolean getGenerado() {
        return isGenerado;
    }

    public void setGenerado(Boolean generado) {
        isGenerado = generado;
    }
}