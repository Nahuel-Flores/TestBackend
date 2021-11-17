package com.mobydigital.test.controllers;

import com.mobydigital.test.services.CandidatoService;
import com.mobydigital.test.services.CandidatoXTecnologiaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static com.mobydigital.test.testutils.TestEntityFactory.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidatoController.class)
class CandidatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CandidatoService candidatoService;

    @MockBean
    CandidatoXTecnologiaService candidatoXTecnologiaService;

    @InjectMocks
    CandidatoController candidatoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser
    void crearCandidatoTest() throws Exception {
        when(candidatoService.guardar(getCandidatoDtoSinID())).thenReturn(getCandidatoDto());
        mockMvc.perform(post("/api/candidato/crear",getCandidatoDtoJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getCandidatoDtoJSON()))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void actualizarCandidatoTest() throws Exception {
        when(candidatoService.modificar(getCandidatoDto())).thenReturn(getCandidatoDto());
        mockMvc.perform(put("/api/candidato/actualizar",getCandidatoDtoJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getCandidatoDtoJSON()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void eliminarCandidatoTest() throws Exception{
        mockMvc.perform(delete("/api/candidato/eliminar", getCandidatoDtoJSON())
                .contentType(MediaType.APPLICATION_JSON)
                .content(getCandidatoDtoJSON()))
                .andExpect(status().isOk());
        verify(candidatoService, times(1)).eliminar(getCandidatoDto());
    }

    @Test
    @WithMockUser
    void listarTodosTest() throws Exception {
        when(candidatoService.listarTodos()).thenReturn(getListCandidatoDto());
                mockMvc.perform(get("/api/candidato/listartodos"))
                        .andExpect(status().isOk())
                        .equals(getListCandidatoDtoJSON());

    }


}
