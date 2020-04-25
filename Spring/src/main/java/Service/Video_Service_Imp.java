package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.VideoDAO;
import Model.Video;

@Service
@Transactional
public class Video_Service_Imp implements Video_Service {

	@Autowired
	private VideoDAO videodao;
	
	@Override
	public boolean save(Video v) {
		return videodao.save(v);
	}

	@Override
	public boolean update(Video v) {
		return videodao.update(v);
	}

	@Override
	public boolean delete(Video v) {
		return videodao.delete(v);
	}

	@Override
	public List<Video> getAll() {
		return videodao.getAll();
	}

	@Override
	public Video getById(Video v) {
		return videodao.getById(v);
	}

}
