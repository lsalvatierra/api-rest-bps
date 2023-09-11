package uy.gub.bps.apirestbps.model.security;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    private Long idusuario;
    private String nomusuario;
    private String cargousuario;
}
