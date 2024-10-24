package model;

public class LowCostHouse extends House {

	private String transferYear;

	public LowCostHouse() {
		super();
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + this.transferYear);
	}

	/**
	 * @return the transferYear
	 */
	public synchronized String getTransferYear() {
		return transferYear;
	}

	/**
	 * @param transferYear the transferYear to set
	 */
	public synchronized void setTransferYear(String transferYear) {
		this.transferYear = transferYear;
	}

	@Override
	public String toString() {
		return this.getType() + "," + this.getHouseID() + "," + this.getSquare() + "," + this.getDirection() + ","
				+ this.getStartDate() + "," + this.getCompletionDate() + "," + this.getRightCertificate() + ","
				+ this.getPrice() + "," + this.transferYear;
	}

}
