package uy.gub.bps.apirestbps.model.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioResponse {

    private Long idusuario;
    private String nomusuario;
    private String token;

}
