package DAO;

import java.util.List;

import Model.Imagen;
import Model.Producto;

public interface ImagenDAO {
	
	public boolean 		save  	 (Imagen i);
	public boolean 		update	 (Imagen i);
	public boolean 		delete	 (Imagen i);
	
	public List<Imagen>	getAll			 ();
	public Imagen 		getById	 (Imagen i);
	
	public List<Imagen> producto(Producto p);
}