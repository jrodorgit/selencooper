package net.rodor.testfuncooper.asientos;

public class VOAsiento {

	public String numeroAsiento;
	public String numeroInscripcionCooper;
	public VOAsiento() {
		super();
		
	}
	
	public VOAsiento(String numeroAsiento, String numeroInscripcionCooper) {
		super();
		this.numeroAsiento = numeroAsiento;
		this.numeroInscripcionCooper = numeroInscripcionCooper;
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
				+ "]";
	}
	
	
}
