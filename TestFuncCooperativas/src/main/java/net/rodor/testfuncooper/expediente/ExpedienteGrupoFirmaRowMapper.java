package net.rodor.testfuncooper.expediente;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;

public class ExpedienteGrupoFirmaRowMapper implements RowMapper<VOExpediente> {

	@Override
	public VOExpediente mapRow(ResultSet rs, int rowNum) throws SQLException {
		VOExpediente obj = new VOExpediente();
		obj.setNumeroExpediente(rs.getString(1));
		obj.setIdGrupoFirma(rs.getString(2));
		return obj;
	}

}
