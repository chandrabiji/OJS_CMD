package com.hexaware.MLP321.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/matrix")
public class QueryParamTest {
 @GET
 @Produces("text/html")
 public Response getResultByPassingValue(@MatrixParam("nameKey")String name,@MatrixParam("countryKey")String country) {
   String output = "Customer Name : "+name+" Country : "+country+"";
   return Response.status(200).entity(output).build();
 }
}
