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
public class CandidatoDto {

    private Long id;
    private String nombre;
    private String apellido;
    private TipoDocumentoDto tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
}
