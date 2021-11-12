package com.mobydigital.test.services.imp;

import com.mobydigital.test.exceptions.NotFoundException;
import com.mobydigital.test.models.entities.Candidato;
import com.mobydigital.test.models.dtos.CandidatoDto;
import com.mobydigital.test.repositorys.CandidatoRepository;
import com.mobydigital.test.services.CandidatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoServiceImp implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public CandidatoDto guardar(CandidatoDto candidatoDto) {
        Candidato candidato = modelMapper.map(candidatoDto,Candidato.class);
        return modelMapper.map(candidatoRepository.save(candidato),CandidatoDto.class);
    }

    @Override
    public CandidatoDto modificar(CandidatoDto candidatoDto) {
        Candidato candidato = modelMapper.map(candidatoDto,Candidato.class);
        Candidato candidatoBuscado = candidatoRepository.findById(candidato.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró el candidato: " + candidato.getId()));
        if (candidatoBuscado != null){
            return modelMapper.map(candidatoRepository.save(candidato),CandidatoDto.class);
        }
        else {
            throw new NotFoundException("No fue encontrado el candidato con id: ",candidato.getId());
        }
    }

    @Override
    public void eliminar(CandidatoDto candidatoDto) {
        Candidato candidato = modelMapper.map(candidatoDto,Candidato.class);
        candidatoRepository.delete(candidato);
    }

    @Override
    public List<CandidatoDto> listarTodos() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        List<CandidatoDto> candidatoDtos = new ArrayList<>();

        for (Candidato candidato: candidatos) {
            candidatoDtos.add(modelMapper.map(candidato,CandidatoDto.class));
        }

        return candidatoDtos;
    }
}
