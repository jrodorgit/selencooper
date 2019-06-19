package net.rodor.testfuncooper.cooperativas;

public class VOCooperativa {

	private String isn;
	private String numInfor;
	private String numIns;
	private String razonSocial;
	
	public String getIsn() {
		return isn;
	}
	public void setIsn(String isn) {
		this.isn = isn;
	}
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
		return "VOCooperativa [isn=" + isn + ", numInfor=" + numInfor + ", numIns=" + numIns + ", razonSocial="
				+ razonSocial + "]";
	}
	
	
	
}
