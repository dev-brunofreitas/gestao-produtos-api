package com.treino.gestaoprodutos.service;

import com.treino.gestaoprodutos.dto.ProdutoDTO;
import com.treino.gestaoprodutos.entity.ProdutoEntity;
import com.treino.gestaoprodutos.exception.ResourceNotFoundException;
import com.treino.gestaoprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // [POST] Criar / Salvar um novo produto
    public ProdutoDTO salvar(ProdutoDTO dto) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidade(dto.quantidade());

        ProdutoEntity produtoSalvo = produtoRepository.save(entity);

        return new ProdutoDTO(
                produtoSalvo.getId(),
                produtoSalvo.getNome(),
                produtoSalvo.getPreco(),
                produtoSalvo.getQuantidade()
        );
    }

    // [GET] Listar todos os produtos
    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getPreco(),
                        p.getQuantidade())).collect(Collectors.toList());
    }

    // [GET] Buscar um produto específico por ID
    public ProdutoDTO buscarPorId(Long id) {
        ProdutoEntity entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));

        return new ProdutoDTO(
                entity.getId(),
                entity.getNome(),
                entity.getPreco(),
                entity.getQuantidade()
        );
    }

    // [PUT] Atualizar um produto existente
    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        ProdutoEntity entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));

        entity.setNome(dto.nome());
        entity.setPreco(dto.preco());
        entity.setQuantidade(dto.quantidade());

        ProdutoEntity produtoAtualizado = produtoRepository.save(entity);

        return new ProdutoDTO(
                produtoAtualizado.getId(),
                produtoAtualizado.getNome(),
                produtoAtualizado.getPreco(),
                produtoAtualizado.getQuantidade()
        );
    }

    // [DELETE] Excluir um produto por ID
    public void deletar(Long id) {
        ProdutoEntity entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + id));

        produtoRepository.delete(entity);
    }
}