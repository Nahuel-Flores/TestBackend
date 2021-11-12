package com.testBackend.testBackend.repositorys;

import com.testBackend.testBackend.models.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoXTecnologia,Long> {
}
