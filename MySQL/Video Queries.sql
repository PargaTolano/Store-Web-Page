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