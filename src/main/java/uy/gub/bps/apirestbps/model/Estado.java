package uy.gub.bps.apirestbps.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestado;

    @Column(name = "descestado")
    private String descestado;

    public Estado(String descestado) {
        this.descestado = descestado;
    }
}
