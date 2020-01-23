package model;

public class PrivateAddress extends Address {

	private String recipient;
	private String street;
	private String city;
	private String cap;
	private String province;
	
	public PrivateAddress() {}
	
	public PrivateAddress(String recipient, String street, String city, String cap, String province) {
		super();
		this.recipient = recipient;
		this.street = street;
		this.city = city;
		this.cap = cap;
		this.province = province;
	}



	public String getRecipient() {
		return recipient;
	}



	public void setRecipient(String recipient) {
		this.recipient = recipient;
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



	public String getCap() {
		return cap;
	}



	public void setCap(String cap) {
		this.cap = cap;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}

	
	@Override
	public String toString() {
		return this.recipient + ",\n" + this.street + ",\n" + this.city +", " + this.cap + " (" + this.province + ")";
	}
}
