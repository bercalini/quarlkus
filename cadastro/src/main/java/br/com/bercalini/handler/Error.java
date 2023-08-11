package br.com.bercalini.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Error {

    private String titulo;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private Integer status;

}
