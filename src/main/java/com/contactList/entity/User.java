package com.contactList.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "userId")
	private int userId;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
	private String name;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "pwd")
	private String pwd;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
	private String username;


	@OneToMany
	@JoinColumn(name="contactId")
	private List<Contact> contacts;

	public User() {
	}


	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);

		return contact;
	}
		
}