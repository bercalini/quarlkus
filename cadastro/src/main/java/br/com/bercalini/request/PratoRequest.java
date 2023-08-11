package br.com.bercalini.request;

import br.com.bercalini.model.Restaurante;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PratoRequest {

    @NotBlank(message = "O campo NOME não pode ser branco e nullo")
    private String nome;

    @NotBlank(message = "O campo NOME não pode ser branco e nullo")
    private String decricao;

    private RestaurantePratoRequest restaurante;

    @NotNull(message = "O campo PREÇO não pode ser branco e nullo")
    private BigDecimal preco;
}
