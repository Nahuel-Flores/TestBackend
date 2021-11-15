package com.mobydigital.test.services.imp;

import com.mobydigital.test.exceptions.NotFoundException;
import com.mobydigital.test.models.dtos.CandidatoXTecnologiaDto;
import com.mobydigital.test.models.entities.CandidatoXTecnologia;
import com.mobydigital.test.repositorys.CandidatoXTecnologiaRepository;
import com.mobydigital.test.services.CandidatoXTecnologiaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class CandidatoXTecnologiaServiceImp implements CandidatoXTecnologiaService {

    @Autowired
    CandidatoXTecnologiaRepository candidatoXTecnologiaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CandidatoXTecnologiaDto guardar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologia = modelMapper.map(candidatoXTecnologiaDto,CandidatoXTecnologia.class);
        return modelMapper.map(candidatoXTecnologiaRepository.save(candidatoXTecnologia),CandidatoXTecnologiaDto.class);
    }

    @Override
    public CandidatoXTecnologiaDto modificar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologiaBuscado = candidatoXTecnologiaRepository.findById(candidatoXTecnologiaDto.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró el candidato: " + candidatoXTecnologiaDto.getId()));
        if (candidatoXTecnologiaBuscado != null){
            return guardar(candidatoXTecnologiaDto);
        }
        else {
            throw new NotFoundException("No fue encontrado el candidatoXTecnologia con id: ",candidatoXTecnologiaDto.getId());
        }
    }

    @Override
    public void eliminar(CandidatoXTecnologiaDto candidatoXTecnologiaDto) {
        CandidatoXTecnologia candidatoXTecnologia = modelMapper.map(candidatoXTecnologiaDto,CandidatoXTecnologia.class);
        candidatoXTecnologiaRepository.delete(candidatoXTecnologia);
        if (!candidatoXTecnologiaRepository.existsById(candidatoXTecnologia.getId())){
            log.info("El candidatoXTecnologia fue eliminado con exito.");
        }
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
