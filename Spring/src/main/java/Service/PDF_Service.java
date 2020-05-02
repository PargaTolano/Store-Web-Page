package Service;

import Model.PDFFile;
import Model.Producto;

public interface PDF_Service {
	public boolean save  (PDFFile pdf);
	public boolean delete(PDFFile pdf);
	public boolean update(PDFFile pdf);
	
	public PDFFile byProduct(Producto p);
}
