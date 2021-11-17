package com.mobydigital.test.services.imp;

import com.mobydigital.test.exceptions.NotFoundException;
import com.mobydigital.test.models.dtos.TecnologiaDto;
import com.mobydigital.test.models.entities.Tecnologia;
import com.mobydigital.test.repositorys.TecnologiaRepository;
import com.mobydigital.test.services.TecnologiaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class TecnologiaServiceImp implements TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TecnologiaDto guardar(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        return modelMapper.map(tecnologiaRepository.save(tecnologia), TecnologiaDto.class);
    }

    @Override
    public TecnologiaDto modificar(TecnologiaDto tecnologiaDto) {

        tecnologiaRepository.findById(tecnologiaDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No fue encontrada la tecnologia con id: " + tecnologiaDto.getId()));
            return guardar(tecnologiaDto);
    }

    @Override
    public void eliminar(TecnologiaDto tecnologiaDto) {
        tecnologiaRepository.findById(tecnologiaDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se pudo eliminar ya que no fue encontrada la tecnologia con id: " + tecnologiaDto.getId()));

        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        tecnologiaRepository.delete(tecnologia);
        if (!tecnologiaRepository.existsById(tecnologiaDto.getId())){
            log.info("La tecnologia fue eliminado con exito.");
        }
    }

    @Override
    public List<TecnologiaDto> listarTodas() {
        List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
        List<TecnologiaDto> tecnologiaDtos = new ArrayList<>();

        for (Tecnologia tecnologia: tecnologias) {
            tecnologiaDtos.add(modelMapper.map(tecnologia,TecnologiaDto.class));
        }

        return tecnologiaDtos;
    }
}
