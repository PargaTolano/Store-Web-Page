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