package net.rodor.testfuncooper.legajos;

public class VODocumento {

	private String ruta;
	private String nombreFichero;

	public VODocumento() {
		super();
		
	}

	public VODocumento(String ruta,String nombreFichero) {
		super();
		this.ruta = ruta;
		this.setNombreFichero(nombreFichero);
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	

	@Override
	public String toString() {
		return "VODocumento [ruta=" + ruta + ", nombreFichero=" + nombreFichero + "]";
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	
	
}
