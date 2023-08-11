package br.com.bercalini.handler;

import br.com.bercalini.enums.ErrorTituloEnum;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDate;

@Provider
public class ExceptionHandler implements ExceptionMapper<ObjetoNaoEncontradoException> {

    @Override
    public Response toResponse(ObjetoNaoEncontradoException e) {
        var error = Error.builder()
                .status(404)
                .data(LocalDate.now())
                .titulo(ErrorTituloEnum.OBJETO_NAO_ENCONTRADO)
                .descricao(e.getMessage())
                .build();

        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
