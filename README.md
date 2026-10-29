# 📦 Gestão de Produtos API

API RESTful para gerenciamento completo de produtos, desenvolvida em **Java** com **Spring Boot**. O projeto foi construído seguindo as melhores práticas de arquitetura em camadas, validação de dados com DTOs e tratamento global de exceções.

---

## 🚀 Funcionalidades

- **CRUD Completo de Produtos:** Criar, buscar por ID, listar, atualizar e deletar produtos.
- **Validação de DTOs:** Garantia de integridade de dados na entrada das requisições via Spring Validation.
- **Tratamento Global de Exceções:** Manipulação centralizada de erros (`GlobalExceptionHandler`) retornando respostas HTTP adequadas (ex: 404 Not Found com `ResourceNotFoundException`).
- **Respostas HTTP Padronizadas:** Uso correto dos status HTTP (200 OK, 204 No Content, etc.).

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3.x
- **Spring Modules:** Spring Web, Spring Data JPA, Spring Validation
- **Ferramentas & Ambientes:** Maven, IntelliJ IDEA, Git & GitHub

---

## 📂 Estrutura do Projeto

```text
src/main/java/com/treino/gestaoprodutos
├── controller/          # Endpoints REST (ProdutoController)
├── dto/                 # Objetos de Transferência de Dados (ProdutoDTO)
├── entity/              # Entidades JPA (ProdutoEntity)
├── exception/           # Tratamento global e exceções customizadas (GlobalExceptionHandler, ResourceNotFoundException)
├── repository/          # Interface de persistência (ProdutoRepository)
├── service/             # Regras de negócio (ProdutoService)
└── GestaoProdutosApplication.java
