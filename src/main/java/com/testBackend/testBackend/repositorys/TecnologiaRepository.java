package com.testBackend.testBackend.repositorys;

import com.testBackend.testBackend.models.entities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Long> {
}
