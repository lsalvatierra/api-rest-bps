package uy.gub.bps.apirestbps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uy.gub.bps.apirestbps.convertdto.DtoEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDto implements DtoEntity {

    private Integer idsala;
    private String descsala;
    private Integer asientos;

}
