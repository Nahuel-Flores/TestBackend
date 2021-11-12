package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.CandidatoDto;


import java.util.List;

public interface CandidatoService {
    CandidatoDto guardar(CandidatoDto candidatoDto);

    CandidatoDto modificar(CandidatoDto candidatoDto);

    void eliminar(CandidatoDto candidatoDto);

    List<CandidatoDto> listarTodos();


}
