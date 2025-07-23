package cl.ignis.bcn.api.parser.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "NORMAS")
public class Normas {

    @JacksonXmlProperty(isAttribute = true, localName = "creado")
    private String creado;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "NORMA")
    private List<Norma> normaList;

    // Getters and setters
    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public List<Norma> getNormaList() {
        return normaList;
    }

    public void setNormaList(List<Norma> normaList) {
        this.normaList = normaList;
    }
}