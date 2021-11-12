package com.mobydigital.test.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidatoXTecnologiaDto {

    private Long id;
    private CandidatoDto candidato;
    private TecnologiaDto tecnologia;
    private int aniosExperiencia;
}
