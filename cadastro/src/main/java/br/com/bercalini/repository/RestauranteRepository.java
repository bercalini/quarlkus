package br.com.bercalini.repository;

import br.com.bercalini.model.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RestauranteRepository implements PanacheRepository<Restaurante> {


}
