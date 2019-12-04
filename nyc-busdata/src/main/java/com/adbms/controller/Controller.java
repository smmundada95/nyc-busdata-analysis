package com.adbms.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adbms.data.AccessData;
import com.adbms.data.AccessMongoData;
import com.adbms.dto.Transport;
import com.adbms.dto.TransportInsert;

/**
 * Root resource (exposed at "transport" path)
 */
@Path("transport")
public class Controller {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "APPLICATION_JSON" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    @GET
    @Path("/details/{day}/{startTime}/{endTime}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transport> getTransportDetailsForDay(@PathParam("day") String day, 
    		@PathParam("startTime") String startTime, @PathParam("endTime") String endTime) {
    	AccessData accessData = new AccessData();
    	List<Transport> transportDetails = accessData.getTrasnportDetailsForDay(day, startTime, endTime);
    	return transportDetails;
    }
    
    @GET
    @Path("/mongoDetails/{day}/{startTime}/{endTime}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transport> getMongoData(@PathParam("day") String day, 
    		@PathParam("startTime") String startTime, @PathParam("endTime") String endTime) {
    	AccessMongoData accessMongoData = new AccessMongoData();
    	List<Transport> transportDetails = accessMongoData.getTrasnportDetailsForDayFromMongo(day, startTime, endTime);
    	return transportDetails;
    }
    

    
    @POST
    @Path("/mongoInsert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertMongoData(TransportInsert transportInsert) {
    	AccessMongoData accessMongoData = new AccessMongoData();
        return accessMongoData.insertTransportDetails(transportInsert);
    }
    
}
