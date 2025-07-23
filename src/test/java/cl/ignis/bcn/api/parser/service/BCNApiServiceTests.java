package cl.ignis.bcn.api.parser.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.SocketTimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

class BCNApiServiceTests {

    private static final String URL_TEMPLATE = "https://www.leychile.cl/Consulta/obtxml?opt={param1}&cantidad={param2}";
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private BCNApiService bcnApiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void fetchResumenNormas_returnsXmlString() {
        int requestedNormas = 5;
        String expectedXml = "<NORMAS><NORMA idNorma=\"123\"/></NORMAS>";

        when(restTemplate.getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas))
                .thenReturn(ResponseEntity.ok(expectedXml));

        String result = bcnApiService.fetchResumenNormas(requestedNormas);

        assertEquals(expectedXml, result);
        verify(restTemplate).getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas);
    }

    @Test
    void fetchResumenNormas_throwsOnTimeout() {
        int requestedNormas = 5;

        when(restTemplate.getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas))
                .thenThrow(new ResourceAccessException("I/O error", new SocketTimeoutException("Timeout")));

        ResourceAccessException ex = assertThrows(
                ResourceAccessException.class,
                () -> bcnApiService.fetchResumenNormas(requestedNormas)
        );

        assertInstanceOf(SocketTimeoutException.class, ex.getCause());
        verify(restTemplate).getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas);
    }

    @Test
    void fetchResumenNormas_throwsOnServerError() {
        int requestedNormas = 5;

        when(restTemplate.getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas))
                .thenThrow(new HttpServerErrorException(INTERNAL_SERVER_ERROR, "Internal Server Error"));

        HttpServerErrorException ex = assertThrows(
                HttpServerErrorException.class,
                () -> bcnApiService.fetchResumenNormas(requestedNormas)
        );

        assertEquals(INTERNAL_SERVER_ERROR, ex.getStatusCode());
        verify(restTemplate).getForEntity(URL_TEMPLATE, String.class, 3, requestedNormas);
    }
}
