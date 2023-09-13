package uy.gub.bps.apirestbps.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uy.gub.bps.apirestbps.exception.ResourceNotFoundException;
import uy.gub.bps.apirestbps.model.security.Usuario;
import uy.gub.bps.apirestbps.model.security.UsuarioResponse;
import uy.gub.bps.apirestbps.service.SeguridadService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/seguridad")
public class SeguridadController {

    @Autowired
    private SeguridadService seguridadService;

    @PostMapping("/autenticacion")
    @Transactional(readOnly = true)
    public ResponseEntity<UsuarioResponse> autenticarUsuario(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password
    ){
        Usuario objUsuario = seguridadService
                .autenticarUsuario(usuario, password)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario o password incorrecto."));
       String token = generarToken(usuario,
                    Integer.parseInt(objUsuario.getIdusuario().toString()));
       UsuarioResponse usuarioResponse =
                    new UsuarioResponse(objUsuario.getIdusuario(),
                            objUsuario.getNomusuario(),
                            token);
       return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }


    private String generarToken(String usuario, int idusuario){
        String clave = "${security.clave}"; // dinamico desde la BD
        List<GrantedAuthority> grantedAuthorityList =
                AuthorityUtils.createAuthorityList(
                        seguridadService.listarRolesPorUsuario(idusuario)
                );
        String token = Jwts
                .builder()
                .setId("@bpsjwt") // Dinámico desde BD
                .setSubject(usuario)
                .claim("authorities",
                        grantedAuthorityList.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                )
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 300000))
                .signWith(SignatureAlgorithm.HS512, clave.getBytes())
                .compact();
        return token;
    }

}
