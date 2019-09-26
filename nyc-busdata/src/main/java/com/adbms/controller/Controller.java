package com.adbms.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adbms.data.AccessData;
import com.adbms.dto.Student;
import com.adbms.dto.Transport;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("transport")
public class Controller {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getTrafficDetails() {
//    	String response = AccessData.returnData();
//        return response;
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getAllStudentDetails() {
    	AccessData accessData = new AccessData();
    	List<Student> students = accessData.getAllStudents();
    	return students;
    }
    
    @GET
    @Path("/students/{uin}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getStudentDetails(@PathParam("uin") String uin) {
    	AccessData accessData = new AccessData();
    	List<Student> students = accessData.getStudentDetails(uin);
    	return students;
    }
    
    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transport> getTransportDetails() {
    	AccessData accessData = new AccessData();
    	List<Transport> transportDetails = accessData.getTrasnportDetails();
    	return transportDetails;
    }
    
}
