package uy.gub.bps.apirestbps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import uy.gub.bps.apirestbps.model.security.RolUsuario;

import java.util.List;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario,
        Long> {

    @Procedure(procedureName = "sp_RolxUsuario")
    List<RolUsuario> listarRolesPorUsuario(int _idusuario);
}
