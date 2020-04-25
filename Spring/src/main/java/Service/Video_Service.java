package Service;

import java.util.List;

import Model.Video;

public interface Video_Service {

	public boolean save  				(Video v);
	public boolean update				(Video v);
	public boolean delete				(Video v);
	
	public List<Video> getAll();
	public Video getById				(Video v);
}
