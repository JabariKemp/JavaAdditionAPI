package test;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/add")
public class Add {
	
	 @OPTIONS
	  @Path("/getsample")
	  public Response getOptions() {
	    return Response.ok()
	      .header("Access-Control-Allow-Origin", "*")
	      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
	      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	  }

	@GET
	@Produces(MediaType.TEXT_XML)
	public String addXML(){
		String resource = "<? xml version='1.0' ?>"+
				"<hello>XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addJSON(){
		String resource = "JSON";
		return resource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String addHTML(@QueryParam("firstNum") int firstNum, @QueryParam("secondNum") int secondNum){
		int sum = firstNum+secondNum;
		String resource = "<h1>"+String.valueOf(sum)+"</h1>";
		return resource;
	}
}
