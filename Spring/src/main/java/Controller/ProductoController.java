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
	
	@PostMapping("productos-id/{id}")
	public Producto getById(@PathVariable(name="id") int id)
	{
		System.out.println("Servicio Producto id invocado; id = "+ Integer.toString(id));
		Producto p = productoService.getById(id);
		System.out.println(p.getNombre().toString());
		p.getImagenes().forEach(System.out::println);
		return p;
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
