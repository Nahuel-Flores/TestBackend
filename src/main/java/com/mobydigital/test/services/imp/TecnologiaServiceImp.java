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

        Tecnologia tecnologiaBuscado = tecnologiaRepository.findById(tecnologiaDto.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró la Tecnologia: " + tecnologiaDto.getId()));
        if (tecnologiaBuscado != null){
            return guardar(tecnologiaDto);
        }
        else {
            throw new NotFoundException("No fue encontrada la tecnologia con id: ",tecnologiaDto.getId());
        }
    }

    @Override
    public void eliminar(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        tecnologiaRepository.delete(tecnologia);
        if (!tecnologiaRepository.existsById(tecnologia.getId())){
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
