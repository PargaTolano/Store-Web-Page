package Service;

import java.util.List;

import Model.Producto;

public interface Producto_Service {
	
	public Producto save  				(Producto p);
	public Producto update				(Producto p);
	public Producto delete				(Producto p);
	
	public List<Producto> getAll();
	public Producto getById				(Producto p);
}
