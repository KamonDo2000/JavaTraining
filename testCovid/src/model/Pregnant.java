package model;

public class Pregnant extends Person {

	private String gestationalAge;
	private String pretermBirth;

	public String getGestationalAge() {
		return gestationalAge;
	}

	public void setGestationalAge(String gestationalAge) {
		this.gestationalAge = gestationalAge;
	}

	public String getPretermBirth() {
		return pretermBirth;
	}

	public void setPretermBirth(String pretermBirth) {
		this.pretermBirth = pretermBirth;
	}

	public Pregnant(String gestationalAge, String pretermBirth) {
		super();
		this.gestationalAge = gestationalAge;
		this.pretermBirth = pretermBirth;
	}

	public Pregnant() {
		super();
	}

	@Override
	public String infoDetail() {
		return "gestationalAge=" + gestationalAge + ", pretermBirth=" + pretermBirth;
	}

}
