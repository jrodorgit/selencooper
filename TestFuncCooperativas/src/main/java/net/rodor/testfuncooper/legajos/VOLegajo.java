package net.rodor.testfuncooper.legajos;

public class VOLegajo {

	private String numeroRegistro;
	private String numeroInscripcion;
	private String expediente;
	private String fechaCreacion;
	private String tipoExpediente;
	
	public VOLegajo() {
		super();
		
	}

	public VOLegajo (String numeroInscripcion, String numeroRegistro,String expediente,String fechaCreacion, String tipoExpediente) {
		super();
		this.numeroRegistro = numeroRegistro;
		this.numeroInscripcion = numeroInscripcion;
		this.expediente = expediente;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
	}

	

	public String getTipoExpediente() {
		return tipoExpediente;
	}

	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	@Override
	public String toString() {
		return "VOLegajo [numeroRegistro=" + numeroRegistro + ", numeroInscripcion=" + numeroInscripcion
				+ ", expediente=" + expediente + ", fechaCreacion=" + fechaCreacion + ", tipoExpediente="
				+ tipoExpediente + "]";
	}
	
	
	
}
