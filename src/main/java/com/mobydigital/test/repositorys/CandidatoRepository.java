package com.mobydigital.test.repositorys;

import com.mobydigital.test.models.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {
}
