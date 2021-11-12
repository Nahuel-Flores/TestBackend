package com.testBackend.testBackend.repositorys;

import com.testBackend.testBackend.models.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {
}
