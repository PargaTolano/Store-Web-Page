package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import Model.Compra;
import Service.Compra_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class CompraController {

	@Autowired
	private Compra_Service compraService;
	
	@GetMapping("compra-list")
	public List<Compra> usuariosAll()
	{
		return compraService.getAll();
	}
	
	@GetMapping("compra-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(compraService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
}
