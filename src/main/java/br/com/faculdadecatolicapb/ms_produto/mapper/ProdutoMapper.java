package br.com.faculdadecatolicapb.ms_produto.mapper;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import br.com.faculdadecatolicapb.ms_produto.dto.request.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.response.ProdutoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDTO(Produto entity);
}
