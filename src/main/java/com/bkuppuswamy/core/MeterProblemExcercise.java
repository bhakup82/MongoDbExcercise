/**
 * 
 */
package com.bkuppuswamy.core;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author bkuppuswamy
 *
 */
public class MeterProblemExcercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient mongo = null;
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**** Get database ****/
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("testdb");
		
		/**** Get collection / table from 'testdb' ****/
		// if collection doesn't exists, MongoDB will create it for you
		DBCollection meterCollection = db.getCollection("meter");
		
		/**** Insert  Meter****/
		BasicDBObject meterDocument = new BasicDBObject();
		meterDocument.put("meterId","test1");
		meterDocument.put("meterModel", "testusamodel");
		meterDocument.put("installDate", new Date());
		meterDocument.put("Address", "testAddress");
		meterCollection.insert(meterDocument);
		
		
		DBCollection meterReadingCollection = db.getCollection("meterreading");
		
		/**** Insert  MeterReading****/
		BasicDBObject meterReadingDocument1 = new BasicDBObject();

		meterReadingDocument1.put("meter","m1");
		meterReadingDocument1.put("readingTime", new Date());
		meterReadingDocument1.put("kwh","1.2");
	
		meterReadingCollection.insert(meterReadingDocument1);
		
		
		BasicDBObject meterReadingDocument2 = new BasicDBObject();

		meterReadingDocument2.put("meter","m2");
		meterReadingDocument2.put("readingTime", new Date());
		meterReadingDocument2.put("kwh","1.6");
		
		meterReadingCollection.insert(meterReadingDocument2);
		
		BasicDBObject meterReadingDocument3 = new BasicDBObject();

		meterReadingDocument3.put("meter",meterDocument);
		meterReadingDocument3.put("readingTime", new Date());
		meterReadingDocument3.put("kwh","1.7");
		
		meterReadingCollection.insert(meterReadingDocument3);
		
		//Using Mongo calculate and print out the average kwh for one specific meter
		
		BasicDBObject query = new BasicDBObject();
		BasicDBObject queryMeterDocument = new BasicDBObject();
		queryMeterDocument.put("meterId","test1");
		query.put("kwh","1.6");
		
		DBCursor cursor2 = meterReadingCollection.find(query);
		 
		while (cursor2.hasNext()) {
			System.out.println(cursor2.next());
		}
		
		DB dxb = mongo.getDB("testdb");
		DBCollection table = dxb.getCollection("meter");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("meterId","test1");
	 
		DBCursor cursor = table.find(searchQuery);
	 
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
		DBCollection table2 = dxb.getCollection("meterreading");
		BasicDBObject queryx = new BasicDBObject("meter.meterId", "test1");

		
	
		DBCursor cursor22 = table2.find(queryx);
		List<Double> readings = new ArrayList<Double>();
		while (cursor22.hasNext()) {
			DBObject theObj = cursor22.next();
			readings.add( Double.parseDouble((String)theObj.get("kwh")));
		}
		
		double largest = Double.MIN_VALUE;
		
		for(Double value : readings) {
		
		            if( value > largest) {
		
		                largest = value;
		
		            }
		
		        }
		
		         
	     System.out.println("Largest number in array is : " +largest);

		 System.out.println(readings.size());
		
		
		BasicDBObject query1 = new BasicDBObject("meter.meterId", "test1");
	 
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("kwh", "2.2");
	 
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
	 
		table2.update(query1, updateObj);
	 
		/**** Find and display ****/
		BasicDBObject searchQuery2 
		    = new BasicDBObject().append("kwh", "2.2");
	 
		DBCursor cursorx = table2.find(searchQuery2);
	 
		while (cursorx.hasNext()) {
			System.out.println(cursorx.next());
		}
	 
		
	
	}
	


}
