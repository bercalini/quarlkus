package br.com.bercalini.handler;

import br.com.bercalini.enums.ErrorTituloEnum;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDate;

@Provider
public class NoResultExceptionHandler implements ExceptionMapper<NoResultException> {

    @Override
    public Response toResponse(NoResultException e) {
        var error = Error.builder()
                .status(404)
                .data(LocalDate.now())
                .titulo(ErrorTituloEnum.OBJETO_NAO_ENCONTRADO)
                .descricao(e.getMessage())
                .build();

        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
