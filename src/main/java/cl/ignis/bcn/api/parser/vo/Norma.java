package cl.ignis.bcn.api.parser.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Norma {

    @JacksonXmlProperty(isAttribute = true, localName = "idNorma")
    private String idNorma;

    @JacksonXmlProperty(isAttribute = true, localName = "fecha_version")
    private String fechaVersion;

    @JacksonXmlProperty(isAttribute = true, localName = "nro_bcn")
    private String nroBcn;

    @JacksonXmlProperty(localName = "TIPOS_NUMEROS")
    private TiposNumeros tiposNumeros;

    @JacksonXmlProperty(localName = "FECHA_PUBLICACION")
    private String fechaPublicacion;

    @JacksonXmlProperty(localName = "FECHA_PROMULGACION")
    private String fechaPromulgacion;

    @JacksonXmlProperty(localName = "TITULO")
    private String titulo;

    @JacksonXmlProperty(localName = "ORGANISMOS")
    private Organismos organismos;

    @JacksonXmlProperty(localName = "HISTORIASLEY")
    private String historiasLey;

    @JacksonXmlProperty(localName = "TEXTO")
    private String texto;

    // Getters and setters...

    public String getIdNorma() {
        return idNorma;
    }

    public void setIdNorma(String idNorma) {
        this.idNorma = idNorma;
    }

    public String getFechaVersion() {
        return fechaVersion;
    }

    public void setFechaVersion(String fechaVersion) {
        this.fechaVersion = fechaVersion;
    }

    public String getNroBcn() {
        return nroBcn;
    }

    public void setNroBcn(String nroBcn) {
        this.nroBcn = nroBcn;
    }

    public TiposNumeros getTiposNumeros() {
        return tiposNumeros;
    }

    public void setTiposNumeros(TiposNumeros tiposNumeros) {
        this.tiposNumeros = tiposNumeros;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFechaPromulgacion() {
        return fechaPromulgacion;
    }

    public void setFechaPromulgacion(String fechaPromulgacion) {
        this.fechaPromulgacion = fechaPromulgacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Organismos getOrganismos() {
        return organismos;
    }

    public void setOrganismos(Organismos organismos) {
        this.organismos = organismos;
    }

    public String getHistoriasLey() {
        return historiasLey;
    }

    public void setHistoriasLey(String historiasLey) {
        this.historiasLey = historiasLey;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}