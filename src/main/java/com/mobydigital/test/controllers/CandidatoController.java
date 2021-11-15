package com.mobydigital.test.controllers;

import com.mobydigital.test.models.dtos.CandidatoDto;
import com.mobydigital.test.models.dtos.CandidatoXTecnologiaDto;
import com.mobydigital.test.services.CandidatoService;
import com.mobydigital.test.services.CandidatoXTecnologiaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Log
@RequestMapping(value = "/api/candidato")
@RestController
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private CandidatoXTecnologiaService candidatoXTecnologiaService;

    @PostMapping(value = "/crear")
    public ResponseEntity<CandidatoDto> crearCandidato(@RequestBody CandidatoDto candidatoDto) {
        return new ResponseEntity<>(candidatoService.guardar(candidatoDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<CandidatoDto> actualizarCandidato(@RequestBody CandidatoDto candidatoDto){
        return new ResponseEntity<>(candidatoService.modificar(candidatoDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar")
    public ResponseEntity<String> eliminarCandidato(@RequestBody CandidatoDto candidatoDto) {
        candidatoService.eliminar(candidatoDto);
        return new ResponseEntity<>("Candidato eliminado." ,HttpStatus.OK);
    }

    @GetMapping(value = "/listartodos")
    public ResponseEntity<List<CandidatoDto>> listarTodos() {
        return new ResponseEntity<>(candidatoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/candidatosxtecnologiabynombre/{nombreTecnologia}")
    public ResponseEntity<List<CandidatoXTecnologiaDto>> candidatosXTecnologiaByTecnologia(@PathVariable String nombreTecnologia) {
        return new ResponseEntity<>(candidatoXTecnologiaService.findCandidatosXTecnologiaByTecnologia(nombreTecnologia), HttpStatus.OK);
    }

}
