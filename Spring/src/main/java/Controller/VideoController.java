package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import Model.Video;
import Service.Video_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class VideoController {
	
	@Autowired
	private Video_Service videoService;
	
	@GetMapping("video-list")
	public List<Video> usuariosAll()
	{
		return videoService.getAll();
	}
	
	@GetMapping("video-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(videoService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
}
