package com.bkuppuswamy.service;



import java.util.Collection;
import java.util.List;

import com.bkuppuswamy.dao.MeterDao;
import com.bkuppuswamy.models.Meter;
import com.bkuppuswamy.models.MeterReading;
import com.mongodb.DBObject;

public class MeterService {
	
	private MeterDao meterDao;
	
	/**
	 * @return the meterDao
	 */
	public MeterDao getMeterDao() {
		if(null == this.meterDao){
			this.meterDao = new MeterDao(); 
		}
		return this.meterDao;
	}

	public double getHighestMeterReading(Collection<Double> allReadings) {

		double largest = Double.MIN_VALUE;

		for (Double value : allReadings) {
			if (value > largest) {
				largest = value;

			}

		}
       return largest;
	}
	
	public void updateMeterReading(String meterId, double updateKwh) {
		
		getMeterDao().updateMeterReading(meterId,updateKwh);
		
	}
	
	public List<DBObject> fetchMeterReadingValuesForMeter(String meterId){
		
		return getMeterDao().findMeterReadings(meterId);
	}
	
	public void addMeters(List<Meter> meters){
		
		getMeterDao().addMeters(meters);
	}

	public void addMeterReadings(List<MeterReading> meterReadings) {
		
		getMeterDao().addMeterReadings(meterReadings);
		
	}
		


}
