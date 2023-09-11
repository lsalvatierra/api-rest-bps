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
public class RolUsuario {
    @Id
    private Long idrol;
    private String nomrol;
}
