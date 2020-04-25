package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ProductoCompradoDAO;
import Model.ProductoComprado;

@Service
@Transactional
public class ProductoComprado_Service_Imp implements ProductoComprado_Service {

	@Autowired
	private ProductoCompradoDAO productoCompradodao;
	
	@Override
	public boolean save(ProductoComprado p) {
		return productoCompradodao.save(p);
	}

	@Override
	public boolean update(ProductoComprado p) {
		return productoCompradodao.update(p);
	}

	@Override
	public boolean delete(ProductoComprado p) {
		return productoCompradodao.delete(p);
	}

	@Override
	public List<ProductoComprado> getAll() {
		return productoCompradodao.getAll();
	}

	@Override
	public ProductoComprado getById(ProductoComprado p) {
		return productoCompradodao.getById(p);
	}

}
