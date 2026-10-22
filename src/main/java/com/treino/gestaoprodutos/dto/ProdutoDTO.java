package com.treino.gestaoprodutos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoDTO(
        Long id,

        @NotBlank(message = "O nome do produto não pode estar vazio ou em branco")
        String nome,

        @NotNull(message = "O preço não pode ser nulo")
        @Positive(message = "O preço deve ser um valor positivo maior que zero")
        Double preco,

        @NotNull(message = "A quantidade não pode ser nula")
        @Positive(message = "A quantidade deve ser um valor positivo maior que zero")
        Integer quantidade
) {
}