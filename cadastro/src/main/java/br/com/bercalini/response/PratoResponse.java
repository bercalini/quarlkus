package br.com.bercalini.response;

import br.com.bercalini.model.Prato;
import br.com.bercalini.model.Restaurante;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PratoResponse {

    private Long id;
    private String nome;
    private String decricao;
    private RestaurantePratoResponse restaurante;
    private BigDecimal preco;

    public static PratoResponse of(Prato prato) {
        RestaurantePratoResponse restaurante = RestaurantePratoResponse.builder()
                .id(prato.getRestaurante().getId())
                .cnpj(prato.getRestaurante().getCnpj())
                .dataAtualizacao(prato.getRestaurante().getDataAtualizacao())
                .dataCriacao(prato.getRestaurante().getDataCriacao())
                .nome(prato.getRestaurante().getNome())
                .proprietario(prato.getRestaurante().getProprietario())
                .build();

        return PratoResponse.builder()
                    .id(prato.getId())
                    .preco(prato.getPreco())
                    .decricao(prato.getDecricao())
                    .nome(prato.getNome())
                    .restaurante(restaurante)
                    .build();
    }
}
