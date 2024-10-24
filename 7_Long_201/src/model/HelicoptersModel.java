package model;

public class HelicoptersModel extends PlanModel {
	private float range;

	public HelicoptersModel() {
		super();
	}

	/**
	 * @return the range
	 */
	public float getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(float range) {
		this.range = range;
	}

	@Override
	protected String setFlyMethod() {
		return "rotated wing";
	}

}
