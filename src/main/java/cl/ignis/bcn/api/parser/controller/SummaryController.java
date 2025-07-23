package cl.ignis.bcn.api.parser.controller;

import cl.ignis.bcn.api.parser.exception.InvalidQueryParamException;
import cl.ignis.bcn.api.parser.service.BCNApiService;
import cl.ignis.bcn.api.parser.util.XmlParser;
import cl.ignis.bcn.api.parser.vo.Norma;
import cl.ignis.bcn.api.parser.vo.Normas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/normas")
public class SummaryController {

    private final BCNApiService bcnApiService;

    @Autowired
    public SummaryController(BCNApiService bcnApiService) {
        this.bcnApiService = bcnApiService;
    }

    @GetMapping(path = "/resumen_raw", produces = MediaType.APPLICATION_XML_VALUE)
    public String getRecientesRaw() {
        return bcnApiService.fetchResumenNormas(5);
    }


    @GetMapping(path = "/resumen")
    public Normas getRecientes(@RequestParam(value = "cantidad", required = false, defaultValue = "5") String cantidadStr) {
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            throw new InvalidQueryParamException("Parametro cantidad debe ser numérico");
        }
        String normas = bcnApiService.fetchResumenNormas(cantidad);
        return XmlParser.parseXml(normas, Normas.class);
    }

}
