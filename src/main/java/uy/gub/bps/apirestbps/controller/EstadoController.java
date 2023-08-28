package uy.gub.bps.apirestbps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "apibps/v1")
public class EstadoController {

    @GetMapping("/saludo")
    public String saludar(){
        return "Hola Rest";
    }

}
