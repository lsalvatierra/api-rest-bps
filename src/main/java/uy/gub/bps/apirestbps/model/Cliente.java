package uy.gub.bps.apirestbps.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
    @Column(name = "nomcliente")
    private String nomcliente;
    @Column(name = "apecliente")
    private String apecliente;
    @Column(name = "dnicliente")
    private String dnicliente;

}
