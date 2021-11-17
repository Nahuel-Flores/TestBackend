package com.mobydigital.test.controllers;


import com.mobydigital.test.services.TecnologiaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.mobydigital.test.testutils.TestEntityFactory.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TecnologiaController.class)
public class TecnologiaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TecnologiaService tecnologiaService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @WithMockUser
    void crearTecnologiaTest() throws Exception {
        when(tecnologiaService.guardar(getTecnologiaDtoSinID())).thenReturn(getTecnologiaDto());
        mockMvc.perform(post("/api/tecnologia/crear",getTecnologiaDtoJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getTecnologiaDtoJSON()))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void actualizarTecnologiaTest() throws Exception {
        when(tecnologiaService.modificar(getTecnologiaDto())).thenReturn(getTecnologiaDto());
        mockMvc.perform(put("/api/tecnologia/actualizar",getTecnologiaDtoJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getTecnologiaDtoJSON()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void eliminarTecnologiaTest() throws Exception{
        mockMvc.perform(delete("/api/tecnologia/eliminar", getTecnologiaDtoJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getTecnologiaDtoJSON()))
                .andExpect(status().isOk());
        verify(tecnologiaService, times(1)).eliminar(getTecnologiaDto());
    }

    @Test
    @WithMockUser
    void listarTodasTest() throws Exception {
        when(tecnologiaService.listarTodas()).thenReturn(getListTecnologiaDto());
        mockMvc.perform(get("/api/tecnologia/listartodas"))
                .andExpect(status().isOk())
                .equals(getListTecnologiaDtoJSON());

    }
}
