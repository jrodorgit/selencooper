package net.rodor.testfuncooper.soldeno;

public class VOSolDenomOnline {

	private String denominacionUno;
	private String denominacionDos;
	private String numLocalizador;
	private String descLocalizador;
	private String idexpediente;
	private String numexpediente;
	
	public String getDenominacionUno() {
		return denominacionUno;
	}
	public void setDenominacionUno(String denominacionUno) {
		this.denominacionUno = denominacionUno;
	}
	public String getDenominacionDos() {
		return denominacionDos;
	}
	public void setDenominacionDos(String denominacionDos) {
		this.denominacionDos = denominacionDos;
	}
	public String getNumLocalizador() {
		return numLocalizador;
	}
	public void setNumLocalizador(String numLocalizador) {
		this.numLocalizador = numLocalizador;
	}
	public String getDescLocalizador() {
		return descLocalizador;
	}
	public void setDescLocalizador(String descLocalizador) {
		this.descLocalizador = descLocalizador;
	}
	
	public String getIdexpediente() {
		return idexpediente;
	}
	public void setIdexpediente(String idexpediente) {
		this.idexpediente = idexpediente;
	}
	
	public String getNumexpediente() {
		return numexpediente;
	}
	public void setNumexpediente(String numexpediente) {
		this.numexpediente = numexpediente;
	}
	@Override
	public String toString() {
		return "VOSolDenomOnline [denominacionUno=" + denominacionUno + ", denominacionDos=" + denominacionDos
				+ ", numLocalizador=" + numLocalizador + ", descLocalizador=" + descLocalizador + ", idexpediente="
				+ idexpediente + ", numexpediente=" + numexpediente + "]";
	}
	
	
	
}
