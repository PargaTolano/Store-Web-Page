package DAO;

import Model.Producto;

import java.util.List;

public interface ProductoDAO {
	
	public Producto save  	(Producto p);
	public Producto update	(Producto p);
	public Producto delete	(Producto p);
	
	public List<Producto>getAll();
	public Producto getById	(Producto p);
}
