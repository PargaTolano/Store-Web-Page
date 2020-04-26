package DAO;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Producto;

@Repository
@SuppressWarnings("unchecked")
public class ProductoDAO_Imp implements ProductoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Producto p) {
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
	public boolean update(Producto p) {
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
	public boolean delete(Producto p) {
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
	public List<Producto> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("producto_all", Producto.class);
		List<Producto> list=procedureCall.getResultList();
		list.get(0).getImagenes().size();
		list.get(0).getVideos().size();
		list.get(0).getProductosComprados().size();
		return list;
	}

	@Override
	public Producto getById(Producto p) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("producto_by_id",Producto.class);
		procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(p.getId());
		List<Producto> list=procedureCall.getResultList();
		Producto r = list.get(0);
		r.getImagenes().size();
		r.getVideos().size();
		r.getProductosComprados().size();
		return r;
	}
	
	

}
