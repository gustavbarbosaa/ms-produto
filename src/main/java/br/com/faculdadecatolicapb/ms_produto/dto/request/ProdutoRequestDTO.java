package br.com.faculdadecatolicapb.ms_produto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
    @NotBlank(message = "A propriedade nome é obrigatória.")
    @Size(max = 100, message = "O tomanho máximo para o nome é de 100 caracteres.")
    String nome,
    @Positive(message = "O valor deve ser maior que 0.")
    @NotNull(message = "A propriedade valor é obrigatória.")
    BigDecimal valor
) {
}
