package br.com.faculdadecatolicapb.ms_produto.service;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import br.com.faculdadecatolicapb.ms_produto.dto.response.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_produto.mapper.ProdutoMapper;
import br.com.faculdadecatolicapb.ms_produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public List<ProdutoResponseDTO> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos
                .stream()
                .map(produtoMapper::toDTO)
                .toList();
    }

    public ProdutoResponseDTO buscarPorId(UUID id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));

        return produtoMapper.toDTO(produto);
    }
}
