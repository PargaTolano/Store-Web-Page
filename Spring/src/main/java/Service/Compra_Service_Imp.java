package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.CompraDAO;
import Model.Compra;

@Service
@Transactional
public class Compra_Service_Imp implements Compra_Service {

	@Autowired
	private CompraDAO compraDAO;
	
	@Override
	public boolean save(Compra c) {
		return compraDAO.save(c);
	}

	@Override
	public boolean update(Compra c) {
		return compraDAO.update(c);
	}

	@Override
	public boolean delete(Compra c) {
		return compraDAO.delete(c);
	}

	@Override
	public List<Compra> getAll() {
		return compraDAO.getAll();
	}

	@Override
	public Compra getById(Compra c) {
		return compraDAO.getById(c);
	}

}
