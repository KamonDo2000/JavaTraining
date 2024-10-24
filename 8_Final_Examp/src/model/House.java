package model;

public abstract class House {
	private String type;
	private String houseID;
	private String square;
	private String direction;
	private String startDate;
	private String completionDate;
	private String rightCertificate;
	private float price;
	private float actualPrice;

	protected House() {
		super();
	}

	/**
	 * calculate actual Price
	 */
	public void calculatePrice(float income) {
		this.actualPrice = this.price - (this.price * income);
	}

	/**
	 * abstract method show detail
	 */
	protected abstract void showMe();

	/**
	 * show info house
	 */
	public void showInfo() {
		System.out.print(this.type);
		System.out.print(" -- " + this.houseID);
		System.out.print(" || " + this.square);
		System.out.print(" || " + this.direction);
		System.out.print(" || " + this.startDate);
		System.out.print(" || " + this.completionDate);
		System.out.print(" || " + this.rightCertificate);
		System.out.print(" || " + this.price);
		showMe();
		System.out.println("\n\n================================================");
	}

	/**
	 * @return the type
	 */
	public synchronized String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public synchronized void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the houseID
	 */
	public synchronized String getHouseID() {
		return houseID;
	}

	/**
	 * @param houseID the houseID to set
	 */
	public synchronized void setHouseID(String houseID) {
		this.houseID = houseID;
	}

	/**
	 * @return the square
	 */
	public synchronized String getSquare() {
		return square;
	}

	/**
	 * @param square the square to set
	 */
	public synchronized void setSquare(String square) {
		this.square = square;
	}

	/**
	 * @return the direction
	 */
	public synchronized String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public synchronized void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the startDate
	 */
	public synchronized String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public synchronized void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the completionDate
	 */
	public synchronized String getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate the completionDate to set
	 */
	public synchronized void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @return the rightCertificate
	 */
	public synchronized String getRightCertificate() {
		return rightCertificate;
	}

	/**
	 * @param rightCertificate the rightCertificate to set
	 */
	public synchronized void setRightCertificate(String rightCertificate) {
		this.rightCertificate = rightCertificate;
	}

	/**
	 * @return the price
	 */
	public synchronized float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public synchronized void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the actualPrice
	 */
	public synchronized float getActualPrice() {
		return actualPrice;
	}

	/**
	 * @param actualPrice the actualPrice to set
	 */
	public synchronized void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}

}
