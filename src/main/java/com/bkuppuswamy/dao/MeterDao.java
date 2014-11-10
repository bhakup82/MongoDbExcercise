package com.bkuppuswamy.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.bkuppuswamy.models.Meter;
import com.bkuppuswamy.models.MeterReading;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MeterDao {

	private MongoClient mongo = null;
	
    private DB db;
    
    private DBCollection meterCollection;
    
    private DBCollection meterReadingCollection;
	
	/**
	 * @return the mongo
	 */
	public MongoClient getMongo() {
		if(null==mongo){
			try {
				this.mongo = new MongoClient( "localhost" , 27017 );
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.mongo;
	}
	
	public MeterDao(){
		this.mongo = this.getMongo();
		this.db = mongo.getDB("interviewtestdb");
		this.meterCollection = db.getCollection("meter");
		this.meterReadingCollection = db.getCollection("meterreading");
	}


	public void updateMeterReading(String meterId, double updateKwh) {
		BasicDBObject query = new BasicDBObject("meter.meterId",meterId);
		 
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("kwh", updateKwh);
	 
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
	 
		meterReadingCollection.update(query, updateObj);
	 
	}

	public List<DBObject> findMeterReadings(String meterId) {
		BasicDBObject query = new BasicDBObject("meter.meterId", meterId);
		 
		DBCursor cursor = meterReadingCollection.find(query);
		List<DBObject> readings = new ArrayList<DBObject>();
		while (cursor.hasNext()) {
			DBObject theObj = cursor.next();
			readings.add(theObj);
		}
		return readings;
	}
	
	
	public void addMeter(Meter meter){
		BasicDBObject meterDocument = new BasicDBObject();
		meterDocument.put("meterId",meter.getMeterId());
		meterDocument.put("meterModel",meter.getMeterModel());
		meterDocument.put("installDate",meter.getInstallDate());
		meterDocument.put("Address",meter.getAddress());
		meterCollection.insert(meterDocument);
	}
	
	public void addMeters(List<Meter> meters){
		for(Meter meter: meters){
			this.addMeter(meter);
		}
		
	}
	
	public void addMeterReading(MeterReading meterReading){
		BasicDBObject meterReadingDocument = new BasicDBObject();
		BasicDBObject meterDocument = new BasicDBObject();
		Meter meter = meterReading.getMeter();
		meterDocument.put("meterId",meter.getMeterId());
		meterDocument.put("meterModel",meter.getMeterModel());
		meterDocument.put("installDate",meter.getInstallDate());
		meterDocument.put("Address",meter.getAddress());
		
		meterReadingDocument.put("meter",meterDocument);
		meterReadingDocument.put("readingTime",meterReading.getReadingTime());
		meterReadingDocument.put("kwh",meterReading.getKwh());
		meterReadingCollection.insert(meterReadingDocument);
		
	}
	
	public void addMeterReadings(List<MeterReading> meterReadings){
		for(MeterReading meterReading: meterReadings){
			this.addMeterReading(meterReading);
		}
	}

}
