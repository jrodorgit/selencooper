package net.rodor.testfuncooper.soldenomonline;

public class VOSolDenomOnline {

	private String provincia;
	private String localidad;
	private String tipoVia;
	private String nombreVia;
	private String numeroVia;
	private String codPostal;
	private String telefonoMovil;
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getNumeroVia() {
		return numeroVia;
	}
	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	@Override
	public String toString() {
		return "VOSolDenomOnline [provincia=" + provincia + ", localidad=" + localidad + ", tipoVia=" + tipoVia
				+ ", nombreVia=" + nombreVia + ", numeroVia=" + numeroVia + ", codPostal=" + codPostal
				+ ", telefonoMovil=" + telefonoMovil + "]";
	}
	
	
}
