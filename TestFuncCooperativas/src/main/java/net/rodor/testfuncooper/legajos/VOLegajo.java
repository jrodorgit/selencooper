package net.rodor.testfuncooper.legajos;

public class VOLegajo {

	private String numeroRegistro;
	private String numeroInscripcion;
	private String expediente;
	
	public VOLegajo() {
		super();
		
	}

	public VOLegajo (String numeroInscripcion, String numeroRegistro,String expediente) {
		super();
		this.numeroRegistro = numeroRegistro;
		this.numeroInscripcion = numeroInscripcion;
		this.expediente = expediente;
	}

	

	@Override
	public String toString() {
		return "VOLegajo [numeroRegistro=" + numeroRegistro + ", numeroInscripcion=" + numeroInscripcion
				+ ", expediente=" + expediente + "]";
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getNumeroInscripcion() {
		return numeroInscripcion;
	}

	public void setNumeroInscripcion(String numeroInscripcion) {
		this.numeroInscripcion = numeroInscripcion;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	
	
	
}
