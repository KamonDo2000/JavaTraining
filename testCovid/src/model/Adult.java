package model;

public class Adult extends Person {

	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Adult() {
	}

	@Override
	public String infoDetail() {
		return ", job= " + job;
	}

}
