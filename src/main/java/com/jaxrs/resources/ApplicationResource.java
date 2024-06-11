package com.jaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/rest")
public class ApplicationResource {

    @GET
    @Path("hello")
    public Response sayHello(){
        return Response.status(Response.Status.OK)
                .entity("Hello world!")
                .build();
    }
}
