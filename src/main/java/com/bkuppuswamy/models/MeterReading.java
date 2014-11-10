/**
 * 
 */
package com.bkuppuswamy.models;

import java.util.Date;

/**
 * @author bkuppuswamy
 *
 */
public class MeterReading {
    
	public MeterReading(Meter meter, Date readingTime, double kwh) {
		super();
		this.meter = meter;
		this.readingTime = readingTime;
		this.kwh = kwh;
	}

	private Meter meter;
	
	private Date readingTime;
    
    private double kwh;
    
    /**
	 * @return the meter
	 */
	public Meter getMeter() {
		return meter;
	}

	/**
	 * @param meter the meter to set
	 */
	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	/**
	 * @return the readingTime
	 */
	public Date getReadingTime() {
		return readingTime;
	}

	/**
	 * @param readingTime the readingTime to set
	 */
	public void setReadingTime(Date readingTime) {
		this.readingTime = readingTime;
	}

	/**
	 * @return the kwh
	 */
	public double getKwh() {
		return kwh;
	}

	/**
	 * @param kwh the kwh to set
	 */
	public void setKwh(double kwh) {
		this.kwh = kwh;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kwh);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((meter == null) ? 0 : meter.hashCode());
		result = prime * result
				+ ((readingTime == null) ? 0 : readingTime.hashCode());
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
		MeterReading other = (MeterReading) obj;
		if (Double.doubleToLongBits(kwh) != Double.doubleToLongBits(other.kwh))
			return false;
		if (meter == null) {
			if (other.meter != null)
				return false;
		} else if (!meter.equals(other.meter))
			return false;
		if (readingTime == null) {
			if (other.readingTime != null)
				return false;
		} else if (!readingTime.equals(other.readingTime))
			return false;
		return true;
	}
    
}
