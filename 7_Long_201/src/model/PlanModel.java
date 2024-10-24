package model;

public abstract class PlanModel {
	private String id;
	private String model;

	private float speed;
	private float emptyWeight;
	private float maxWeight;

	private String flyMethod;

	protected PlanModel() {
		this.flyMethod = setFlyMethod();
	}

	protected PlanModel(String id, String model, float speed, float emptyWeight, float maxWeight) {
		super();
		this.id = id;
		this.model = model;
		this.speed = speed;
		this.emptyWeight = emptyWeight;
		this.maxWeight = maxWeight;
		this.flyMethod = setFlyMethod();
	}

	protected abstract String setFlyMethod();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the flyMethod
	 */
	public String getFlyMethod() {
		return flyMethod;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the emptyWeight
	 */
	public float getEmptyWeight() {
		return emptyWeight;
	}

	/**
	 * @param emptyWeight the emptyWeight to set
	 */
	public void setEmptyWeight(float emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	/**
	 * @return the maxWeight
	 */
	public float getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

}
