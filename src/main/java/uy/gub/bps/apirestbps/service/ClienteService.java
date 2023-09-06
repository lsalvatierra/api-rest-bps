package uy.gub.bps.apirestbps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uy.gub.bps.apirestbps.model.Cliente;
import uy.gub.bps.apirestbps.repository.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> buscarClienteXDocumento(String documento){
        Optional<Cliente> clienteOptional =
                clienteRepository.buscarClientexDocumento(documento);
        if(clienteOptional.equals(null)){
            return Optional.empty();
        }else {
            return clienteOptional;
        }
    }

    public Page<Cliente> buscarClienteXNombre(String nombre,
                                              Pageable pageable){
        return clienteRepository.buscarClientexNombre(nombre,
                pageable);
    }

}
