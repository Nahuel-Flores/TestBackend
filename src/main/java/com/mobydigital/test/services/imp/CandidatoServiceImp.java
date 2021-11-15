package com.mobydigital.test.services.imp;

import com.mobydigital.test.exceptions.EmptyParamsException;
import com.mobydigital.test.exceptions.NotFoundException;
import com.mobydigital.test.models.entities.Candidato;
import com.mobydigital.test.models.dtos.CandidatoDto;
import com.mobydigital.test.repositorys.CandidatoRepository;
import com.mobydigital.test.services.CandidatoService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class CandidatoServiceImp implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CandidatoDto guardar(CandidatoDto candidatoDto) {
        if (candidatoDto.getNumeroDocumento() != null && candidatoDto.getFechaNacimiento() != null){
            Candidato candidato = modelMapper.map(candidatoDto,Candidato.class);
            return modelMapper.map(candidatoRepository.save(candidato),CandidatoDto.class);
        }else {
            throw new EmptyParamsException("Los parametros numeroDocumento y fechaNacimiento no pueden estar vacios");
        }
    }

    @Override
    public CandidatoDto modificar(CandidatoDto candidatoDto) {
        Candidato candidatoBuscado = candidatoRepository.findById(candidatoDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No fue encontrado el candidato con id: " + candidatoDto.getId()));

        return guardar(candidatoDto);

    }

    @Override
    public void eliminar(CandidatoDto candidatoDto) {
        Candidato candidatoBuscado = candidatoRepository.findById(candidatoDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se pudo eliminar ya que no fue encontrado el candidato con id: " + candidatoDto.getId()));

        Candidato candidato = modelMapper.map(candidatoDto,Candidato.class);
        candidatoRepository.delete(candidato);
        if (!candidatoRepository.existsById(candidato.getId())){
            log.info("El candidato fue eliminado con exito.");
        }

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
