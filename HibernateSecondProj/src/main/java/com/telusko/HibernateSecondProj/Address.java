/**
 * 
 */
package com.telusko.HibernateSecondProj;

import javax.persistence.Embeddable;

/**
 * @author Shivy
 *
 */

@Embeddable
public class Address {
	private int qtrNo;
	private String street;
	private String city;
	private String state;
	private String country;
	private int postCode;
	
	@Override
	public String toString() {
		return "Address [qtrNo=" + qtrNo + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postCode=" + postCode + "]";
	}

	public int getQtrNo() {
		return qtrNo;
	}

	public void setQtrNo(int qtrNo) {
		this.qtrNo = qtrNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

}
