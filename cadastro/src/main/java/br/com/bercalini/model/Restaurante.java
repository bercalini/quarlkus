package br.com.bercalini.model;

import br.com.bercalini.request.RestauranteRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurante  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    private String nome;

    private String proprietario;

    @CreationTimestamp
    private LocalDate dataCriacao;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;

    private Double latitude;

    private Double longitude;

    public static Restaurante of(RestauranteRequest restauranteRequest) {
        return Restaurante.builder()
                .cnpj(restauranteRequest.getCnpj())
                .nome(restauranteRequest.getNome())
                .proprietario(restauranteRequest.getProprietario())
                .longitude(restauranteRequest.getLongitude())
                .latitude(restauranteRequest.getLatitude())
                .build();
    }
}
