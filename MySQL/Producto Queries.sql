DELIMITER //
CREATE PROCEDURE ejemplo2.producto_all
()
BEGIN
SELECT P.Id, P.Nombre, P.Descripcion, P.Unidades, P.Precio, P.Descuento
FROM   ejemplo2.producto P;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.producto_by_id
(IN id INTEGER)
BEGIN
SELECT P.Id, P.Nombre, P.Descripcion, P.Unidades, P.Precio, P.Descuento
FROM   ejemplo2.producto P
WHERE p.id = id;
END //DELIMITER ;
/*
INSERT INTO producto(descripcion, descuento, nombre, precio, unidades) 
VALUES ('libro bien wonito', 15, 'El Prisinpito', 15.98, 69);

INSERT INTO IMAGEN(bytes, productos_id)
VALUES('https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',1);

INSERT INTO producto_imagen(producto_id, imagenes_id)
VALUES(1,1);

INSERT INTO video(bytes, productos_id)
VALUES('https://www.elejandria.com/covers/El_principito-Antoine_De_Saint_Exupery-lg.png',1);

INSERT INTO producto_video(producto_id, videos_id)
VALUES(1,1);

call producto_all;

call producto_by_id(1);
*/