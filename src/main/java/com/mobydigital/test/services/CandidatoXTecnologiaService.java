package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.CandidatoXTecnologiaDto;
import com.mobydigital.test.models.entities.CandidatoXTecnologia;

import java.util.List;

public interface CandidatoXTecnologiaService {
    CandidatoXTecnologiaDto guardar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    CandidatoXTecnologiaDto modificar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    void eliminar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    List<CandidatoXTecnologiaDto> listarTodos();
}
