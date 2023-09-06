package uy.gub.bps.apirestbps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("")
    public ResponseEntity<?> buscarClientexNombre(
            @RequestParam String nombre,
            Pageable pageable
    ){
        Page<Cliente> clientes = clienteService.buscarClienteXNombre(nombre,
                pageable);
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }


}
