package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.CarritoDeCompra;

@Repository
@SuppressWarnings("unchecked")
public class CarritoDeCompraDAO_Imp implements CarritoDeCompraDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean removeCarrito(CarritoDeCompra c) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().remove(c);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean updateCarrito(CarritoDeCompra c) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(c);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean addCarrito(CarritoDeCompra c) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(c);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<CarritoDeCompra> get() {

		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("carrito_todos",CarritoDeCompra.class);
		List<CarritoDeCompra> list=procedureCall.getResultList();
		return list;
	}

}
