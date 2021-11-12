package com.mobydigital.test.services.imp;

import com.mobydigital.test.models.dtos.CandidatoDto;
import com.mobydigital.test.models.dtos.TipoDNIDto;
import com.mobydigital.test.models.entities.Candidato;
import com.mobydigital.test.models.entities.TipoDNI;
import com.mobydigital.test.repositorys.TipoDNIRepository;
import com.mobydigital.test.services.TipoDNIService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TipoDNIServiceImp implements TipoDNIService {

    @Autowired
    private TipoDNIRepository tipoDNIRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public TipoDNIDto guardar(TipoDNIDto tipoDNIDto) {
        TipoDNI tipoDNI = modelMapper.map(tipoDNIDto,TipoDNI.class);
        return modelMapper.map(tipoDNIRepository.save(tipoDNI), TipoDNIDto.class);
    }

    @Override
    public void eliminar(TipoDNIDto tipoDNIDto) {
        TipoDNI tipoDNI = modelMapper.map(tipoDNIDto,TipoDNI.class);
        tipoDNIRepository.delete(tipoDNI);
    }

    @Override
    public List<TipoDNIDto> listarTodas() {
        List<TipoDNI> tipoDNIS = tipoDNIRepository.findAll();
        List<TipoDNIDto> tipoDNIDtos = new ArrayList<>();

        for (TipoDNI tipoDNI: tipoDNIS) {
            tipoDNIDtos.add(modelMapper.map(tipoDNI,TipoDNIDto.class));
        }

        return tipoDNIDtos;
    }
}
