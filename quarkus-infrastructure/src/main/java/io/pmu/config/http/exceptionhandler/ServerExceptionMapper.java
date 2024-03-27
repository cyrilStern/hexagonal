/**
 * Copyright (c) 2024 Splio.com All rights reserved.
 */
package io.pmu.config.http.exceptionhandler;


import io.pmu.exception.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class ServerExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = Logger.getLogger(ServerExceptionMapper.class);
    /**
     * this is a sample exemple of how to return error base on quarkus handler
     * @param e Exception on already store race
     * @return Response 500
     */
    @Override
    public Response toResponse(Exception e) {
        LOGGER.errorf(e, "something goes wrong %", e.getMessage());
        return switch (e){
         default -> Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorResponse.ErrorMessage("/race", "something goes wrong")).build();
        };
    }
}
