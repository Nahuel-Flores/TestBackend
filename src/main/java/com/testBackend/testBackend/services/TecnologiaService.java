package com.testBackend.testBackend.services;

import com.testBackend.testBackend.models.dtos.TecnologiaDto;
import com.testBackend.testBackend.models.entities.Tecnologia;

import java.util.List;

public interface TecnologiaService {
    TecnologiaDto guardar(Tecnologia tecnologia);

    TecnologiaDto modificar(Tecnologia tecnologia);

    void eliminar(Tecnologia tecnologia);

    List<TecnologiaDto> listarTodas();
}
