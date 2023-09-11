package uy.gub.bps.apirestbps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uy.gub.bps.apirestbps.model.security.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /*@Query(value = "{call sp_AutenticarUsuario(:_usuario, :_password)}",
    nativeQuery = true)
    Optional<Usuario> autenticarUsuarioMySQL(@Param("_usuario") String _usuario,
                                             @Param("_password") String _password);*/

    @Procedure(procedureName = "sp_AutenticarUsuario")
    Optional<Usuario> autenticarUsuario(String _usuario, String _password);

}
