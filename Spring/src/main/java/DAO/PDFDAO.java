package DAO;

import Model.PDFFile;
import Model.Producto;
public interface PDFDAO {
	public boolean save  (PDFFile pdf);
	public boolean delete(PDFFile pdf);
	public boolean update(PDFFile pdf);
	
	public PDFFile byProduct(Producto p);
}
