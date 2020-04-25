package DAO;

import Model.Producto;

import java.util.List;

public interface ProductoDAO {
	
	public boolean save  	(Producto p);
	public boolean update	(Producto p);
	public boolean delete	(Producto p);
	
	public List<Producto>getAll();
	public Producto getById	(Producto p);
	public Producto getById (int     id);
}
