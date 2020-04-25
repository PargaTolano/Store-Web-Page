package DAO;
import java.util.List;
import Model.*;

public interface CarritoDeCompraDAO {
	
	public boolean removeCarrito(CarritoDeCompra c);
	
	public boolean updateCarrito(CarritoDeCompra c);
	
	public boolean addCarrito(CarritoDeCompra c);
	
	public List<CarritoDeCompra> get();
}
