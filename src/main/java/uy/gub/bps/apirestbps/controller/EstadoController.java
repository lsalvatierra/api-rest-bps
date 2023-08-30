package uy.gub.bps.apirestbps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.gub.bps.apirestbps.exception.ResourceNotFoundException;
import uy.gub.bps.apirestbps.model.Estado;
import uy.gub.bps.apirestbps.service.EstadoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;
    @GetMapping("")
    public ResponseEntity<List<Estado>> obtenerTodo(){
        List<Estado> estados = new ArrayList<>();
        estadoService.obtenerTodo().forEach(estados::add);
        if(estados.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable("id") long id){
        Estado estado = estadoService.obtenerPorId(id)
                .orElseThrow(()-> new ResourceNotFoundException("Objeto con el ID="
                        + id +", no encontrado."));
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado){
        Estado newEstado = estadoService.guardar(new Estado(estado.getDescestado()));
        return new ResponseEntity<>(newEstado, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(@PathVariable("id") long id,
                                                   @RequestBody Estado estado){
        Estado currentEstado = estadoService.obtenerPorId(id)
                .orElseThrow(()-> new ResourceNotFoundException("Objeto con el ID="
                        + id +", no encontrado."));
        currentEstado.setDescestado(estado.getDescestado());
        return new ResponseEntity<>(estadoService.guardar(currentEstado), HttpStatus.OK);
    }



}
