package net.rodor.testfuncooper;

import java.util.Map;

public class Env {
	
	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

	private Map<String, String> props;

	@Override
	public String toString() {
		return "Env [props=" + props + "]";
	}
	
	

}
