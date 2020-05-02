package DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.PDFFile;

@Repository
@SuppressWarnings("unchecked")
public class PDFDAO_Imp implements PDFDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(PDFFile pdf) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(pdf);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean delete(PDFFile pdf) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(pdf);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean update(PDFFile pdf) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(pdf);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
