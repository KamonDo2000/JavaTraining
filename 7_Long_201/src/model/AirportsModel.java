package model;

import java.util.List;

public class AirportsModel {
	private String id;
	private String name;
	private float runwaySize;
	private int maxFixedParking;
	private int maxRotatedParking;
	private List<String> listFixedID;
	private List<String> listHelicopterID;

	public AirportsModel() {
		super();
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the runwaySize
	 */
	public float getRunwaySize() {
		return runwaySize;
	}

	/**
	 * @param runwaySize the runwaySize to set
	 */
	public void setRunwaySize(float runwaySize) {
		this.runwaySize = runwaySize;
	}

	/**
	 * @return the maxFixedParking
	 */
	public int getMaxFixedParking() {
		return maxFixedParking;
	}

	/**
	 * @param maxFixedParking the maxFixedParking to set
	 */
	public void setMaxFixedParking(int maxFixedParking) {
		this.maxFixedParking = maxFixedParking;
	}

	/**
	 * @return the maxRotatedParking
	 */
	public int getMaxRotatedParking() {
		return maxRotatedParking;
	}

	/**
	 * @param maxRotatedParking the maxRotatedParking to set
	 */
	public void setMaxRotatedParking(int maxRotatedParking) {
		this.maxRotatedParking = maxRotatedParking;
	}

	/**
	 * @return the listFixedID
	 */
	public List<String> getListFixedID() {
		return listFixedID;
	}

	/**
	 * @param listFixedID the listFixedID to set
	 */
	public void setListFixedID(List<String> listFixedID) {
		this.listFixedID = listFixedID;
	}

	/**
	 * @return the listHelicopterID
	 */
	public List<String> getListHelicopterID() {
		return listHelicopterID;
	}

	/**
	 * @param listHelicopterID the listHelicopterID to set
	 */
	public void setListHelicopterID(List<String> listHelicopterID) {
		this.listHelicopterID = listHelicopterID;
	}

}
