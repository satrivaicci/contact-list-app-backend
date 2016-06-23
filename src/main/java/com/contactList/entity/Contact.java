package com.contactList.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the Contact database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;

	private String company;

	private String jobTitle;

	private String name;

	private String photo;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String birthday;
	

	@Column(name="User_userId")
	private Integer useruserId;

	@OneToMany()
	@JoinColumn(name="addressId")
	private List<Address> addresses;
	
	@OneToMany()
	@JoinColumn(name = "emailId")
	private List<Email> emails;

	@OneToMany()
	@JoinColumn(name = "phoneId")
	private List<Phone> phones;

	public Contact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);

		return address;
	}
	
	public List<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);

		return email;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);

		return phone;
	}
	
	public Integer getUseruserId() {
		return useruserId;
	}

	public void setUseruserId(Integer useruserId) {
		this.useruserId = useruserId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}