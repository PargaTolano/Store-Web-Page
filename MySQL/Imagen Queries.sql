DELIMITER //
CREATE PROCEDURE ejemplo2.imagen_all
()
BEGIN
SELECT I.Id, I.productos_id, I.bytes
FROM   ejemplo2.imagen I;
END //DELIMITER ;

DELIMITER //
CREATE PROCEDURE ejemplo2.imagen_by_id
(IN id INTEGER)
BEGIN
SELECT I.Id, I.productos_id, I.bytes
FROM   ejemplo2.imagen I
WHERE  I.id = id;
END //DELIMITER ;