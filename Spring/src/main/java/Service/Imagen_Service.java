package Service;

import java.util.List;
import Model.Imagen;
import Model.Producto;

public interface Imagen_Service {
	
	public boolean 		save  				(Imagen i);
	public boolean 		update				(Imagen i);
	public boolean 		delete				(Imagen i);
	
	public List<Imagen> getAll						();
	public Imagen 		getById				(Imagen i);
	
	public List<Imagen> producto 		  (Producto p);
}
