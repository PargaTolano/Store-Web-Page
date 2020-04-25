DELIMITER //
CREATE PROCEDURE ejemplo2.carrito_todos
()
BEGIN
SELECT c.Id, c.fecha, c.total, c.usuario_id
FROM   ejemplo2.carritodecompra C;
END //DELIMITER ;

#usuariocall carrito_todos