package cl.ignis.bcn_cl_laws_parser.controller;

import cl.ignis.bcn_cl_laws_parser.vo.Norma;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/normas")
public class SummaryController {

    @GetMapping("/resumen")
    public List<Norma> getRecientes() {
        List<Norma> normas = new ArrayList<>();
        normas.add(new Norma(111, new Date(), new Date(), 666, "Mi super norma", "Esta es una super norma que estoy usando de prueba"));
        return normas;
    }

}
