package com.mobydigital.test.testutils;

import com.google.gson.Gson;
import com.mobydigital.test.models.dtos.CandidatoDto;
import com.mobydigital.test.models.dtos.TipoDocumentoDto;

import java.util.ArrayList;
import java.util.List;

public class TestEntityFactory {

    public static CandidatoDto getCandidatoDto() {
        return CandidatoDto.builder()
                .id(1L)
                .nombre("Nahuel")
                .apellido("Flores")
                .tipoDocumento(getTipoDocumentoDto())
                .numeroDocumento("12342753")
                .fechaNacimiento("03/12/1999")
                .build();
    }

    public static CandidatoDto getCandidatoDtoSinID() {
        return CandidatoDto.builder()
                .nombre("Nahuel")
                .apellido("Flores")
                .tipoDocumento(getTipoDocumentoDto())
                .numeroDocumento("12342753")
                .fechaNacimiento("03/12/1999")
                .build();
    }

    public static TipoDocumentoDto getTipoDocumentoDto(){
        return TipoDocumentoDto.builder()
                .id(1L)
                .tipo("DNI")
                .build();
    }

    public static List<CandidatoDto> getListCandidatoDto(){
        List<CandidatoDto> listaCandidatosDto = new ArrayList<>();
        listaCandidatosDto.add(getCandidatoDto());

        return listaCandidatosDto;
    }

    public static String getCandidatoDtoJSON (){
        return new Gson().toJson(getCandidatoDto());
    }

    public static String getCandidatoDtoSinIDJSON (){
        return new Gson().toJson(getCandidatoDtoSinID());
    }

    public static String getListCandidatoDtoJSON (){
        return new Gson().toJson(getListCandidatoDto());
    }


}
