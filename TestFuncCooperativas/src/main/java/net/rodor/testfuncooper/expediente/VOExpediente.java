package net.rodor.testfuncooper.expediente;

public class VOExpediente {

	private String numeroExpediente;
	private String idGrupoFirma;
	public String getNumeroExpediente() {
		return numeroExpediente;
	}
	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	public String getIdGrupoFirma() {
		return idGrupoFirma;
	}
	public void setIdGrupoFirma(String idGrupoFirma) {
		this.idGrupoFirma = idGrupoFirma;
	}
	public VOExpediente() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VOExpediente [numeroExpediente=" + numeroExpediente + ", idGrupoFirma=" + idGrupoFirma + "]";
	}
	
	
	
}
