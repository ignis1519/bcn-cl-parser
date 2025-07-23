package cl.ignis.bcn.api.parser.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class TiposNumeros {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "TIPO_NUMERO")
    private List<TipoNumero> tipoNumeroList;

    public List<TipoNumero> getTipoNumeroList() {
        return tipoNumeroList;
    }

    public void setTipoNumeroList(List<TipoNumero> tipoNumeroList) {
        this.tipoNumeroList = tipoNumeroList;
    }
}