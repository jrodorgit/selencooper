package net.rodor.testfuncooper.legajos;

public class VOLegajo {

	private String numeroInscripcion;
	private String descripcion;
	private String asientosRel;

	public String getAsientosRel() {
		return asientosRel;
	}

	public void setAsientosRel(String asientosRel) {
		this.asientosRel = asientosRel;
	}

	public String getNumeroInscripcion() {
		return numeroInscripcion;
	}

	public void setNumeroInscripcion(String numeroInscripcion) {
		this.numeroInscripcion = numeroInscripcion;
	}

	@Override
	public String toString() {
		return "VOLegajo [numeroInscripcion=" + numeroInscripcion + ", descripcion=" + descripcion + ", asientosRel="
				+ asientosRel + "]";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
