

CREATE TABLE Usuario (
  IdUsuario SERIAL NOT NULL,
  NomUsuario varchar(50) NOT NULL,
  PassUsuario varchar(50) NOT NULL,
  CargoUsuario varchar(50) NOT NULL,
  PRIMARY KEY (IdUsuario)
);

CREATE TABLE Rol (
  IdRol SERIAL NOT NULL,
  NomRol varchar(50) NOT NULL,
  PRIMARY KEY (IdRol)
);


CREATE TABLE RolUsuario (
  IdUsuario int NOT NULL,
  IdRol int NOT NULL,
  PRIMARY KEY (IdUsuario,IdRol)
);


insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('lsalvatierra', 12345, 'JEFE');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('hvargas', 12345, 'SUPERVISOR');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('wlazo', 12345, 'EJECUTIVO DE VENTAS');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('hramos', 12345, 'EJECUTIVO DE COMPRAS');

insert into Rol (NomRol) values ('ROLE_ADMIN');
insert into Rol (NomRol) values ('ROLE_VENTAS');
insert into Rol (NomRol) values ('ROLE_COMPRAS');

insert into RolUsuario (IdUsuario, IdRol) values (1,1);
insert into RolUsuario (IdUsuario, IdRol) values (2,2);
insert into RolUsuario (IdUsuario, IdRol) values (2,3);
insert into RolUsuario (IdUsuario, IdRol) values (3,2);
insert into RolUsuario (IdUsuario, IdRol) values (4,3);



CREATE FUNCTION sp_RegistrarEmpleado (_nombre varchar(50), _apellido varchar(50)) RETURNS int AS $$
BEGIN
insert into empleado (Nombre, Apellido, FechaContrat,IdEstado) values (_nombre, _apellido, NOW(), 1);
return 1;
END;
$$ LANGUAGE plpgsql;


SELECT sp_registrarempleado('a','a');

CREATE FUNCTION sp_AutenticarUsuario (_usuario varchar(20), _password varchar(20)) RETURNS  table(IdUsuario int, NomUsuario varchar, CargoUsuario varchar)  AS $$
BEGIN
	return query select u.IdUsuario, u.NomUsuario, u.CargoUsuario  from usuario u where u.NomUsuario = _usuario and u.PassUsuario = _password;
END;
$$ LANGUAGE plpgsql;

--select * from public.sp_AutenticarUsuario('lsalvatierra','12345');

CREATE FUNCTION sp_RolxUsuario (_idusuario INT) RETURNS  table(IdRol int, NomRol varchar)  AS $$
BEGIN
	return query select r.IdRol , r.NomRol   from rol r inner join rolusuario ru on r.IdRol = ru.IdRol where IdUsuario = _idusuario;
END;
$$ LANGUAGE plpgsql;


--select * from public.sp_RolxUsuario(1);