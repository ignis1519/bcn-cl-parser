package cl.ignis.bcn.api.parser.controller;

import cl.ignis.bcn.api.parser.service.BCNApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SummaryController.class)
class SummaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BCNApiService bcnApiService;

    @Test
    @DisplayName("✅ Should return raw XML with status 200")
    void testResumenRawReturnsXml() throws Exception {
        String mockXml = "<NORMAS><NORMA idNorma=\"1\" /></NORMAS>";

        when(bcnApiService.fetchResumenNormas(5)).thenReturn(mockXml);

        mockMvc.perform(get("/normas/resumen_raw"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
                .andExpect(content().string(mockXml));
    }

    @Test
    @DisplayName("✅ Should parse and return Normas object with status 200")
    void testResumenParsesNormas() throws Exception {
        String mockXml = "<NORMAS><NORMA idNorma=\"1\" fecha_version=\"2025-07-23\" nro_bcn=\"123\" /></NORMAS>";

        when(bcnApiService.fetchResumenNormas(5)).thenReturn(mockXml);

        mockMvc.perform(get("/normas/resumen?cantidad=5"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        // Optionally assert values if JSON serialization is tested
    }

    @Test
    @DisplayName("❌ Should return 400 if cantidad is not a number")
    void testResumenInvalidCantidad() throws Exception {
        mockMvc.perform(get("/normas/resumen?cantidad=abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Parametro cantidad debe ser numérico"));
    }
}
