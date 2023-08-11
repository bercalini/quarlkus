package br.com.bercalini.controller;

import br.com.bercalini.request.RestauranteRequest;
import br.com.bercalini.response.RestauranteResponse;
import br.com.bercalini.service.RestauranteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.*;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/api/restaurantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Restaurante")
@RolesAllowed("proprietario")
@SecurityScheme(securitySchemeName = "ifood-oauth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/ifood/protocol/openid-connect/token")))
//@SecurityRequirements(value = {@SecurityRequirement(name = "ifood-oauth", scopes = {})})
@SecurityRequirement(name = "ifood-oauth")
public class RestauranteController {

    @Inject
    RestauranteService restauranteService;

    @POST
    public Response salvar(@Valid RestauranteRequest restauranteRequest) {
        restauranteService.salvar(restauranteRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public RestauranteResponse editar(@PathParam("id") Long id, RestauranteRequest restauranteRequest) {
        return restauranteService.editar(id, restauranteRequest);
    }

    @GET
    public List<RestauranteResponse> listar() {
        return restauranteService.findAll();
    }

    @GET
    @Path("/{id}")
    public RestauranteResponse buscarPorId(@PathParam("id") Long id) {
        return restauranteService.buscarPorId(id);
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {
        restauranteService.excluir(id);
    }

}
