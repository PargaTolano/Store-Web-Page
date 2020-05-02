package Controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Model.Imagen;
import Model.PDFFile;
import Model.Producto;
import Service.PDF_Service;
import Service.Producto_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class PDFController {
	
	@Autowired
	private PDF_Service pdfService;
	
	@Autowired
	private Producto_Service productoService;
	
	@PostMapping("pdf-save")
	public boolean save(@RequestBody ObjectNode objectNode)
	{
		ObjectMapper mapper = new ObjectMapper();
		PDFFile p  = mapper.convertValue(objectNode.get("pdf"), PDFFile.class);
		
		byte[] backToBytes = Base64.getDecoder().decode(objectNode.get("base64Str").asText());
		p.setContenido(backToBytes);
		return pdfService.save(p);
	}
	
	@PostMapping("pdf-update")
	public boolean update(@RequestBody PDFFile p)
	{
		return pdfService.update(p);
	}
	
	@PostMapping("pdf-delete")
	public boolean delete(@RequestBody PDFFile p)
	{
		return pdfService.delete(p);
	}
	
	@PostMapping("pdf-product")
	public ObjectNode byProduct(@RequestBody Producto p)
	{
		ObjectMapper mapper = new ObjectMapper();
		
		PDFFile temp = pdfService.byProduct(p);
		
		ObjectNode objectNode = new ObjectNode(null);
		
		JsonNode pdfNode = mapper.valueToTree(temp);
		
		String encoded = Base64.getEncoder().encodeToString(temp.getContenido());
		
		JsonNode encodedNode = mapper.valueToTree(encoded);
		
		objectNode.set("pdf", pdfNode);
		objectNode.set("encoded", encodedNode);
		
		return objectNode;
	}
	
	@PostMapping("pdf-product-blob")
	public String byProductArr(@RequestBody Producto p)
	{
		String encoded = Base64.getEncoder().encodeToString(pdfService.byProduct(p).getContenido());
		return encoded;
	}
}
