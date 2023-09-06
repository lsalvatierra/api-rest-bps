package uy.gub.bps.apirestbps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.gub.bps.apirestbps.model.Sala;
import uy.gub.bps.apirestbps.repository.SalaRepository;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> obtenerSalas(){
        return salaRepository.findAll();
    }

}
