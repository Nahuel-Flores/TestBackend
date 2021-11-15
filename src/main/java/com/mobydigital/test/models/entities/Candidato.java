package com.mobydigital.test.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;


    @NotBlank (message = "El nombre no puede estar vacio")
    @Column(name = "nombre")
    private String nombre;


    @NotBlank (message = "El apellido no puede estar vacio")
    @Column(name = "apellido")
    private String apellido;


    @NotBlank (message = "El tipoDocumento no puede estar vacio")
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id")
    @ManyToOne
    private TipoDocumento tipoDocumento;

    @NonNull
    @NotBlank (message = "El Documento no puede estar vacio")
    @Column(name = "documento",unique = true)
    private String numeroDocumento;

    @NonNull
    @NotBlank (message = "La fecha de nacimiento no puede estar vacia")
    @Past
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
}

