package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import Model.Producto;
import Service.Producto_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ProductoController {

	@Autowired
	private Producto_Service productoService;
	
	@GetMapping("productos-list")
	public List<Producto> usuariosAll()
	{
		return productoService.getAll();
	}
	
	@GetMapping("productos-id/{id}")
	public Producto getById(@PathVariable(name="id") int id)
	{
		Producto p = new Producto();
		p.setId(id);
		return productoService.getById(p);
	}
	
	@GetMapping("productos-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(productoService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
}
