package uy.gub.bps.apirestbps.model;

import javax.persistence.*;

@Entity
@Table(name ="estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestado;

    @Column(name = "descestado")
    private String descestado;

}
