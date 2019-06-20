package net.rodor.testfuncooper.administracion;

import java.util.Arrays;

public class VOUsuario {

	private String nombre;
	private String apel1;
	private String apel2;
	private String nif;
	private String[] roles;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApel1() {
		return apel1;
	}
	public void setApel1(String apel1) {
		this.apel1 = apel1;
	}
	public String getApel2() {
		return apel2;
	}
	public void setApel2(String apel2) {
		this.apel2 = apel2;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "VOUsuario [nombre=" + nombre + ", apel1=" + apel1 + ", apel2=" + apel2 + ", nif=" + nif + ", roles="
				+ Arrays.toString(roles) + "]";
	}
	
	
}
