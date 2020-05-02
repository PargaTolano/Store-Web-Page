package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Imagen;
import Model.Producto;
import Model.ProductoComprado;
import Model.Video;

@Repository
@SuppressWarnings("unchecked")
public class ProductoDAO_Imp implements ProductoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Producto save(Producto p) {
		try {
			sessionFactory.getCurrentSession().save(p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Producto update(Producto p) {
		try {
			sessionFactory.getCurrentSession().update(p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Producto delete(Producto p) {
		try {
			sessionFactory.getCurrentSession().update(p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Producto> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		System.out.println(currentSession);
		
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("producto_all", Producto.class);
		List<Producto> list=procedureCall.getResultList();
		
		for(Producto p : list)
		{
			Hibernate.initialize(p.getImagenes());
			Hibernate.initialize(p.getVideos());
			Hibernate.initialize(p.getProductosComprados());
		}
		
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
