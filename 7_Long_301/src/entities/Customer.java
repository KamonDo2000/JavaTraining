package entities;

public class Customer {

	private String customer_id;
	private String customer_name;

	public Customer() {

	}

	public Customer(String customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}

	/**
	 * @return the customer_id
	 */
	public synchronized String getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public synchronized void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the customer_name
	 */
	public synchronized String getCustomer_name() {
		return customer_name;
	}

	/**
	 * @param customer_name the customer_name to set
	 */
	public synchronized void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

}
