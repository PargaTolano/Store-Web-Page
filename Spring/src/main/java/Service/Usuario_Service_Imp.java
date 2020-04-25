package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.UsuarioDAO;
import Model.Usuario;

@Service
@Transactional
public class Usuario_Service_Imp implements Usuario_Service {

	@Autowired
	private UsuarioDAO usuariodao;
	
	@Override
	public boolean save(Usuario u) {
		return usuariodao.save(u);
	}

	@Override
	public boolean update(Usuario u) {
		return usuariodao.update(u);
	}

	@Override
	public boolean delete(Usuario u) {
		return usuariodao.delete(u);
	}

	@Override
	public List<Usuario> getAll() {
		return usuariodao.getAll();
	}

	@Override
	public Usuario getById(int id) {
		return usuariodao.getById(id);
	}

	@Override
	public Usuario getByNombreUsuario(Usuario u) {
		return usuariodao.getByNombreUsuario(u);
	}

	@Override
	public Usuario getByCorreo(Usuario u) {
		return usuariodao.getByCorreo(u);
	}

	@Override
	public Usuario logIn(String user, String password) {
		return usuariodao.logIn(user, password);
	}

}
