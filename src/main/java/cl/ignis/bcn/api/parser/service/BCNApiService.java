package cl.ignis.bcn.api.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BCNApiService {

    private static final String BCN_API_BASE_URL = "https://www.leychile.cl/Consulta/obtxml?opt={param1}";
    private static final Integer OPT_RECIENTES = 3;

    private final RestTemplate restTemplate;

    @Autowired
    public BCNApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String fetchResumenNormas(Integer normasQty){
        StringBuilder url = new StringBuilder(BCN_API_BASE_URL);
        url.append("&cantidad={param2}");

        ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class, OPT_RECIENTES, normasQty);
        return response.getBody();
    }


}
