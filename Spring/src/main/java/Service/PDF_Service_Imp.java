package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.PDFDAO;
import Model.PDFFile;

@Service
@Transactional
public class PDF_Service_Imp implements PDF_Service {

	@Autowired
	private PDFDAO pdfdao;
	
	@Override
	public boolean save(PDFFile pdf) {
		return pdfdao.save(pdf);
	}

	@Override
	public boolean delete(PDFFile pdf) {
		return pdfdao.delete(pdf);
	}

	@Override
	public boolean update(PDFFile pdf) {
		return pdfdao.update(pdf);
	}

}
