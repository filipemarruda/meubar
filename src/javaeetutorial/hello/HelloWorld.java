package javaeetutorial.hello;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
 
/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld/{username: [a-zA-Z][a-zA-Z_0-9]*}")
@Produces("text/plain")
public class HelloWorld {
    @Context
    private UriInfo context;
 
    /** Creates a new instance of HelloWorld */
    public HelloWorld() {
    }
 
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
    
    @GET
    public String doGetAsPlainText(@PathParam("username") String user) {
    	return "Hello, "+user;
    }
    
    @POST
    public String doPostPlainText(@PathParam("username") String user){
    	
    	return "Hello, "+user;
    }
}