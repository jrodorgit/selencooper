package net.rodor.testfuncooper.denominaciones;

public class VODenominacion {

	private String numInfor;
	private String numIns;
	private String razonSocial;
	public String getNumInfor() {
		return numInfor;
	}
	public void setNumInfor(String numInfor) {
		this.numInfor = numInfor;
	}
	public String getNumIns() {
		return numIns;
	}
	public void setNumIns(String numIns) {
		this.numIns = numIns;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	@Override
	public String toString() {
		return "VODenominacion [numInfor=" + numInfor + ", numIns=" + numIns + ", razonSocial=" + razonSocial + "]";
	}
	
}
