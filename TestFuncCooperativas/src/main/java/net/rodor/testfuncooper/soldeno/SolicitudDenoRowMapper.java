package net.rodor.testfuncooper.soldeno;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SolicitudDenoRowMapper implements RowMapper<VOSolDenomOnline> {

	@Override
	public VOSolDenomOnline mapRow(ResultSet rs, int rowNum) throws SQLException {
		VOSolDenomOnline obj = new VOSolDenomOnline();
		obj.setIdexpediente(rs.getString(1));
		obj.setNumexpediente(rs.getString(2));
		return obj;
	}

}
