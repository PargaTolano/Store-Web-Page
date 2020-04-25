package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Compra;

@Repository
@SuppressWarnings("unchecked")
public class CompraDAO_Imp implements CompraDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Compra c) {
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
	public boolean update(Compra c) {
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
	public boolean delete(Compra c) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(c);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Compra> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("compra_all", Compra.class);
		List<Compra> list=procedureCall.getResultList();
		return list;
	}

	@Override
	public Compra getById(Compra c) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("compra_by_id",Compra.class);
		procedureCall.setParameter("id", c.getId());
		List<Compra> list=procedureCall.getResultList();
		return list.get(0);
	}

}
