package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.CandidatoXTecnologiaDto;



import java.util.List;

public interface CandidatoXTecnologiaService {
    CandidatoXTecnologiaDto guardar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    CandidatoXTecnologiaDto modificar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    void eliminar(CandidatoXTecnologiaDto candidatoXTecnologiaDto);

    List<CandidatoXTecnologiaDto> listarTodos();

    List<CandidatoXTecnologiaDto> findCandidatosXTecnologiaByTecnologia(String nombreTecnologia);
}
