package Controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Model.Imagen;
import Model.PDFFile;

import Service.PDF_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class PDFController {
	
	@Autowired
	private PDF_Service pdfService;
	
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
}
