package DAO;

import java.util.List;

import Model.Usuario;

public interface UsuarioDAO {
	
	public boolean save  (Usuario u);
	public boolean delete(Usuario u);
	public boolean update(Usuario u);
	
	public List<Usuario> getAll			();
	public Usuario getById				(int id);
	public Usuario getByNombreUsuario	(Usuario u);
	public Usuario getByCorreo			(Usuario u);
	
	public Usuario logIn 			    (String user, String password);
	
}
