package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import Model.Imagen;
import Service.Imagen_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ImagenController {
	
	@Autowired
	private Imagen_Service imagenService;
	
	@GetMapping("imagen-list")
	public List<Imagen> usuariosAll()
	{
		return imagenService.getAll();
	}
	
	@GetMapping("imagen-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(imagenService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
}
