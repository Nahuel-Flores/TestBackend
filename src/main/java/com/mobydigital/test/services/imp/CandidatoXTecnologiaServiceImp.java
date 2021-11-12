package com.mobydigital.test.services.imp;

import com.mobydigital.test.models.dtos.CandidatoXTecnologiaDto;
import com.mobydigital.test.models.entities.CandidatoXTecnologia;
import com.mobydigital.test.repositorys.CandidatoXTecnologiaRepository;
import com.mobydigital.test.services.CandidatoXTecnologiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoXTecnologiaServiceImp implements CandidatoXTecnologiaService {

    @Autowired
    CandidatoXTecnologiaRepository candidatoXTecnologiaRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public CandidatoXTecnologiaDto guardar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologia = modelMapper.map(candidatoXTecnologiaDto,CandidatoXTecnologia.class);
        return modelMapper.map(candidatoXTecnologiaRepository.save(candidatoXTecnologia),CandidatoXTecnologiaDto.class);
    }

    @Override
    public CandidatoXTecnologiaDto modificar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologia = modelMapper.map(candidatoXTecnologiaDto,CandidatoXTecnologia.class);
        CandidatoXTecnologia candidatoXTecnologiaBuscado = candidatoXTecnologiaRepository.findById(candidatoXTecnologia.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró el candidato: " + candidatoXTecnologia.getId()));
        if (candidatoXTecnologiaBuscado != null){
            return modelMapper.map(candidatoXTecnologiaRepository.save(candidatoXTecnologia),CandidatoXTecnologiaDto.class);
        }
        else {
            return null;
        }
    }

    @Override
    public void eliminar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologia = modelMapper.map(candidatoXTecnologiaDto,CandidatoXTecnologia.class);
        candidatoXTecnologiaRepository.delete(candidatoXTecnologia);
    }

    @Override
    public List<CandidatoXTecnologiaDto> listarTodos() {
        List<CandidatoXTecnologia> candidatoXTecnologias = candidatoXTecnologiaRepository.findAll();
        List<CandidatoXTecnologiaDto> candidatoXTecnologiaDtos = new ArrayList<>();

        for (CandidatoXTecnologia candidatoXTecnologia: candidatoXTecnologias) {
            candidatoXTecnologiaDtos.add(modelMapper.map(candidatoXTecnologia,CandidatoXTecnologiaDto.class));
        }

        return candidatoXTecnologiaDtos;
    }

    @Override
    public List<CandidatoXTecnologiaDto> findCandidatosXTecnologiaByTecnologia(String nombreTecnologia) {
        List<CandidatoXTecnologia> candidatoXTecnologias = candidatoXTecnologiaRepository.findCandidatosXTecnologiaByTecnologia(nombreTecnologia);
        List<CandidatoXTecnologiaDto> candidatoXTecnologiaDtos = new ArrayList<>();

        for (CandidatoXTecnologia candidatoXTecnologia: candidatoXTecnologias) {
            candidatoXTecnologiaDtos.add(modelMapper.map(candidatoXTecnologia,CandidatoXTecnologiaDto.class));
        }

        return candidatoXTecnologiaDtos;
    }
}
