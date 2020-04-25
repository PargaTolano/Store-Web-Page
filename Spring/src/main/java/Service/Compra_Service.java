package Service;

import java.util.List;

import Model.Compra;

public interface Compra_Service {

	public boolean save  				(Compra c);
	public boolean update				(Compra c);
	public boolean delete				(Compra c);
	
	public List<Compra> getAll();
	public Compra getById				(Compra c);
}
