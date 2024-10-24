package model;

public class Apartment extends House {

	private String floor;
	private String view;

	public Apartment() {
		super();
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + this.floor);
		System.out.print(" || " + this.view);
	}

	/**
	 * @return the floor
	 */
	public synchronized String getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public synchronized void setFloor(String floor) {
		this.floor = floor;
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
				+ this.getPrice() + "," + this.floor + "," + this.view;
	}

}
