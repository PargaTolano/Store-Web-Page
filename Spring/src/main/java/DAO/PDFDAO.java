package DAO;

import Model.PDFFile;
public interface PDFDAO {
	public boolean save  (PDFFile pdf);
	public boolean delete(PDFFile pdf);
	public boolean update(PDFFile pdf);
}
