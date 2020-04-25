package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.ProductoComprado;

@Repository
@SuppressWarnings("unchecked")
public class ProductoCompradoDAO_Imp implements ProductoCompradoDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(ProductoComprado p) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(p);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean update(ProductoComprado p) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(p);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(ProductoComprado p) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(p);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<ProductoComprado> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("producto_all", ProductoComprado.class);
		List<ProductoComprado> list=procedureCall.getResultList();
		return list;
	}

	@Override
	public ProductoComprado getById(ProductoComprado p) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("producto_by_id",ProductoComprado.class);
		procedureCall.setParameter("id", p.getId());
		List<ProductoComprado> list=procedureCall.getResultList();
		return list.get(0);
	}

}
