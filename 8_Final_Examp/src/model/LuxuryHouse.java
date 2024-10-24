package model;

public class LuxuryHouse extends House {

	private String projectName;
	private String investor;
	private String view;

	public LuxuryHouse() {
		super();
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + this.projectName);
		System.out.print(" || " + this.investor);
		System.out.print(" || " + this.view);
	}

	/**
	 * @return the projectName
	 */
	public synchronized String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public synchronized void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the investor
	 */
	public synchronized String getInvestor() {
		return investor;
	}

	/**
	 * @param investor the investor to set
	 */
	public synchronized void setInvestor(String investor) {
		this.investor = investor;
	}

	/**
	 * @return the view
	 */
	public synchronized String getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public synchronized void setView(String view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return this.getType() + "," + this.getHouseID() + "," + this.getSquare() + "," + this.getDirection() + ","
				+ this.getStartDate() + "," + this.getCompletionDate() + "," + this.getRightCertificate() + ","
				+ this.getPrice() + "," + this.projectName + "," + this.investor + "," + this.view;
	}
}
