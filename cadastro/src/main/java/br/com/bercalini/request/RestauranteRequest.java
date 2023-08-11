package br.com.bercalini.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteRequest {

    @NotBlank(message = "O campo CNPJ não pode estar em branco ou ser nullo")
    @CNPJ
    private String cnpj;

    @Size(min = 3, max = 20)
    @NotBlank(message = "O campo NOME não pode estar em branco ou ser nullo")
    private String nome;

    @NotBlank(message = "O campo PROPRIETARIO não pode estar em branco ou ser nullo")
    private String proprietario;

    private Double latitude;

    private Double longitude;
}
