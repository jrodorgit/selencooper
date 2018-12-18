package net.rodor.testfuncooper.legajos;

public class VOLegajo {

	private String numeroRegistro;
	private String numeroInscripcion;
	private String expediente;
	private String fechaCreacion;
	
	public VOLegajo() {
		super();
		
	}

	public VOLegajo (String numeroInscripcion, String numeroRegistro,String expediente,String fechaCreacion) {
		super();
		this.numeroRegistro = numeroRegistro;
		this.numeroInscripcion = numeroInscripcion;
		this.expediente = expediente;
		this.fechaCreacion = fechaCreacion;
	}

	

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
