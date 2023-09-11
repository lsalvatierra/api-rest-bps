package uy.gub.bps.apirestbps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.gub.bps.apirestbps.model.security.RolUsuario;
import uy.gub.bps.apirestbps.model.security.Usuario;
import uy.gub.bps.apirestbps.repository.RolUsuarioRepository;
import uy.gub.bps.apirestbps.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeguridadService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    public Optional<Usuario> autenticarUsuario(String usuario,
                                               String password){
        Optional<Usuario> objUsuario =
                usuarioRepository.autenticarUsuario(usuario, password);
        if(objUsuario.equals(null)){
            return Optional.empty();
        }
        return objUsuario;
    }

    public String[] listarRolesPorUsuario(int idusuario){
        List<RolUsuario> rolUsuarioList =
                rolUsuarioRepository.listarRolesPorUsuario(idusuario);
        String[] lisRoles = new String[rolUsuarioList.size()];
        for (int i =0; i < rolUsuarioList.size(); i++){
            lisRoles[i] = rolUsuarioList.get(i).getNomrol();
        }
        return lisRoles;
    }

}
