package Service;

import Model.PDFFile;

public interface PDF_Service {
	public boolean save  (PDFFile pdf);
	public boolean delete(PDFFile pdf);
	public boolean update(PDFFile pdf);
}
