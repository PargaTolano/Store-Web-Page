package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Imagen;

@Repository
@SuppressWarnings("unchecked")
public class ImagenDAO_Imp implements ImagenDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Imagen i) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(i);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean update(Imagen i) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(i);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(Imagen i) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(i);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Imagen> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("producto_all", Imagen.class);
		List<Imagen> list=procedureCall.getResultList();
		return list;
	}

	@Override
	public Imagen getById(Imagen i) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("producto_by_id",Imagen.class);
		procedureCall.setParameter("id", i.getId());
		List<Imagen> list=procedureCall.getResultList();
		return list.get(0);
	}

}
