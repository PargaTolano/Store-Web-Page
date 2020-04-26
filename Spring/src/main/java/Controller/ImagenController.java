package Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import Model.Imagen;
import Model.Producto;
import Service.Imagen_Service;
import Service.Producto_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ImagenController {
	
	@Autowired
	private Imagen_Service imagenService;
	@Autowired
	private Producto_Service productoService;
	
	@GetMapping("imagen-list")
	public List<Imagen> usuariosAll()
	{
		return imagenService.getAll();
	}
	
	@PostMapping("imagen-producto")
	public List<Imagen> ImagenesDeProducto(@RequestBody Producto p)
	{
		return imagenService.producto(p);
	}
	
	/*
	@GetMapping("imagen-producto-example")
	public List<Imagen> ImagenesDeProductoMock()
	{	
		Producto p = productoService.getAll().get(0);
		return p.getImagenes();
	}*/
	
	@GetMapping("/imagen-mostrar/{id}")
	public void imagenMostrar(@PathVariable int id,
            HttpServletResponse response) throws IOException{
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		Imagen i = new Imagen();
		
		i.setId(id);
		
		InputStream is = new ByteArrayInputStream(imagenService.getById(i).getBytes());
		
		BufferedImage bi = null;
		
		bi = ImageIO.read(is);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ImageIO.write(bi, "jpg", baos);
		
		baos.flush();
		
		byte[]ByteimageInByte = baos.toByteArray();
		
		baos.close();
			
		IOUtils.copy(new ByteArrayInputStream(ByteimageInByte), response.getOutputStream());
	}
	
	@GetMapping("/imagen-mostrar-url/{id}")
	public void imagenMostrarUrl(@PathVariable int id,
            HttpServletResponse response) throws IOException{
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		Imagen i = new Imagen();
		
		i.setId(id);
		
		byte arr[] = imagenService.getById(i).getBytes();
		
		InputStream is = new ByteArrayInputStream(arr);
		
		BufferedImage bi = null;
		
		int ch;
		
		String urlString = "";
		
		while(((ch = is.read()) != -1))
		{
			urlString += (char)ch;
		}
		
		URL url = new URL(urlString);
		
		bi = ImageIO.read(url);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String format = "jpg";
		
		if(urlString.contains("png"))
			format = "png";
		
		System.out.println(urlString);
		
		ImageIO.write(bi, format, baos);
		
		baos.flush();
		
		byte[]ByteimageInByte = baos.toByteArray();
		
		baos.close();
			
		IOUtils.copy(new ByteArrayInputStream(ByteimageInByte), response.getOutputStream());
	}
	
	/*
	@GetMapping("/imagen-mostrar-url-example")
	public void imagenMostrarUrlExample(HttpServletResponse response) throws IOException{
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		byte arr[] = productoService.getAll().get(0).getImagenes().get(0).getBytes();
		
		InputStream is = new ByteArrayInputStream(arr);
		
		BufferedImage bi = null;
		
		int ch;
		
		String urlString = "";
		
		while(((ch = is.read()) != -1))
		{
			urlString += (char)ch;
		}
		
		URL url = new URL(urlString);
		
		bi = ImageIO.read(url);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		String format = "jpg";
		
		if(urlString.contains("png"))
			format = "png";
		
		ImageIO.write(bi, format, baos);
		
		baos.flush();
		
		byte[]ByteimageInByte = baos.toByteArray();
		
		baos.close();
			
		IOUtils.copy(new ByteArrayInputStream(ByteimageInByte), response.getOutputStream());
	}*/
}
