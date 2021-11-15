package com.mobydigital.test.controllers;

import com.mobydigital.test.models.dtos.TecnologiaDto;
import com.mobydigital.test.services.TecnologiaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Log
@RequestMapping(value = "/api/tecnologia")
@RestController
public class TecnologiaController {

    @Autowired
    TecnologiaService tecnologiaService;

    @PostMapping(value = "/crear")
    public ResponseEntity<TecnologiaDto> crearCandidato(@RequestBody TecnologiaDto tecnologiaDto) {
        return new ResponseEntity<>(tecnologiaService.guardar(tecnologiaDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<TecnologiaDto> actualizarCandidato(@RequestBody TecnologiaDto tecnologiaDto){
        return new ResponseEntity<>(tecnologiaService.modificar(tecnologiaDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar")
    public ResponseEntity<String> eliminarCandidato(@RequestBody TecnologiaDto tecnologiaDto) {
        tecnologiaService.eliminar(tecnologiaDto);
        return new ResponseEntity<>("Candidato eliminado." ,HttpStatus.OK);
    }

    @GetMapping(value = "/listartodas")
    public ResponseEntity<List<TecnologiaDto>> listarTodas() {
        return new ResponseEntity<>(tecnologiaService.listarTodas(), HttpStatus.OK);
    }

}
