DROP DATABASE IF EXISTS ejemplo2;

CREATE DATABASE IF NOT EXISTS ejemplo2;

USE ejemplo2;

DELIMITER //
CREATE PROCEDURE ejemplo2.LogIn_NombreUsuario
(IN nombreUsuario VARCHAR(15),IN contrasena VARCHAR(20))
BEGIN
	SELECT  u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar, U.carrito_id
	FROM usuario u
	WHERE u.contrasena = contrasena AND u.nombre_usuario = nombreUsuario;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.LogIn_Email
(IN nombreUsuario VARCHAR(40),IN contrasena VARCHAR(20))
BEGIN
	SELECT u.Id, U.Nombre, U.Apellido, U.Correo, U.Nombre_Usuario, U.Contrasena, U.Telefono, U.Direccion, U.Avatar, U.carrito_id
	FROM usuario u
	WHERE u.contrasena = contrasena AND u.correo = correo;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.save_usuario
(IN nombre VARCHAR(40),IN apellido VARCHAR(40),IN correo VARCHAR(40), IN nombreUsuario VARCHAR(15), IN contrasena VARCHAR(20), IN telefono BIGINT,IN direccion  VARCHAR(200), IN avatar BLOB)
BEGIN

INSERT INTO ejemplo2.usuario(nombre, apellido,correo, nombre_usuario, contrasena, telefono, direccion, avatar)
VALUES(nombre, apellido, correo, nombreUsuario, contrasena, telefono, direccion, avatar);

INSERT INTO ejemplo2.carritodecompra(usuario_id) SELECT u.id FROM usuario u WHERE u.nombre_usuario = nombreUsuario;
	
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

DELIMITER //
CREATE PROCEDURE ejemplo2.producto_all
()
BEGIN
SELECT P.Id, P.Nombre, P.Descripcion, P.Unidades, P.Precio, P.Descuento, P.pdf_id
FROM   ejemplo2.producto P;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.producto_by_id
(IN id INTEGER)
BEGIN
SELECT P.Id, P.Nombre, P.Descripcion, P.Unidades, P.Precio, P.Descuento, P.pdf_id
FROM   ejemplo2.producto P
WHERE p.id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.imagen_all
()
BEGIN
SELECT I.Id, I.producto_id, I.bytes
FROM   ejemplo2.imagen I;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.imagen_by_id
(IN id INTEGER)
BEGIN
SELECT I.Id, I.producto_id, I.bytes
FROM   ejemplo2.imagen I
WHERE  I.id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.imagen_producto_by_id
(IN id INTEGER)
BEGIN
SELECT I.Id, I.producto_id, I.bytes
FROM   ejemplo2.imagen I
WHERE  I.producto_id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.video_all
()
BEGIN
SELECT V.Id, V.productos_id, V.bytes
FROM   ejemplo2.video V;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.video_by_id
(IN id INTEGER)
BEGIN
SELECT V.Id, V.productos_id, V.bytes
FROM   ejemplo2.video V
WHERE p.id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.producto_comprado_all
()
BEGIN
SELECT P.Id, P.costo, P.unidades, P.compra_id, P.producto_id
FROM   ejemplo2.productocomprado P;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.producto_comprado_by_id
(IN id INTEGER)
BEGIN
SELECT P.Id, P.costo, P.unidades, P.compra_id, P.producto_id
FROM   ejemplo2.productocomprado P
WHERE p.id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.compra_all
()
BEGIN
SELECT C.Id, C.Fecha, C.Lugar_Entrega, C.total
FROM   ejemplo2.compra C;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.compra_by_id
(IN id INTEGER)
BEGIN
SELECT I.Id, I.productos_id, I.bytes
FROM   ejemplo2.compra C
WHERE  I.id = id;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.carrito_todos
()
BEGIN
SELECT c.Id ,c.usuario_id
FROM   ejemplo2.carritodecompra C;
END //DELIMITER ;
/*
call save_usuario ('jose','parga','parga.jose@outlook.com', 'PargaHumana','J0s3p4rg4',8114889772,'Paseo Verona 304', 32131213123213);

call usuario_todos;

call carrito_todos;

call producto_all;

#DELETE FROM Producto WHERE ID >1;

call producto_all;

call producto_by_id(1);

call imagen_all;

SELECT*FROM producto_imagen;

#DELETE FROM imagen WHERE id > 1;

call video_all;

call pdf_all;

call imagen_by_id(1)

call imagen_producto_by_id(1)
*/

#########################
#          PDF		    #
#########################

DELIMITER //
CREATE PROCEDURE ejemplo2.PDF_all
()
BEGIN
SELECT PDF.id, PDF.producto_id, PDF.contenido, PDF.nombre
FROM   ejemplo2.PDF;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.PDF_byId
(IN ID INTEGER)
BEGIN
SELECT PDF.id, PDF.producto_id, PDF.contenido, PDF.nombre
FROM   ejemplo2.PDF
WHERE  PDF.ID = ID;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.PDF_Producto_Relate
(IN producto_id INTEGER,IN pdf_id INTEGER)
BEGIN
UPDATE ejemplo2.producto
SET ejemplo2.producto.pdf_id = pdf_id
WHERE ejemplo2.producto.id = producto_id;

END //DELIMITER ;

DELIMITER //
create PROCEDURE ejemplo2.PDF_byProducto
(IN producto_id INTEGER)
BEGIN

SELECT pdf.id, pdf.contenido, pdf.nombre, pdf.producto_id
FROM pdf
where pdf.producto_id = producto_id;

END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.Imagen_Producto_Relate
(IN producto_id INTEGER,IN imagen_id INTEGER)
BEGIN

INSERT INTO producto_imagen
VALUES(producto_id,imagen_id);

END //DELIMITER ;

call Imagen_Producto_Relate(1,1);
SELECT*FROM PRODUCTO_IMAGEN;