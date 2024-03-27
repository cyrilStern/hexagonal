/**
 * Copyright (c) 2024 Splio.com All rights reserved.
 */
package io.pmu.config.http.exceptionhandler;


import io.pmu.exception.ErrorResponse;
import io.pmu.race.exception.ParticapantExeption;
import io.pmu.race.exception.ParticipantNumberException;
import io.pmu.race.exception.RaceException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class IllegalConstraintViolationExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    private static final Logger LOGGER = Logger.getLogger(ServerExceptionMapper.class);

    /**
     * this is a sample exemple of how to return error base on quarkus handler
     * @param e IllegalArgumentException on already store race
     * @return Response 400
     */
    @Override
    public Response toResponse(IllegalArgumentException e) {
        LOGGER.infof(e, "something goes wrong %", e.getMessage());
        return switch (e){
            case ParticapantExeption p ->  Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "the payload does not respect rule for participant")).build();
            case RaceException ex -> Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "race ")).build();
            case ParticipantNumberException n -> Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "participan number exception")).build();
            default -> Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse.ErrorMessage("/race", "something is bad in the payload")).build();
        };
    }
}
