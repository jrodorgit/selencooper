package net.rodor.testfuncooper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.rodor.testfuncooper.soldenomonline.VOSolDenomOnline;

public class SolicitudDenoRowMapper implements RowMapper<VOSolDenomOnline> {

	@Override
	public VOSolDenomOnline mapRow(ResultSet rs, int rowNum) throws SQLException {
		VOSolDenomOnline obj = new VOSolDenomOnline();
		obj.setIdexpediente(rs.getString(1));
		return obj;
	}

}
