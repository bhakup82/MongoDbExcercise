/**
 * 
 */
package com.bkuppuswamy.models;

/**
 * @author bkuppuswamy
 *
 */
public class Address {

	 private String address;
	 private String postcode;
	 private String city;
	 private String state;
	 private String country;
	 
	 

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}




	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}




	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}




	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}




	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}




	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}




	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}




	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	 /* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
	@Override
	public String toString() {
			return "Address [address=" + address + ", postcode=" + postcode
					+ ", city=" + city + ", country=" + country + "]";
	}
	
	

}
