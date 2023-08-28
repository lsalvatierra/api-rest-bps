/*Insert en la tabla Estado*/
INSERT INTO ESTADO (DescEstado) VALUES ('ACTIVO');
INSERT INTO ESTADO (DescEstado) VALUES ('INACTIVO');
INSERT INTO ESTADO (DescEstado) VALUES ('OCUPADO');
INSERT INTO ESTADO (DescEstado) VALUES ('LIBRE');
INSERT INTO ESTADO (DescEstado) VALUES ('REALIZADA');
INSERT INTO ESTADO (DescEstado) VALUES ('CANCELADA');
/*Insert en la tabla Sala*/
INSERT INTO SALA (DescSala,Asientos,IdEstado) VALUES ('SALA 1',14,4);
INSERT INTO SALA (DescSala,Asientos,IdEstado) VALUES ('SALA 2',14,4);
/*Insert en la tabla Pelicula*/
INSERT INTO PELICULA (Titulo,Duracion,Genero,Clasificacion,Formato,IdEstado) VALUES ('THE MOVIE 1',2,'ACCI�N','APTO PARA TODOS','3D',1);
INSERT INTO PELICULA (Titulo,Duracion,Genero,Clasificacion,Formato,IdEstado) VALUES ('THE MOVIE 2',4,'COMEDIA','APTO PARA TODOS','2D',1);
INSERT INTO PELICULA (Titulo,Duracion,Genero,Clasificacion,Formato,IdEstado) VALUES ('THE MOVIE 3',3,'TRILLER','APTO PARA TODOS','2D',1);
INSERT INTO PELICULA (Titulo,Duracion,Genero,Clasificacion,Formato,IdEstado) VALUES ('THE MOVIE 4',3,'ACCI�N','APTO PARA TODOS','3D',1);
INSERT INTO PELICULA (Titulo,Duracion,Genero,Clasificacion,Formato,IdEstado) VALUES ('THE MOVIE 5',3,'TERROR','APTO PARA TODOS','3D',1);
/*ASIENTOS POR SALA */
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (1,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (2,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (3,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (4,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (5,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (6,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (7,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (8,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (9,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (10,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (11,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (12,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (13,1,1);
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (14,1,1);
/* SALA 2*/
INSERT INTO ASIENTO (NroAsiento,IdSala,IdEstado) VALUES (1,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (2,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (3,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (4,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (5,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (6,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (7,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (8,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (9,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (10,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (11,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (12,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (13,2,1);
INSERT INTO ASIENTO(NroAsiento,IdSala,IdEstado) VALUES (14,2,1);
/*Insert en la tabla Cliente*/
INSERT INTO CLIENTE(NomCliente,ApeCliente,DniCliente) VALUES ('JUAN','PEREZ','88888888');
/*Insert en la tabla Cartelera*/
INSERT INTO CARTELERA(IdPelicula,IdSala,HoraInicio,HoraFin,Fecha,IdEstado) 
VALUES (1,1,'18:00:00','19:30:00',CURRENT_TIMESTAMP,1);
/*Insert en la tabla Empleado*/
INSERT INTO EMPLEADO(Nombre,Apellido,FechaContrat,IdEstado) VALUES ('JOSE','HERNANDEZ',CURRENT_TIMESTAMP,1);
/*Insert en la tabla Tiket*/
INSERT INTO TICKET(Tipo,Descripcion,Precio,IdEstado) VALUES ('ENTRADA GENERAL','ENTRADA PARA LAS PERSONAS MAYORES DE 18 ANIOS',10,1);
INSERT INTO TICKET(Tipo,Descripcion,Precio,IdEstado) VALUES ('ENTRADA NINOS','ENTRADA PARA LOS NINOS',5,1);
/*Insert en la tabla Promocion*/
INSERT INTO PROMOCION(Nombre,Descuento,BaseTicket,IdEstado) VALUES ('PROMOCION 3X2',1.0,B'1',1);
INSERT INTO PROMOCION(Nombre,Descuento,BaseTicket,IdEstado) VALUES ('DESCUENTO 30%',0.3,B'1',1);
/*Insert en la tabla PROGRPROMOCION*/
INSERT INTO PROGRPROMOCION(Fecha,Promocion,IdEstado) VALUES (CURRENT_TIMESTAMP,'DESCUENTO 30%',1);
INSERT INTO PROGRPROMOCION(Fecha,Promocion,IdEstado) VALUES (CURRENT_TIMESTAMP,'PROMOCION 3x2',1);

