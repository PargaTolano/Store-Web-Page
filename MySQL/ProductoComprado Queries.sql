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