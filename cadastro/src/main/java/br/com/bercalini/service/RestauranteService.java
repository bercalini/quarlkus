package br.com.bercalini.service;

import br.com.bercalini.handler.ObjetoNaoEncontradoException;
import br.com.bercalini.model.Restaurante;
import br.com.bercalini.repository.RestauranteRepository;
import br.com.bercalini.request.RestauranteRequest;
import br.com.bercalini.response.RestauranteResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RestauranteService {

    @Inject
    RestauranteRepository restauranteRepository;


    @Transactional
    public void salvar(RestauranteRequest restauranteRequest) {
        var restaurante = Restaurante.of(restauranteRequest);
        restauranteRepository.persist(restaurante);
    }

    @Transactional
    public RestauranteResponse editar(Long id, RestauranteRequest restauranteRequest) {
        Restaurante restauranteRetornado = verificarRestaurante(id);

        restauranteRetornado.setProprietario(restauranteRequest.getProprietario());
        restauranteRetornado.setCnpj(restauranteRequest.getCnpj());
        restauranteRetornado.setLatitude(restauranteRequest.getLatitude());
        restauranteRetornado.setLongitude(restauranteRequest.getLongitude());
        restauranteRetornado.setNome(restauranteRequest.getNome());

        return RestauranteResponse.of(restauranteRetornado);
    }

    public RestauranteResponse buscarPorId(Long id) {
        var restaurante = restauranteRepository.findByIdOptional(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Restaurante com o codigo id: " + id + " não encontrado"));
        return RestauranteResponse.of(restaurante);
    }

    public List<RestauranteResponse> findAll() {
        return restauranteRepository.findAll().list()
                .stream()
                .map(RestauranteResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void excluir(Long id) {
        var restaurante = verificarRestaurante(id);
        restauranteRepository.delete(restaurante);
    }

    @SneakyThrows
    public Restaurante verificarRestaurante(Long id) {
        return restauranteRepository.findByIdOptional(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Restaurante com o codigo id: " + id + " não encontrado"));
    }
}
