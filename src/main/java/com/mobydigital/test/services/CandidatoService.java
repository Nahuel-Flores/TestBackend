package com.mobydigital.test.services;

import com.mobydigital.test.exceptions.EmptyParamsException;
import com.mobydigital.test.models.dtos.CandidatoDto;


import java.util.List;

public interface CandidatoService {
    CandidatoDto guardar(CandidatoDto candidatoDto) throws EmptyParamsException;

    CandidatoDto modificar(CandidatoDto candidatoDto) throws EmptyParamsException;

    void eliminar(CandidatoDto candidatoDto);

    List<CandidatoDto> listarTodos();


}
