package br.com.faculdadecatolicapb.ms_produto.repository;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository
        extends JpaRepository<Produto, UUID> {
}
