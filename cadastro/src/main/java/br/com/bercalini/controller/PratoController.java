package br.com.bercalini.controller;

import br.com.bercalini.model.Prato;
import br.com.bercalini.request.PratoRequest;
import br.com.bercalini.response.PratoResponse;
import br.com.bercalini.service.PratoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/restaurantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Pratos")
public class PratoController {
    @Inject
    PratoService pratoService;

    @POST
    @Path("/{restauranteId}/pratos")
    public Response salvar(@PathParam("restauranteId") Long restauranteId, @Valid PratoRequest pratoRequest) {
        pratoService.salvar(restauranteId, pratoRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT()
    @Path("/{restauranteId}/pratos/{pratoId}")
    public PratoResponse editar(@PathParam("restauranteId") Long restauranteId, @PathParam("pratoId") Long pratoId, @Valid PratoRequest pratoRequest) {
        return pratoService.editar(restauranteId, pratoId, pratoRequest);
    }

    @GET
    @Path("/{restauranteId}/pratos/{pratoId}")
    public PratoResponse buscarPorId(@PathParam("restauranteId") Long restauranteId, @PathParam("pratoId") Long pratoId) {
        return pratoService.buscarPorId(restauranteId, pratoId);
    }

    @GET
    @Path("/{restauranteId}/pratos")
    public List<PratoResponse> listar(@PathParam("restauranteId") Long restauranteId) {
        return pratoService.findAll(restauranteId);
    }

    @DELETE
    @Path("/{restauranteId}/pratos/{pratoId}")
    public void excluir(@PathParam("restauranteId") Long restauranteId, @PathParam("pratoId") Long pratoId) {
        pratoService.excluir(restauranteId, pratoId);
    }

}
