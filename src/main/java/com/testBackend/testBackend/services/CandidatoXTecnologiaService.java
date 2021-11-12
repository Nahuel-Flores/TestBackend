package com.testBackend.testBackend.services;

import com.testBackend.testBackend.models.dtos.CandidatoXTecnologiaDto;
import com.testBackend.testBackend.models.entities.CandidatoXTecnologia;

import java.util.List;

public interface CandidatoXTecnologiaService {
    CandidatoXTecnologiaDto guardar(CandidatoXTecnologia candidatoXTecnologia);

    CandidatoXTecnologiaDto modificar(CandidatoXTecnologia candidatoXTecnologia);

    void eliminar(CandidatoXTecnologia candidatoXTecnologia);

    List<CandidatoXTecnologiaDto> listarTodos();
}
