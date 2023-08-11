package br.com.bercalini.service;

import br.com.bercalini.model.Prato;
import br.com.bercalini.repository.PratoRepository;
import br.com.bercalini.request.PratoRequest;
import br.com.bercalini.response.PratoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PratoService {

    @Inject
    PratoRepository pratoRepository;
    @Inject
    RestauranteService restauranteService;

    @Transactional
    public void salvar(Long restauranteId, PratoRequest pratoRequest) {
        var restaurante = restauranteService.verificarRestaurante(restauranteId);

        var prato = Prato.of(pratoRequest);

        prato.setRestaurante(restaurante);

        pratoRepository.persist(prato);
    }

    @Transactional
    public PratoResponse editar(Long restauranteId, Long pratoId, PratoRequest pratoRequest) {
        var pratoRetornado = verificarRestauranteAndPrato(restauranteId, pratoId);

        pratoRetornado.setDecricao(pratoRequest.getDecricao());
        pratoRetornado.setNome(pratoRequest.getNome());
        pratoRetornado.setPreco(pratoRequest.getPreco());

        return PratoResponse.of(pratoRetornado);
    }

    @Transactional
    public void excluir(Long restauranteId, Long pratoId) {
        var prato = verificarRestauranteAndPrato(restauranteId, pratoId);
        pratoRepository.delete(prato);
    }

    public List<PratoResponse> findAll(Long restauranteId) {
        return pratoRepository.findAll(restauranteId)
                .stream()
                .map(PratoResponse::of)
                .collect(Collectors.toList());
    }

    public PratoResponse buscarPorId(Long restauranteId, Long pratoId) {
        var prato = pratoRepository.buscarPorId(restauranteId, pratoId);
        return PratoResponse.of(prato);
    }

    private Prato verificarRestauranteAndPrato(Long restauranteId, Long pratoIn) {
        return pratoRepository.buscarPorId(restauranteId, pratoIn);
    }
}
