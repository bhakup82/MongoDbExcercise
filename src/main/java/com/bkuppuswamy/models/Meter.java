/**
 * 
 */
package com.bkuppuswamy.models;

import java.util.Date;

/**
 * @author bkuppuswamy
 *
 */
public class Meter {
	
	private String meterId;
	private String meterModel;
	private Date installDate;
	private String address;
	
	public Meter(String meterId, String meterModel, Date installDate,
			String address) {
		super();
		this.meterId = meterId;
		this.meterModel = meterModel;
		this.installDate = installDate;
		this.address = address;
	}
	/**
	 * @return the meterId
	 */
	public String getMeterId() {
		return meterId;
	}
	/**
	 * @param meterId the meterId to set
	 */
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	/**
	 * @return the meterModel
	 */
	public String getMeterModel() {
		return meterModel;
	}
	/**
	 * @param meterModel the meterModel to set
	 */
	public void setMeterModel(String meterModel) {
		this.meterModel = meterModel;
	}
	/**
	 * @return the installDate
	 */
	public Date getInstallDate() {
		return installDate;
	}
	/**
	 * @param installDate the installDate to set
	 */
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meter [meterId=" + meterId + ", meterModel=" + meterModel
				+ ", installDate=" + installDate + ", address=" + address + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((installDate == null) ? 0 : installDate.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result
				+ ((meterModel == null) ? 0 : meterModel.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meter other = (Meter) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (installDate == null) {
			if (other.installDate != null)
				return false;
		} else if (!installDate.equals(other.installDate))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (meterModel == null) {
			if (other.meterModel != null)
				return false;
		} else if (!meterModel.equals(other.meterModel))
			return false;
		return true;
	}
	


}
