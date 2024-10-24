package model;

public class FixedwingsModel extends PlanModel {

	private float minRunwaySize;
	private String type;

	public FixedwingsModel() {
		super();
	}

	/**
	 * @return the minRunwaySize
	 */
	public synchronized float getMinRunwaySize() {
		return minRunwaySize;
	}

	/**
	 * @param minRunwaySize the minRunwaySize to set
	 */
	public synchronized void setMinRunwaySize(float minRunwaySize) {
		this.minRunwaySize = minRunwaySize;
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

	@Override
	protected String setFlyMethod() {
		return "fixed wing";
	}

}
