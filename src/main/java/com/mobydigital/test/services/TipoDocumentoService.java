package com.mobydigital.test.services;

import com.mobydigital.test.models.dtos.TipoDocumentoDto;


import java.util.List;

public interface TipoDocumentoService {

    TipoDocumentoDto guardar(TipoDocumentoDto tipoDocumentoDto);

    void eliminar(TipoDocumentoDto tipoDocumentoDto);

    List<TipoDocumentoDto> listarTodas();
}
