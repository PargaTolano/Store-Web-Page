package DAO;

import java.util.List;

import Model.Imagen;

public interface ImagenDAO {
	
	public boolean save  	(Imagen i);
	public boolean update	(Imagen i);
	public boolean delete	(Imagen i);
	
	public List<Imagen>getAll();
	public Imagen getById	(Imagen i);
}