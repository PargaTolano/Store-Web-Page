package DAO;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Imagen;
import Model.Producto;

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
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(i);
			ProcedureCall procedureCall=currentSession.createStoredProcedureCall("Imagen_Producto_Relate");
			procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(i.getProducto().getId());
			procedureCall.registerParameter(2, int.class, ParameterMode.IN).bindValue(i.getId());
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
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("imagen_by_id",Imagen.class);
		procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(i.getId());
		List<Imagen> list=procedureCall.getResultList();
		return list.get(0);
	}

	@Override
	public List<Imagen> producto(Producto p) {
		
		p.getImagenes().size();
		p.getVideos().size();
		p.getProductosComprados().size();
		
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("imagen_producto_by_id",Imagen.class);
		procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(p.getId());
		List<Imagen> list=procedureCall.getResultList();
		
		list.get(0).getProducto().getId();
		return list;
	}

}
