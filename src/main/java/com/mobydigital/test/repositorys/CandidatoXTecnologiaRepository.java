package com.mobydigital.test.repositorys;

import com.mobydigital.test.models.entities.CandidatoXTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CandidatoXTecnologiaRepository extends JpaRepository<CandidatoXTecnologia,Long> {

    @Query(value ="SELECT cxt.id_candidato_x_tecnologia, cxt.id_candidato, cxt.id_tecnologia ,cxt.anios_experiencia"
            +"FROM candidato_x_tecnologia cxt"
            +"INNER JOIN tecnologias t ON cxt.id_tecnologia = t.id"
            +"WHERE t.nombre LIKE ?1",nativeQuery = true)
    List<CandidatoXTecnologia> findCandidatosXTecnologiaByTecnologia(String nombreTecnologia);

}
