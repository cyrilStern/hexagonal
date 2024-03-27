/**
 * Copyright (c) 2024 Splio.com All rights reserved.
 */
package io.pmu.config.http.exceptionhandler;


import io.pmu.exception.ErrorResponse;
import io.pmu.race.exception.DuplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    private static final Logger LOGGER = Logger.getLogger(ServerExceptionMapper.class);
    /**
     * this is a sample exemple of how to return error base on quarkus handler
     * @param e DuplicationException on already store race
     * @return Response 400
     */
    @Override
    public Response toResponse(RuntimeException e) {
        LOGGER.infof(e, "something goes wrong %", e.getMessage());
        return switch (e){
            case DuplicationException dex ->  Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "already save")).build();
             default -> Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "something is bad in the payload")).build();
        };
    }
}
