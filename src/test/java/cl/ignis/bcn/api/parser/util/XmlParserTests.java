package cl.ignis.bcn.api.parser.util;

import cl.ignis.bcn.api.parser.vo.Norma;
import cl.ignis.bcn.api.parser.vo.Normas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlParserTests {

    @Test
    void parseXml_shouldReturnObject_whenXmlIsValid() {
        String xml = """
            <NORMAS creado="2025-07-23 12:47:31">
                <NORMA idNorma="1215055" fecha_version="2025-07-18" nro_bcn="1215055">
                    <TIPOS_NUMEROS>
                        <TIPO_NUMERO>
                            <TIPO>XX1</TIPO>
                            <NUMERO>21753</NUMERO>
                            <DESCRIPCION>Ley</DESCRIPCION>
                            <COMPUESTO>Ley-21753</COMPUESTO>
                        </TIPO_NUMERO>
                    </TIPOS_NUMEROS>
                    <TITULO>Some Law Title</TITULO>
                </NORMA>
            </NORMAS>
        """;

        Normas normas = XmlParser.parseXml(xml, Normas.class);

        assertNotNull(normas);
        assertNotNull(normas.getNormaList());
        assertFalse(normas.getNormaList().isEmpty());
        assertEquals("1215055", normas.getNormaList().get(0).getIdNorma());
    }

    @Test
    void parseXml_shouldThrowException_whenXmlIsInvalid() {
        String malformedXml = "<NORMAS><NORMA><INVALID></NORMAS>"; // unclosed tag, invalid XML

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            XmlParser.parseXml(malformedXml, Normas.class);
        });

        assertTrue(exception.getMessage().contains("Error parsing XML"));
    }
}
