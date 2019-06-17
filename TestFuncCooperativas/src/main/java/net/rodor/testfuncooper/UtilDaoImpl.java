package net.rodor.testfuncooper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.rodor.testfuncooper.expediente.ExpedienteGrupoFirmaRowMapper;
import net.rodor.testfuncooper.expediente.VOExpediente;
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
	
	
	public VOExpediente getGrupoFirmaExpediente(String numExpediente) {
		String sql = "select id_expediente, id_grupo_firma from grupo_firma where descripcion like '%"+numExpediente+"%' order by id_grupo_firma desc";
		ExpedienteGrupoFirmaRowMapper rowmapper = new ExpedienteGrupoFirmaRowMapper();
		Object[] args=null;
		List<VOExpediente> listado =jdbcTemplate.query(sql, args, rowmapper);
		return listado.get(0);
	}
}
