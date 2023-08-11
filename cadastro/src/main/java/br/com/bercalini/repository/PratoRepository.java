package br.com.bercalini.repository;

import br.com.bercalini.model.Prato;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PratoRepository implements PanacheRepository<Prato> {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Prato> findAll(Long restauranteId) {
        return entityManager.createQuery("SELECT p FROM Prato AS p join fetch p.restaurante as r WHERE" +
                        " r.id = :restauranteId", Prato.class)
                .setParameter("restauranteId", restauranteId)
                .getResultList();
    }

    @Transactional
    public Prato buscarPorId(Long restauranteId, Long pratoId) {
        return entityManager.createQuery("SELECT p FROM Prato AS p JOIN FETCH p.restaurante as r WHERE" +
                        " p.id = :pratoId AND r.id = :restauranteId", Prato.class)
                .setParameter("pratoId", pratoId)
                .setParameter("restauranteId", restauranteId)
                .getSingleResult();
    }
}
