package com.mobydigital.test.services.imp;

import com.mobydigital.test.models.dtos.TipoDocumentoDto;
import com.mobydigital.test.models.entities.TipoDocumento;
import com.mobydigital.test.repositorys.TipoDocumentoRepository;
import com.mobydigital.test.services.TipoDocumentoService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class TipoDocumentoServiceImp implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoDocumentoDto guardar(TipoDocumentoDto tipoDocumentoDto) {
        TipoDocumento tipoDocumento = modelMapper.map(tipoDocumentoDto, TipoDocumento.class);
        return modelMapper.map(tipoDocumentoRepository.save(tipoDocumento), TipoDocumentoDto.class);
    }

    @Override
    public void eliminar(TipoDocumentoDto tipoDocumentoDto) {
        TipoDocumento tipoDocumento = modelMapper.map(tipoDocumentoDto, TipoDocumento.class);
        tipoDocumentoRepository.delete(tipoDocumento);
        if (!tipoDocumentoRepository.existsById(tipoDocumento.getId())){
            log.info("El tipoDNI fue eliminado con exito.");
        }
    }

    @Override
    public List<TipoDocumentoDto> listarTodas() {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        List<TipoDocumentoDto> tipoDocumentoDtos = new ArrayList<>();

        for (TipoDocumento tipoDocumento : tipoDocumentos) {
            tipoDocumentoDtos.add(modelMapper.map(tipoDocumento, TipoDocumentoDto.class));
        }

        return tipoDocumentoDtos;
    }
}
