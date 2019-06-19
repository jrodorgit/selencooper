package net.rodor.testfuncooper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rodor.testfuncooper.expediente.VOExpediente;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;

@Service
public class UtilServiceImpl {

	@Autowired
	private  UtilDaoImpl dao;

	public VOSolDenomOnline getExpeDeno(String denominacion) {
		
		return dao.getExpeDeno(denominacion);
	}
	
	public VOExpediente getGrupoFirmaExpediente(String numExpediente) {
		
		return dao.getGrupoFirmaExpediente(numExpediente);
	}
}
