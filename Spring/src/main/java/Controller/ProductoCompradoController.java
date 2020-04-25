package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Model.ProductoComprado;
import Service.ProductoComprado_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ProductoCompradoController {

	@Autowired
	private ProductoComprado_Service productoCompradoService;
	
	@GetMapping("productocomprado-list")
	public List<ProductoComprado> usuariosAll()
	{
		return productoCompradoService.getAll();
	}
	
	@GetMapping("productocomprado-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(productoCompradoService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
}
