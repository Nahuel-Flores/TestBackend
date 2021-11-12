package com.mobydigital.test.repositorys;

import com.mobydigital.test.models.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoXTecnologia,Long> {
}
