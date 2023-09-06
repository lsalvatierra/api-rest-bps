package uy.gub.bps.apirestbps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.gub.bps.apirestbps.exception.ResourceNotFoundException;
import uy.gub.bps.apirestbps.model.Cliente;
import uy.gub.bps.apirestbps.service.ClienteService;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Cliente> buscarClienteXDocumento(
            @PathVariable("documento") String documento
    ){
        Cliente cliente = clienteService
                .buscarClienteXDocumento(documento)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con el documento ="+
                        documento+" no encoentrado"));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


}
