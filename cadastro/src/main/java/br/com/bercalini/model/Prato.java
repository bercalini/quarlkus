package br.com.bercalini.model;

import br.com.bercalini.request.PratoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "prato")
public class Prato  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String decricao;

    @ManyToOne
    private Restaurante restaurante;

    private BigDecimal preco;

    public static Prato of(PratoRequest pratoRequest) {
        return Prato.builder()
                .decricao(pratoRequest.getDecricao())
                .nome(pratoRequest.getNome())
                .preco(pratoRequest.getPreco())
                .build();
    }
}
