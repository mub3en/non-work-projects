package packages;

public class Customer {
	private String customerName;
	private String streetAddress;
	private String contact;
	private int customerId;
	private String cityStateZip;
	private String country;
	
	public Customer(String customerName, String streetAddress, String contact, int customerId, String cityStateZip, String country) {
		this.customerName = customerName;
		this.streetAddress = streetAddress;
		this.contact = contact;
		this.customerId = customerId;
		this.cityStateZip = cityStateZip;
		this.country = country;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCityStateZip() {
		return cityStateZip;
	}
	public void setCityStateZip(String cityStateZip) {
		this.cityStateZip = cityStateZip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
