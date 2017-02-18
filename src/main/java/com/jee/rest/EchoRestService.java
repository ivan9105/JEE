package com.jee.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by Иван on 14.02.2017.
 */
@Path("/echo")
public class EchoRestService {
    @GET
    public String ping() {
        return "Ping!";
    }

    @POST
    public String echo(@FormParam("msg") String msg) {
        return String.format("ECHO: %s", msg);
    }
}
