package uy.gub.bps.apirestbps.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uy.gub.bps.apirestbps.model.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "select * from cliente where DniCliente =:documento",
            nativeQuery = true)
    Optional<Cliente> buscarClientexDocumento(
           @Param("documento") String documento);

    @Query(
            value = "SELECT * FROM cliente WHERE nomcliente LIKE %:nomcliente%",
            nativeQuery = true,
            countQuery = "SELECT count(*) FROM cliente WHERE nomcliente LIKE %:nomcliente%"
    )
    Page<Cliente> buscarClientexNombre(
            @Param("nomcliente") String nomcliente,
            Pageable pageable
    );


}
