package uy.gub.bps.apirestbps.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsala;
    @Column(name = "descsala")
    private String descsala;
    @Column(name = "asientos")
    private Integer asientos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idestado")
    private Estado estado;

    @JsonManagedReference
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asiento> asientoList = new ArrayList<>();

}
