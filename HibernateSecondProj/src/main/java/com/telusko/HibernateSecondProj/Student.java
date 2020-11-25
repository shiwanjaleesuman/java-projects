package com.telusko.HibernateSecondProj;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	private int roll;
//	private String name;
//	private String address;
	private Name name;
	private Address address;
	
	public Student() {
		super();
	}
	
	/**
	 * @param roll
	 * @param name
	 * @param address
	 */
	public Student(int roll, Name name, Address address) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + "]";
	}
	
	/**
	 * @return the roll
	 */
	public int getRoll() {
		return roll;
	}
	/**
	 * @param roll the roll to set
	 */
	public void setRoll(int roll) {
		this.roll = roll;
	}
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
