package Service;

import java.util.List;

import Model.Producto;

public interface Producto_Service {
	
	public boolean save  				(Producto p);
	public boolean update				(Producto p);
	public boolean delete				(Producto p);
	
	public List<Producto> getAll();
	public Producto getById				(Producto p);
}
