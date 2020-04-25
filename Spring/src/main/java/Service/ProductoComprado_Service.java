package Service;

import java.util.List;

import Model.ProductoComprado;

public interface ProductoComprado_Service {
	
	public boolean save  				(ProductoComprado p);
	public boolean update				(ProductoComprado p);
	public boolean delete				(ProductoComprado p);
	
	public List<ProductoComprado> getAll();
	public ProductoComprado getById				(ProductoComprado p);
}
