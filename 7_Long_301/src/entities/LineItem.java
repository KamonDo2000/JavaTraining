package entities;

public class LineItem {
	
	private String order_id;
	private String product_id;
	private String quantity;
	private String price;
	
	public LineItem() {
		super();
	}

	public LineItem(String order_id, String product_id, String quantity, String price) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * @return the order_id
	 */
	public synchronized String getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id the order_id to set
	 */
	public synchronized void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	 * @return the quantity
	 */
	public synchronized String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public synchronized void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public synchronized String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public synchronized void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
