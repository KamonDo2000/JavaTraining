package entities;

public class Product {

	private String product_id;
	private String product_name;
	private String list_price;

	public Product() {

	}

	public Product(String product_id, String product_name, String list_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.list_price = list_price;
	}

	/**
	 * @return the product_id
	 */
	public synchronized String getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public synchronized void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the product_name
	 */
	public synchronized String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public synchronized void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the list_price
	 */
	public synchronized String getList_price() {
		return list_price;
	}

	/**
	 * @param list_price the list_price to set
	 */
	public synchronized void setList_price(String list_price) {
		this.list_price = list_price;
	}

}
