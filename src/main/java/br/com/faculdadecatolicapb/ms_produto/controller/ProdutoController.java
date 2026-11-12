package br.com.faculdadecatolicapb.ms_produto.controller;

import br.com.faculdadecatolicapb.ms_produto.dto.request.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.response.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_produto.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok(produtoService.cadastrar(produtoRequestDTO));
    }

    @PutMapping("/{id}/editar")
    public ResponseEntity<ProdutoResponseDTO> editar(
            @PathVariable UUID id,
            @Valid @RequestBody ProdutoRequestDTO produtoRequestDTO
    ) {
        return ResponseEntity.ok(produtoService.editar(id, produtoRequestDTO));
    }

    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
