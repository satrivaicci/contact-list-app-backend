package com.contactList.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the Phone database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int phoneId;

	private String phoneNumber;

	private Classification classification;

	public Phone() {
	}

	public int getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}


}