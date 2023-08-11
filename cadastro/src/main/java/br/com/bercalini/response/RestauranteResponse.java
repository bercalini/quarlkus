package br.com.bercalini.response;

import br.com.bercalini.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestauranteResponse {

    public Long id;
    private String cnpj;
    public String nome;
    public String proprietario;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtualizacao;
    private Double latitude;
    private Double longitude;

    public static RestauranteResponse of(Restaurante restaurante) {
        return RestauranteResponse.builder()
                    .id(restaurante.getId())
                    .cnpj(restaurante.getCnpj())
                    .nome(restaurante.getNome())
                    .latitude(restaurante.getLatitude())
                    .longitude(restaurante.getLongitude())
                    .dataCriacao(restaurante.getDataCriacao())
                    .dataAtualizacao(restaurante.getDataAtualizacao())
                    .proprietario(restaurante.getProprietario())
                    .build();
    }
}
