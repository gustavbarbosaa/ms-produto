package br.com.faculdadecatolicapb.ms_produto.service;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import br.com.faculdadecatolicapb.ms_produto.dto.request.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.response.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_produto.execptions.ResourceNotFoundExeception;
import br.com.faculdadecatolicapb.ms_produto.mapper.ProdutoMapper;
import br.com.faculdadecatolicapb.ms_produto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
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
                .orElseThrow(() -> new ResourceNotFoundExeception("Produto não encontrado."));

        return produtoMapper.toDTO(produto);
    }

    @Transactional
    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.toEntity(produtoRequestDTO);

        produto = produtoRepository.save(produto);

        return produtoMapper.toDTO(produto);
    }

    @Transactional
    public ProdutoResponseDTO editar(UUID id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Produto não encontrado."));

        produto.setNome(produtoRequestDTO.nome());
        produto.setValor(produtoRequestDTO.valor());

        produto = produtoRepository.save(produto);

        return produtoMapper.toDTO(produto);
    }

    @Transactional
    public void deletar(UUID id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Produto não encontrado."));

        produtoRepository.delete(produto);
    }
}
