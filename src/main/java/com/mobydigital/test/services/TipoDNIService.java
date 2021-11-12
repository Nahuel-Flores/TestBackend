package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.TecnologiaDto;
import com.mobydigital.test.models.dtos.TipoDNIDto;
import com.mobydigital.test.models.entities.TipoDNI;

import java.util.List;

public interface TipoDNIService {

    TipoDNIDto guardar(TipoDNIDto tipoDNIDto);

    void eliminar(TipoDNIDto tipoDNIDto);

    List<TipoDNIDto> listarTodas();
}
