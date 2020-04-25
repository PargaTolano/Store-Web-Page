package DAO;

import java.util.List;

import Model.Compra;

public interface CompraDAO {

	public boolean save  	(Compra c);
	public boolean update	(Compra c);
	public boolean delete	(Compra c);
	
	public List<Compra>getAll();
	public Compra getById	(Compra c);
}
