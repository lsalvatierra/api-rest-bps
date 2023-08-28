package uy.gub.bps.apirestbps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uy.gub.bps.apirestbps.model.Estado;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    //public List<Estado> findByDesestado(String descestado);
    //@Query(value = "SELECT e from estado where e.descestado = :descestado")
    @Query(value = "SELECT * FROM estado where descestado =:descestado",
    nativeQuery = true)
    List<Estado> buscarPorDescripcion(
            @Param("descestado") String descestado);

}
