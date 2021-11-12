package com.mobydigital.test.services.imp;

import com.mobydigital.test.exceptions.NotFoundException;
import com.mobydigital.test.models.dtos.TecnologiaDto;
import com.mobydigital.test.models.entities.Tecnologia;
import com.mobydigital.test.repositorys.TecnologiaRepository;
import com.mobydigital.test.services.TecnologiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TecnologiaServiceImp implements TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public TecnologiaDto guardar(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        return modelMapper.map(tecnologiaRepository.save(tecnologia), TecnologiaDto.class);
    }

    @Override
    public TecnologiaDto modificar(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        Tecnologia tecnologiaBuscado = tecnologiaRepository.findById(tecnologia.getId()).orElseThrow(() -> new EntityNotFoundException("No se encontró la Tecnologia: " + tecnologia.getId()));
        if (tecnologiaBuscado != null){
            return modelMapper.map(tecnologiaRepository.save(tecnologia),TecnologiaDto.class);
        }
        else {
            throw new NotFoundException("No fue encontrada la tecnologia con id: ",tecnologia.getId());
        }
    }

    @Override
    public void eliminar(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = modelMapper.map(tecnologiaDto,Tecnologia.class);
        tecnologiaRepository.delete(tecnologia);
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
