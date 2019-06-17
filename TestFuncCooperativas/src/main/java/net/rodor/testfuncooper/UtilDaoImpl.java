package net.rodor.testfuncooper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.rodor.testfuncooper.soldeno.SolicitudDenoRowMapper;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;

@Repository
public class UtilDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public VOSolDenomOnline getUltimaSolDenominacion() {
		String sql = "select id_expediente, exp_numero from EXPEDIENTE order by id_expediente desc";
		SolicitudDenoRowMapper rowmapper = new SolicitudDenoRowMapper();
		Object[] args=null;
		List<VOSolDenomOnline> listado =jdbcTemplate.query(sql, args, rowmapper);
		return listado.get(0);
	}
}
