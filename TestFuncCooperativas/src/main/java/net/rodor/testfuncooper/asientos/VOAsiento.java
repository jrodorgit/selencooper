package net.rodor.testfuncooper.asientos;

public class VOAsiento {

	public String numeroAsiento;
	public String numeroInscripcionCooper;
	public String tomo;
	public String folio;
	public String asiento;
	public String notaMarginal;
	public String fecha;
	public String procedimiento;
	
	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNotaMarginal() {
		return notaMarginal;
	}

	public void setNotaMarginal(String notaMarginal) {
		this.notaMarginal = notaMarginal;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getTomo() {
		return tomo;
	}

	public void setTomo(String tomo) {
		this.tomo = tomo;
	}

	public VOAsiento() {
		super();
		
	}
	
	public VOAsiento(String numeroAsiento, String numeroInscripcionCooper) {
		super();
		this.numeroAsiento = numeroAsiento;
		this.numeroInscripcionCooper = numeroInscripcionCooper;
		
	}
	
	public VOAsiento(String numeroAsiento, String numeroInscripcionCooper, String tomo, 
			String folio, String asiento, String notaMarginal, String fecha,
			String procedimiento) {
		super();
		this.numeroAsiento = numeroAsiento;
		this.numeroInscripcionCooper = numeroInscripcionCooper;
		this.tomo = tomo;
		this.folio = folio;
		this.asiento = asiento;
		this.notaMarginal = notaMarginal;
		this.fecha = fecha;
		this.procedimiento = procedimiento;
	}

	public String getNumeroAsiento() {
		return numeroAsiento;
	}
	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	public String getNumeroInscripcionCooper() {
		return numeroInscripcionCooper;
	}
	public void setNumeroInscripcionCooper(String numeroInscripcionCooper) {
		this.numeroInscripcionCooper = numeroInscripcionCooper;
	}

	@Override
	public String toString() {
		return "VOAsiento [numeroAsiento=" + numeroAsiento + ", numeroInscripcionCooper=" + numeroInscripcionCooper
				+ ", tomo=" + tomo + ", folio=" + folio + ", asiento=" + asiento + ", notaMarginal=" + notaMarginal
				+ ", fecha=" + fecha + ", procedimiento=" + procedimiento + "]";
	}
	
	
}
