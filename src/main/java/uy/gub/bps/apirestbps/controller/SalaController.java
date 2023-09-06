package uy.gub.bps.apirestbps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.gub.bps.apirestbps.convertdto.DtoEntity;
import uy.gub.bps.apirestbps.convertdto.DtoUtil;
import uy.gub.bps.apirestbps.dto.SalaDto;
import uy.gub.bps.apirestbps.model.Sala;
import uy.gub.bps.apirestbps.service.SalaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/sala")
public class SalaController {
    @Autowired
    private SalaService salaService;
    @GetMapping("/full")
    public ResponseEntity<List<Sala>> obtenerSalas(){
        List<Sala> salaList = new ArrayList<>();
        salaService.obtenerSalas().forEach(salaList::add);
        if(salaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(salaList, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<DtoEntity>> obtenerSalasDto()
    {
        List<DtoEntity> salas = new ArrayList<>();
        salas = salaService.obtenerSalas().stream()
                .map(x -> new DtoUtil().convertirADto(x, new SalaDto()))
                .collect(Collectors.toList());
        if(salas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(salas, HttpStatus.OK);
    }

}

