/**
 * 
 */
package com.product.list.entities;

/**
 * @author ssuman
 *
 */
public class Product 
{
	private String code;
	private String name;
	private float price;

	public Product() 
	{

	}

	/**
	 * @param code
	 * @param name
	 * @param price
	 */
	public Product(String code, String name, float price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
}
