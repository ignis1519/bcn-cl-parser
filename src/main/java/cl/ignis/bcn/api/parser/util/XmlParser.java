package cl.ignis.bcn.api.parser.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlParser {

    private static final XmlMapper xmlMapper = new XmlMapper();

    public static <T> T parseXml(String xml, Class<T> clazz) {
        try {
            return xmlMapper.readValue(xml, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML", e);
        }
    }
}
