package com.adbms.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.adbms.dto.Transport;
import com.adbms.dto.TransportInsert;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AccessMongoData {
	
	//The code fetches data from the database corresponding to the day, start time and end time recieved 
	//It returns a list of Tranport DTO
	@SuppressWarnings("resource")
	public List<Transport> getTrasnportDetailsForDayFromMongo(String day, String startTime, String endTime){
			
		//Establish connection
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
				
		MongoDatabase database = mongoClient.getDatabase("test");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("nyc_bus_data");
	    
	    List<String> dates = DayToDate.getDateFromDayMongo(day);
	    
	    BasicDBObject query = new BasicDBObject("RecordedTime", new BasicDBObject("$gt", startTime).append("$lte", endTime))
	    								.append("RecordedDate", new BasicDBObject("$in", dates));
	    										
	    List<DBObject> criteria = new ArrayList<DBObject>();
	    criteria.add(new BasicDBObject("RecordedTime", new BasicDBObject("$gt", startTime)));
	    criteria.add(new BasicDBObject("RecordedTime", new BasicDBObject("$lte", endTime)));
	    //criteria.add(new BasicDBObject("RecordedDate", new BasicDBObject("$in", dates)));
	    
	    //MongoCursor<Document> cursor = collection.find(new BasicDBObject("$and", criteria)).iterator();
	    
	    
		//MongoCursor<Document> cursor = collection.find(eq("RecordedDate", "6/1/2017")).iterator();
	    MongoCursor<Document> cursor = collection.find(query).iterator();
	    
		List<Transport> transportDetails = new ArrayList<Transport>();
		
		while (cursor.hasNext()) {
			Transport transport = new Transport();
			Document document = (Document) cursor.next();
			transport.setOriginName((String) document.get("OriginName"));
			transport.setDestinationName((String) document.get("DestinationName"));
			transport.setNextStopPointName((String) document.get("NextStopPointName"));
			transport.setExpectedArrivalTime((String) document.get("ExpectedArrTime"));
			transport.setScheduledArrivalTime((String) document.get("ScheduledArrivalTime"));
		
			transportDetails.add(transport);
		}
	   

		//mongoClient.close();
				
		return transportDetails;
			
	}


	Block<Document> printBlock = new Block<Document>() {
	       @Override
	       public void apply(final Document document) {
	           System.out.println(document.toJson());
	       }
	};


	public String insertTransportDetails(TransportInsert transportInsert) {
		// TODO Auto-generated method stub
		//Establish connection
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
				
		MongoDatabase database = mongoClient.getDatabase("test");

	    MongoCollection<Document> collection = (MongoCollection<Document>) database.getCollection("nyc_bus_data");
	    
	    Document document = new Document("OriginName", transportInsert.getOriginName())
                .append("DestinationName", transportInsert.getDestinationName())
                .append("NextStopPointName", transportInsert.getNextStopPointName())
                .append("ScheduledArrivalTime", transportInsert.getScheduledArrivalTime())
                .append("RecordedDate", transportInsert.getRecordedDate())
                .append("RecordedTime", transportInsert.getRecordedTime())
                .append("ExpectedArrDate", transportInsert.getExpectedArrivalDate())
                .append("ExpectedArrTime", transportInsert.getExpectedArrivalTime());
	    
	    collection.insertOne(document);
	    
		return "Inserted Succesfully";

	}

		
}
