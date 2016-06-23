package com.contactList.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the Email database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int emailId;

	private String emailAddress;
	
	private Classification classification;

	public Email() {
	}

	public int getEmailId() {
		return this.emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Classification getClassification() {
		return this.classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}


}