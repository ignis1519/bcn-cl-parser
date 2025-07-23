package cl.ignis.bcn.api.parser.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TipoNumero {

    @JacksonXmlProperty(localName = "TIPO")
    private String tipo;

    @JacksonXmlProperty(localName = "NUMERO")
    private String numero;

    @JacksonXmlProperty(localName = "DESCRIPCION")
    private String descripcion;

    @JacksonXmlProperty(localName = "COMPUESTO")
    private String compuesto;

    // Getters and setters...

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }
}