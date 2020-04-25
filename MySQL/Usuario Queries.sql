DELIMITER //
CREATE PROCEDURE ejemplo2.save_usuario
(IN nombre VARCHAR(40),IN apellido VARCHAR(40),IN correo VARCHAR(40), IN nombreUsuario VARCHAR(15), IN contrasena VARCHAR(20), IN telefono BIGINT,IN direccion  VARCHAR(200), IN avatar BLOB)
BEGIN

INSERT INTO ejemplo2.usuario(nombre, apellido,correo, nombre_usuario, contrasena, telefono, direccion, avatar)
VALUES(nombre, apellido, correo, nombreUsuario, contrasena, telefono, direccion, avatar);
	
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.usuario_todos
()
BEGIN
SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
FROM   ejemplo2.usuario U;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.usuario_by_id
(IN id INT)
BEGIN
SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
FROM   ejemplo2.usuario U 
WHERE  U.ID = ID;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.usuario_by_correo
(IN correo VARCHAR(40))
BEGIN
SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
FROM   ejemplo2.usuario U 
WHERE  U.correo = correo;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.usuario_by_nombre_usuario
(IN nombre_usuario VARCHAR(40))
BEGIN
SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
FROM   ejemplo2.usuario U 
WHERE U.nombre_usuario = nombre_usuario;

END //DELIMITER ;
DELIMITER //
CREATE PROCEDURE ejemplo2.delete_usuario
(IN id INT)
BEGIN
DELETE FROM ejemplo2.usuario
WHERE Usuario.id = id;
END //DELIMITER ;
/*
DROP PROCEDURE ejemplo2.usuario_todos;
DROP PROCEDURE ejemplo2.usuario_by_nombre_usuario;
DROP PROCEDURE ejemplo2.usuario_by_correo;
DROP PROCEDURE ejemplo2.usuario_by_id;
DROP PROCEDURE ejemplo2.save_usuario;
ALTER TABLE ejemplo2.usuario DROP COLUMN nombreUsuario;
*/