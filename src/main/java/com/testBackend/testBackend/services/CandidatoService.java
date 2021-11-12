package com.testBackend.testBackend.services;

import com.testBackend.testBackend.models.dtos.CandidatoDto;
import com.testBackend.testBackend.models.entities.Candidato;

import java.util.List;

public interface CandidatoService {
    CandidatoDto guardar(Candidato candidato);

    CandidatoDto modificar(Candidato candidato);

    void eliminar(Candidato candidato);

    List<CandidatoDto> listarTodos();


}
