package br.com.faculdadecatolicapb.ms_produto.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(
    UUID id,
    String nome,
    BigDecimal valor
) { }
