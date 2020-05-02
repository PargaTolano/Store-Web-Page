package DAO;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.PDFFile;
import Model.Producto;

@Repository
@SuppressWarnings("unchecked")
public class PDFDAO_Imp implements PDFDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(PDFFile pdf) {
		boolean status=false;
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(pdf);
			ProcedureCall procedureCall=currentSession.createStoredProcedureCall("PDF_Producto_Relate");
			procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(pdf.getProducto().getId());
			procedureCall.registerParameter(2, int.class, ParameterMode.IN).bindValue(pdf.getId());
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

	@Override
	public PDFFile byProduct(Producto p) {
		Session currentSession = sessionFactory.getCurrentSession();
		ProcedureCall procedureCall=currentSession.createStoredProcedureCall("PDF_byProducto", PDFFile.class);
		procedureCall.registerParameter(1, int.class, ParameterMode.IN).bindValue(p.getId());
		return (PDFFile) procedureCall.getResultList().get(0);
	}

}
