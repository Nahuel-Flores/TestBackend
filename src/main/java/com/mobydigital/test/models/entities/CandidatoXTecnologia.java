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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidato_x_tecnologia")
public class CandidatoXTecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia_x_candidato")
    private Long id;

    @JoinColumn(name = "id_candidato", referencedColumnName = "id")
    @ManyToOne
    private Candidato candidato;

    @JoinColumn(name = "id_tecnologia", referencedColumnName = "id")
    @ManyToOne
    private Tecnologia tecnologia;

    @NonNull
    @NotBlank(message = "Los anños de experiencia no pueden estar vacios")
    @Column(name = "anios_experiencia")
    private int aniosExperiencia;

}
