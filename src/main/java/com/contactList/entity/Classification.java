package com.contactList.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the Classification database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Classification.findAll", query="SELECT c FROM Classification c")
public class Classification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int classificationId;

	private String classification;

	@OneToMany
	@JoinColumn(name="addressId")
	private List<Address> addresses;

	@OneToMany()
	@JoinColumn(name="emailId")
	private List<Email> emails;

	@OneToMany()
	@JoinColumn(name="phoneId")
	private List<Phone> phones;

	public Classification() {
	}

	public int getClassificationId() {
		return this.classificationId;
	}

	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}