package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ImagenDAO;
import Model.Imagen;

@Service
@Transactional
public class Imagen_Service_Imp implements Imagen_Service {

	@Autowired
	private ImagenDAO imagendao;
	
	@Override
	public boolean save(Imagen i) {
		return imagendao.save(i);
	}

	@Override
	public boolean update(Imagen i) {
		return imagendao.update(i);
	}

	@Override
	public boolean delete(Imagen i) {
		return imagendao.delete(i);
	}

	@Override
	public List<Imagen> getAll() {
		return imagendao.getAll();
	}

	@Override
	public Imagen getById(Imagen i) {
		return imagendao.getById(i);
	}
}
