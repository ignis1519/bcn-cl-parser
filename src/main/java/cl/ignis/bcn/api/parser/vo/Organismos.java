package cl.ignis.bcn.api.parser.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Organismos {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ORGANISMO")
    private List<String> organismo;

    public List<String> getOrganismo() {
        return organismo;
    }

    public void setOrganismo(List<String> organismo) {
        this.organismo = organismo;
    }
}
