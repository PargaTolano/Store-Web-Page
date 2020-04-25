package Service;

import java.util.List;

import Model.CarritoDeCompra;

public interface CarritoDeCompra_Service {

	public boolean removeCarrito(CarritoDeCompra c);
	
	public boolean updateCarrito(CarritoDeCompra c);
	
	public boolean addCarrito(CarritoDeCompra c);
	
	public List<CarritoDeCompra>get();
}
