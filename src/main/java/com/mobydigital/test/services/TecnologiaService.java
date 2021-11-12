package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.TecnologiaDto;

import java.util.List;

public interface TecnologiaService {
    TecnologiaDto guardar(TecnologiaDto tecnologiaDto);

    TecnologiaDto modificar(TecnologiaDto tecnologiaDto);

    void eliminar(TecnologiaDto tecnologiaDto);

    List<TecnologiaDto> listarTodas();
}
