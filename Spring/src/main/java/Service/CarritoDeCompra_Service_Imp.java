package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.CarritoDeCompraDAO;
import Model.CarritoDeCompra;



@Service
@Transactional
public class CarritoDeCompra_Service_Imp implements CarritoDeCompra_Service {

	@Autowired
	private CarritoDeCompraDAO carritodecompradao;
	
	@Override
	public boolean removeCarrito(CarritoDeCompra c) {
		return carritodecompradao.removeCarrito(c);
	}

	@Override
	public boolean updateCarrito(CarritoDeCompra c) {
		return carritodecompradao.updateCarrito(c);
	}

	@Override
	public boolean addCarrito(CarritoDeCompra c) {
		return carritodecompradao.addCarrito(c);
	}

	@Override
	public List<CarritoDeCompra> get() {
		return carritodecompradao.get();
	}

}
