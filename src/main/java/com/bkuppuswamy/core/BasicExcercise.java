/**
 * 
 */
package com.bkuppuswamy.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bkuppuswamy.models.Meter;
import com.bkuppuswamy.models.MeterReading;
import com.bkuppuswamy.service.MeterService;
import com.mongodb.DBObject;

/**
 * @author bkuppuswamy
 *
 */
public class BasicExcercise {
	
	 public static void main(String[] args) {
		 
		 MeterService service = new MeterService();
		 
		//1.	Insert 10 Meter objects into the meters collection in Mongo.
		 
		 List<Meter> meters = new ArrayList<Meter>();
		 
		 Meter meter1 = new Meter("meterId1", "meterModel1", new Date(),"address11");
		 Meter meter2 = new Meter("meterId2", "meterModel2", new Date(),"address22");
		 Meter meter3 = new Meter("meterId3", "meterModel3", new Date(),"address33");
		 meters.add(meter1);
   		 meters.add(meter2);
		 meters.add(meter3);
		 meters.add(new Meter("meterId4", "meterModel4", new Date(),"address44"));
		 meters.add(new Meter("meterId5", "meterModel5", new Date(),"address55"));
		 meters.add(new Meter("meterId6", "meterModel6", new Date(),"address66"));
		 meters.add(new Meter("meterId7", "meterModel7", new Date(),"address77"));
		 meters.add(new Meter("meterId8", "meterModel8", new Date(),"address88"));
		 meters.add(new Meter("meterId9", "meterModel9", new Date(),"address99"));
		 meters.add(new Meter("meterId10", "meterModel10", new Date(),"address1010"));
		 
		 
		 service.addMeters(meters);
		 
		 //2.  For each meter insert 24 Meter Reading objects into the meter reading collection in Mongo.  Each meter reading represents a reading for 1 hour of the day for a given meter.  Actual data values can be whatever you want.
		 
		 List<MeterReading> meterReadings = new ArrayList<MeterReading>();
		 meterReadings.addAll(createMeterReadingsForMeter(meter1));
		 meterReadings.addAll(createMeterReadingsForMeter(meter2));
		 meterReadings.addAll(createMeterReadingsForMeter(meter3));
		 
		 service.addMeterReadings(meterReadings);
		
		 //2.	Using Mongo calculate and print out the average kwh for one specific meter.
		 
		 List<DBObject> dbobjects = service.fetchMeterReadingValuesForMeter("meterId1");
		 
		 Map<Double,DBObject> readingMap = new HashMap<Double,DBObject>();
		 
		 for(DBObject dbobj: dbobjects){
			 readingMap.put((Double) dbobj.get("kwh"), dbobj);
		 }
         
		 Set<Double> allValues = readingMap.keySet();
		 
		 Double sumOfAllValues = sumOfAllValues(allValues);
		 System.out.println("the average kwh for one specific for meterID1");
		 System.out.println(sumOfAllValues/24);
		 
		 //3.	Find and print out the address of the meter which has a meter reading with the highest kwh among all meter readings.
		double highestKey =  service.getHighestMeterReading(allValues);
		DBObject highestValue = readingMap.get(highestKey);
		//MeterId can be extracted out meter json
		System.out.println(highestValue.get("meter"));
		
		 //4.	Modify the kwh of a reading to a different value.
    	service.updateMeterReading("meter2", 7.6d);

		 
		 
	 }

	private static Double sumOfAllValues(Set<Double> allValues) {
		double sum = 0.0;
		for(Double value : allValues){
			sum = sum + value;
		}
		
		return sum;
	}

	private static List<MeterReading> createMeterReadingsForMeter(Meter meter1) {
		List<MeterReading> meterReadings = new ArrayList<MeterReading>();
		 meterReadings.add(new MeterReading(meter1,new Date(),1.1d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.2d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.3d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.4d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.5d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.7d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.8d));
		 meterReadings.add(new MeterReading(meter1,new Date(),1.9d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.0d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.1d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.2d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.3d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.4d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.5d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.6d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.7d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.8d));
		 meterReadings.add(new MeterReading(meter1,new Date(),2.9d));
		 meterReadings.add(new MeterReading(meter1,new Date(),3.0d));
		 meterReadings.add(new MeterReading(meter1,new Date(),3.1d));
		 meterReadings.add(new MeterReading(meter1,new Date(),3.2d));
		 meterReadings.add(new MeterReading(meter1,new Date(),3.3d));
		 meterReadings.add(new MeterReading(meter1,new Date(),3.4d));
		return meterReadings;
	}

}
