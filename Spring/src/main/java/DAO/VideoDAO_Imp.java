package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Imagen;
import Model.Video;

@Repository
@SuppressWarnings("unchecked")
public class VideoDAO_Imp implements VideoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Video v) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(v);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean update(Video v) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(v);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(Video v) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(v);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Video> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("video_all", Imagen.class);
		List<Video> list=procedureCall.getResultList();
		return list;
	}

	@Override
	public Video getById(Video v) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("video_by_id",Imagen.class);
		procedureCall.setParameter("id", v.getId());
		List<Video> list=procedureCall.getResultList();
		return list.get(0);
	}

}