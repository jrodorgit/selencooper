package net.rodor.testfuncooper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;

@Service
public class UtilServiceImpl {

	@Autowired
	private  UtilDaoImpl dao;

	public VOSolDenomOnline getUltimaSolDenominacion() {
		
		return dao.getUltimaSolDenominacion();
	}
}
