package cl.ignis.bcn_cl_laws_parser.vo;

import java.util.Date;

public class Norma {
    public Norma() {
    }
    public Norma(Integer idNorma, Date fechaPublicacion, Date fechaPromulgacion, Integer numeroBcn, String titulo,
                 String textoCorto) {
        this.idNorma = idNorma;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaPromulgacion = fechaPromulgacion;
        this.numeroBcn = numeroBcn;
        this.titulo = titulo;
        this.textoCorto = textoCorto;
    }
    private Integer idNorma;
    public Integer getIdNorma() {
        return idNorma;
    }
    public void setIdNorma(Integer idNorma) {
        this.idNorma = idNorma;
    }
    private Date fechaPublicacion;
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    private Date fechaPromulgacion;
    public Date getFechaPromulgacion() {
        return fechaPromulgacion;
    }
    public void setFechaPromulgacion(Date fechaPromulgacion) {
        this.fechaPromulgacion = fechaPromulgacion;
    }
    private Integer numeroBcn;
    public Integer getNumeroBcn() {
        return numeroBcn;
    }
    public void setNumeroBcn(Integer numeroBcn) {
        this.numeroBcn = numeroBcn;
    }
    private String titulo;
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    private String textoCorto;
    public String getTextoCorto() {
        return textoCorto;
    }
    public void setTextoCorto(String textoCorto) {
        this.textoCorto = textoCorto;
    }
    
}
