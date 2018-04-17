CREATE TABLE productos (
  idProducto int(11) NOT NULL AUTO_INCREMENT,
  nombreProductoPat varchar(50) NOT NULL,
  nombreProductoGen varchar(50) NOT NULL,
  contenidoCaja varchar(50) NOT NULL,
  stockActual int(11) NOT NULL,
  stockMinimo int(11) not null,
  idAdministracion int(11) NOT NULL,
  idTipo int(11) NOT NULL,
  status bit(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (idProducto)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE tipoproducto (
  idTipo int(11) NOT NULL AUTO_INCREMENT,
  tipo varchar(50) NOT NULL,
  status bit(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (idTipo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE medioadministracion (
  idAdministracion int(11) NOT NULL AUTO_INCREMENT,
  administracion varchar(50) NOT NULL,
  status bit(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (idAdministracion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE asignaciones(
	idAsignacion INT NOT NULL AUTO_INCREMENT,
	idPaciente INT NOT NULL,
	fecha DATE NOT NULL,
	PRIMARY KEY (idAsignacion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Compras(
	idCompra INT NOT NULL AUTO_INCREMENT,
	farmacia VARCHAR(50) NOT NULL,
	numFactura varchar(50) NOT NULL,
	costo DECIMAL(15,2) NOT NULL,
	PRIMARY KEY (idCompra)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE detalleEntrada(
	idDetalleEntrada INT NOT NULL AUTO_INCREMENT,
	idProducto INT NOT NULL,
	entrada INT NOT NULL,
	tipoEntrada VARCHAR(20) NOT NULL,
	idCompra INT,
	fechaEntrada DATE NOT NULL,
	caducidad INT NOT NULL,
	PRIMARY KEY (idDetalleEntrada)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE detalleAsignacion(
	idDetAsignacion INT NOT NULL AUTO_INCREMENT,
	idAsignacion INT NOT NULL,
	idProducto INT NOT NULL,
	cantidad INT NOT NULL,
	PRIMARY KEY (idDetAsignacion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DELIMITER $$

CREATE PROCEDURE sp_adm_elm (id varchar(50))  
BEGIN 
UPDATE medioadministracion SET status = 0 WHERE administracion = id;
END$$

CREATE PROCEDURE sp_adm_ins (admin VARCHAR(50))  
BEGIN 
INSERT INTO medioadministracion (administracion) VALUES (admin);
END$$

CREATE PROCEDURE sp_adm_lis (id varchar(50))  
BEGIN 
SELECT * FROM medioadministracion WHERE administracion = id AND status = 1;
END$$ 

CREATE PROCEDURE sp_adm_id (id int)  
BEGIN 
SELECT * FROM medioadministracion WHERE idAdministracion = id AND status = 1;
END$$

CREATE PROCEDURE sp_adm_mod (id int, admin VARCHAR(50))  
BEGIN 
UPDATE medioadministracion SET administracion = admin WHERE administracion = id;
END$$

CREATE PROCEDURE sp_adm_sel () 
BEGIN 
SELECT * FROM medioadministracion WHERE status = 1;
END$$

CREATE PROCEDURE sp_adm_bus (letra varchar(50)) 
BEGIN 
SELECT idAdministracion, administracion as 'medio de administracion' FROM medioadministracion WHERE status = 1 and administracion like concat(letra,'%'); 
END$$

CREATE PROCEDURE sp_prod_elm (id varchar(50)) 
BEGIN
UPDATE productos SET status = 0 WHERE nombreProductoPat = id;
END$$

CREATE PROCEDURE sp_prod_ins (nombre VARCHAR(50), generico VARCHAR(50), contenido VARCHAR(50), cantidad INT, stockMin int, idAdmin INT, idtip INT)  
BEGIN 
INSERT INTO productos (nombreProductoPat, nombreProductoGen, contenidoCaja, stockActual, stockMinimo, idAdministracion, idTipo) VALUES (nombre, generico, contenido, cantidad, stockMin, idAdmin, idTip);
END$$

CREATE PROCEDURE sp_prod_lis (id varchar(50))  
BEGIN 
SELECT * FROM productos WHERE nombreProductoPat = id AND status = 1;
END$$ 

CREATE PROCEDURE sp_prod_mod (idProd int, nombre varchar(50), generico varchar(50), contenido varchar(50), cantidad int, stockMin int, idAdmin int, idTip int)
BEGIN 
UPDATE productos SET nombreProductoPat = nombre, nombreProductoGen = generico, contenidoCaja = contenido, stockActual = cantidad, stockMinimo = stockMin, idAdministracion = idAdmin, idTipo = idTip  WHERE idProducto = idProd;
END$$

CREATE PROCEDURE sp_prod_cc ()
BEGIN 
SELECT idTipo, tipo FROM tipoproducto WHERE status =1;  
END$$

CREATE PROCEDURE sp_prod_cc2 ()
BEGIN 
SELECT idAdministracion, administracion FROM medioadministracion WHERE status =1; 
END$$

CREATE PROCEDURE sp_prod_sel ()  
BEGIN 
SELECT * FROM productos WHERE status = 1;
END$$

CREATE PROCEDURE sp_prod_bus (letra varchar(50))  
BEGIN 
SELECT P.idProducto, P.nombreProductoPat as Patente, P.nombreProductoGen as Generico, P.contenidoCaja as Contenido, 
P.stockActual as Exitencias, P.stockMinimo as minimo, M.administracion as 'Metodo de administracion', T.tipo as 'Tipo de producto'  
FROM productos P
INNER JOIN medioadministracion M
ON P.idAdministracion = M.idAdministracion
INNER JOIN tipoproducto T
ON  P.idTipo = T.idTipo
WHERE P.status = 1 and nombreProductoPat like concat(letra,'%');
END$$

CREATE PROCEDURE sp_tip_elm (id varchar(50))  
BEGIN 
UPDATE tipoproducto SET status = 0 WHERE tipo = id;
END$$

CREATE PROCEDURE sp_tip_ins (producto VARCHAR(50))  
BEGIN 
INSERT INTO tipoproducto (tipo) VALUES (producto);
END$$

CREATE PROCEDURE sp_tip_lis (id varchar(50))  
BEGIN 
SELECT * FROM tipoproducto WHERE tipo = id AND status = 1;
END$$ 

CREATE PROCEDURE sp_tip_id (id int)
BEGIN 
SELECT * FROM tipoproducto WHERE idTipo = id;
END$$

CREATE PROCEDURE sp_tip_mod (id int, producto VARCHAR(50))  
BEGIN 
UPDATE tipoproducto SET tipo = producto WHERE tipo = id;
END$$

CREATE PROCEDURE sp_tip_sel ()  
BEGIN 
SELECT * FROM tipoproducto WHERE status = 1;
END$$

CREATE PROCEDURE sp_tip_bus (letra varchar(50))  
BEGIN 
SELECT idTipo, tipo as 'tipo de producto' FROM tipoproducto WHERE status = 1 and tipo like concat(letra,'%');
END$$

CREATE PROCEDURE sp_com_ins(farm varchar(50), fac VARCHAR(50), cos DECIMAL(15, 2))
BEGIN
INSERT INTO compras (farmacia,numFactura,costo) VALUES (farm, fac, cos);
END$$

CREATE PROCEDURE sp_dete_ins1 (idprod INT , ent INT, tip VARCHAR(50), cad DATE)
BEGIN
DECLARE idCom INT;
DECLARE stockNuevo INT;
set idCom = (select idCompra from compras ORDER by idCompra DESC LIMIT 1);
INSERT INTO detalleentrada (idProducto, entrada, tipoEntrada, idCompra, fechaEntrada, caducidad) VALUES (idprod, ent, tip, idcom, CURRENT_DATE(), cad);
UPDATE productos SET stockActual = stockActual + ent WHERE idProducto = idprod;
END$$

CREATE PROCEDURE sp_dete_ins2 (idprod INT , ent INT, tip VARCHAR(50), cad DATE)
BEGIN
INSERT INTO detalleentrada (idProducto, entrada, tipoEntrada, fechaEntrada, caducidad) VALUES (idprod, ent, tip, CURRENT_DATE(), cad);
UPDATE productos SET stockActual = stockActual + ent WHERE idProducto = idprod;
END$$

CREATE PROCEDURE sp_dete_fil(inicio date, fin date)
BEGIN
SELECT * FROM detalleentrada WHERE fechaEntrada BETWEEN inicio AND fin;
END$$

CREATE PROCEDURE sp_asi_ins(idPac int)
BEGIN
INSERT INTO asignaciones (idPaciente, fecha) VALUES (idPac, CURRENT_DATE());
END$$

CREATE PROCEDURE sp_deta_ins(idProd int, cant int)
BEGIN
DECLARE idAs int;
set idAs = (SELECT idAsignacion FROM asignaciones ORDER BY idAsignacion DESC LIMIT 1);
INSERT INTO detalleasignacion (idAsignacion, idProducto, cantidad) VALUES (idAs, idProd, cant);
UPDATE productos SET stockActual = stockActual - cant WHERE idProducto = idProd;
END$$

CREATE PROCEDURE sp_pac_nom (pac VARCHAR(200))
BEGIN
select * from pacientes where CONCAT (Nombre,' ',ApPat,' ',ApMat) = pac and activo = 1;
END$$

CREATE PROCEDURE sp_pac_tnom ()
BEGIN
select CONCAT (Nombre,' ',ApPat,' ',ApMat) as Nom_Completo from pacientes where activo = 1;
END$$

DELIMITER ;