package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Service.Usuario_Service;

import java.util.List;

import Model.Usuario;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class UsuarioController {
	
	@Autowired
	private Usuario_Service usuarioService;
	
	@GetMapping("usuarios-list")
	public List<Usuario> usuariosAll()
	{
		return usuarioService.getAll();
	}
	
	@PostMapping("usuarios-add")
	private boolean usuariosAdd(@RequestBody Usuario u)
	{
		return usuarioService.save(u);
	}
	
	@GetMapping("usuarios-json")
	public @ResponseBody String usariosJson()
	{
		String innerHTML = new Gson().toJson(usuarioService.getAll());
		
		String HTML = "<div style='color:white;background:black;width:100%;height:300px;'>"
		+innerHTML
		+"</div>";
		
		return HTML;
	}
	
	@GetMapping("usuarios-id/{id}")
	public Usuario usuarioId(@PathVariable("id") int id)
	{
		return usuarioService.getById(id);
	}
	
	@PostMapping("usuarios-login")
	public Usuario usuariosLogIn(@RequestBody String[] params)
	{
		return usuarioService.logIn(params[0], params[1]);
	}
}