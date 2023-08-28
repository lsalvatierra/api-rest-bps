package uy.gub.bps.apirestbps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.gub.bps.apirestbps.model.Estado;
import uy.gub.bps.apirestbps.repository.EstadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService implements BaseService<Estado> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> obtenerTodo() {
        return estadoRepository.findAll();
    }

    @Override
    public Optional<Estado> obtenerPorId(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        if(estado.equals(null)){
            return Optional.empty();
        }else{
            return estado;
        }
    }

    @Override
    public Estado guardar(Estado entidad) {
        return estadoRepository.save(entidad);
    }
}
