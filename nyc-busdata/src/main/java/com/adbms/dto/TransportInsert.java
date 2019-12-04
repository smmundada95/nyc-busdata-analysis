package com.adbms.dto;

import javax.xml.bind.annotation.XmlRootElement;


//DTO for accessing data from the database
@XmlRootElement
public class TransportInsert {

	private String originName;
	
	private String destinationName;
	
	private String nextStopPointName;
	
	private String scheduledArrivalTime;
	
	private String expectedArrivalTime;
	
	private String expectedArrivalDate;
		
	private String recordedDate;
	
	private String recordedTime;
	
	
	
	public String getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public void setExpectedArrivalDate(String expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public String getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(String recordedDate) {
		this.recordedDate = recordedDate;
	}

	public String getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(String recordedTime) {
		this.recordedTime = recordedTime;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getNextStopPointName() {
		return nextStopPointName;
	}

	public void setNextStopPointName(String nextStopPointName) {
		this.nextStopPointName = nextStopPointName;
	}

	public String getExpectedArrivalTime() {
		return expectedArrivalTime;
	}

	public void setExpectedArrivalTime(String expectedArrivalTime) {
		this.expectedArrivalTime = expectedArrivalTime;
	}

	public String getScheduledArrivalTime() {
		return scheduledArrivalTime;
	}

	public void setScheduledArrivalTime(String scheduledArrivalTime) {
		this.scheduledArrivalTime = scheduledArrivalTime;
	}
	
	
}
