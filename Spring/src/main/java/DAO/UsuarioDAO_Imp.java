package DAO;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Usuario;

@Repository
@SuppressWarnings("unchecked")
public class UsuarioDAO_Imp implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Usuario u) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(u);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(Usuario u) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(u);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean update(Usuario u) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(u);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Usuario> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall= currentSession.createStoredProcedureCall("usuario_todos", Usuario.class);
		List<Usuario> list=procedureCall.getResultList();
		return list;
	}

	@Override
	public Usuario getById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("usuario_by_id",Usuario.class);
		procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(id);
		List<Usuario> list=procedureCall.getResultList();
		return list.get(0);
	}

	@Override
	public Usuario getByNombreUsuario(Usuario u) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("usuario_by_nombre_usuario",Usuario.class);
		procedureCall.setParameter("nombre_usuario", u.getNombreUsuario());
		List<Usuario> list=procedureCall.getResultList();
		return list.get(0);
	}

	@Override
	public Usuario getByCorreo(Usuario u) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("usuario_by_correo",Usuario.class);
		procedureCall.setParameter("correo", u.getCorreo());
		List<Usuario> list=procedureCall.getResultList();
		return list.get(0);
	}
	
	@Override
	public Usuario logIn(String user, String password) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("LogIn_NombreUsuario",Usuario.class);
		procedureCall.registerParameter(1, String.class, ParameterMode.IN).bindValue(user);
		procedureCall.registerParameter(2, String.class, ParameterMode.IN).bindValue(password);
		List<Usuario> list=procedureCall.getResultList();
		
		if(list.isEmpty()) 
		{
			
			ProcedureCall procedureCall2=currentSession.createStoredProcedureCall("LogIn_Email",Usuario.class);
			procedureCall2.registerParameter(1, String.class, ParameterMode.IN).bindValue(user);
			procedureCall2.registerParameter(2, String.class, ParameterMode.IN).bindValue(password);
			List<Usuario> list2=procedureCall2.getResultList();
			
			if(list2.isEmpty())
			{
				return null;
			}
			else
			{
				Usuario temp = list2.get(0);
				System.out.println(temp.getNombre() +" "+ temp.getApellido());
				return temp;
			}
			
		}
		else
		{
			Usuario temp = list.get(0);
			System.out.println(temp.getNombre() +" "+ temp.getApellido());
			return temp;
		}
	}

}
