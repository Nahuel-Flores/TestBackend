package com.mobydigital.test.repositorys;

import com.mobydigital.test.models.entities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Long> {
}
