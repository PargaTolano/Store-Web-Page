USE ejemplo2;

DELIMITER //
CREATE PROCEDURE ejemplo2.LogIn_NombreUsuario
(IN nombreUsuario VARCHAR(15),IN contrasena VARCHAR(20))
BEGIN
	SELECT  u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
	FROM usuario u
	WHERE u.contrasena = contrasena AND u.nombre_usuario = nombreUsuario;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.LogIn_Email
(IN nombreUsuario VARCHAR(40),IN contrasena VARCHAR(20))
BEGIN
	SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar
	FROM usuario u
	WHERE u.contrasena = contrasena AND u.correo = correo;
END //DELIMITER ;

/*
USE indigo;
select*from student

*/