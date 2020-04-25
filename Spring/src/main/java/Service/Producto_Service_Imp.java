package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ProductoDAO;
import Model.Producto;

@Service
@Transactional
public class Producto_Service_Imp implements Producto_Service {

	@Autowired
	private ProductoDAO productodao;
	
	@Override
	public boolean save(Producto p) {
		return productodao.save(p);
	}

	@Override
	public boolean update(Producto p) {
		return productodao.save(p);
	}

	@Override
	public boolean delete(Producto p) {
		return productodao.delete(p);
	}

	@Override
	public List<Producto> getAll() {
		return productodao.getAll();
	}

	@Override
	public Producto getById(Producto p) {
		return productodao.getById(p);
	}

	@Override
	public Producto getById(int id) {
		return productodao.getById(id);
	}

}
