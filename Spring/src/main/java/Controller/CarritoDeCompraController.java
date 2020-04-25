package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.CarritoDeCompra;
import Service.CarritoDeCompra_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class CarritoDeCompraController {
	
	@Autowired
	private CarritoDeCompra_Service carritoService;

	@PostMapping("carrito-remove")
	public boolean remove(@RequestBody CarritoDeCompra c)
	{
		return carritoService.removeCarrito(c);
	}
	
	@PostMapping("carrito-update")
	public boolean update(@RequestBody CarritoDeCompra c)
	{
		return carritoService.updateCarrito(c);
	}
	
	@PostMapping("carrito-add")
	public boolean add(@RequestBody CarritoDeCompra c)
	{
		return carritoService.addCarrito(c);
	}
	
	@GetMapping("carrito-get")
	public List<CarritoDeCompra> get()
	{
		return carritoService.get();
	}
}
