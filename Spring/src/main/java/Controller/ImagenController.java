package Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
	
	@PostMapping("imagen-save")
	public boolean save(@RequestBody ObjectNode objectNode)
	{
		ObjectMapper mapper = new ObjectMapper();
		Imagen i  = mapper.convertValue(objectNode.get("imagen"),Imagen.class);
		
		String str = objectNode.get("base64Str").asText();
		byte[] backToBytes = Base64.getDecoder().decode(str);
		i.setBytes(backToBytes);
	 	return imagenService.save(i);
	}
	
	@PostMapping("imagen-update")
	public boolean update(@RequestBody Imagen i)
	{
		return imagenService.update(i);
	}
	
	@PostMapping("imagen-delete")
	public boolean delete(@RequestBody Imagen i)
	{
		return imagenService.delete(i);
	}
	
	
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
	
	
}
