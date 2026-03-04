# 💬 Fórum Hub API

O **Fórum Hub** é uma API REST desenvolvida em Java com Spring Boot, construída para simular o backend de um fórum de discussões. O projeto foca em boas práticas de engenharia de software, incluindo segurança com JWT, validações e tratamento de erros.

Este projeto é a resolução do Challenge Back-End do programa Oracle Next Education (ONE) em parceria com a Alura.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3** (Web, Validation, Security)
* **Spring Data JPA** (Persistência de dados)
* **MySQL** (Banco de Dados Relacional)
* **Flyway** (Gerenciamento de Migrations)
* **Spring Security & JWT (Auth0)** (Autenticação Stateless)
* **Lombok** (Redução de código boilerplate)
* **Insomnia** (Para testes de API)

## 🏗️ Arquitetura do Projeto

A API foi desenvolvida seguindo o padrão de projeto MVC adaptado para REST, garantindo separação de responsabilidades:
* **Controllers:** Roteamento e recebimento das requisições HTTP.
* **Repositories:** Interfaces do Spring Data JPA para comunicação com o banco de dados.
* **DTOs (Data Transfer Objects):** Padrão utilizado para mapear exatamente os dados que entram e saem da API, blindando as entidades do banco de dados.
* **Infra/Security:** Configurações de filtros de segurança e geração de tokens JWT.
* **Exception Handler:** Tratamento global de exceções para padronizar as respostas de erro da API.

## 🔒 Segurança e Autenticação

A API é restrita. Para interagir com os tópicos, o usuário precisa estar autenticado. O fluxo funciona da seguinte forma:
1. O usuário envia credenciais (`login` e `senha`) para a rota `/login`.
2. O Spring Security verifica o hash **BCrypt** salvo no banco de dados.
3. Se válido, a API devolve um **Token JWT**.
4. Esse token deve ser enviado no cabeçalho (`Authorization: Bearer {token}`) em todas as requisições subsequentes.

## 📍 Endpoints Principais

### Autenticação
* `POST /login`: Recebe as credenciais e devolve o token JWT.
  ```json
  {
    "login": "aluno@email.com",
    "senha": "123456"
  }
  ```
  
### Tópicos (Requer Token JWT)
* `POST /topicos`: Cria um novo tópico (título e mensagem são obrigatórios e não podem ser duplicados).
* `GET /topicos`: Lista todos os tópicos abertos.
* `GET /topicos/{id}`: Detalha um tópico específico por ID.
* `PUT /topicos/{id}`: Atualiza os dados de um tópico.
* `DELETE /topicos/{id}`: Exclui um tópico do sistema.

## ⚠️ Tratamento de Erros

A API não devolve o "Trace" de erro do Java para o cliente. Os erros são mapeados e padronizados no formato JSON:
* **400 Bad Request:** Acionado quando o usuário envia dados inválidos ou em branco (Bean Validation).
* **403 Forbidden:** Acionado quando o token JWT é inválido, expirou ou a senha de login está incorreta.
* **404 Not Found:** Acionado quando um ID buscado não existe no banco de dados.

## 🛠️ Como executar o projeto localmente

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/LeilannyRodrigues/forum_hub.git
   ```

2. **Configure o Banco de Dados MySQL:**
   Crie um banco chamado `forum_hub`. Acesse o arquivo `src/main/resources/application.properties` e insira o seu usuário e senha local do banco:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost/forum_hub
   spring.datasource.username=root
   spring.datasource.password=sua_senha_aqui
   ```

3. **Inicie a Aplicação:**
   Ao rodar o projeto via IntelliJ ou terminal, o **Flyway** criará as tabelas automaticamente.

4. **Crie um usuário de teste no Banco:**
   Como as senhas precisam estar obrigatoriamente criptografadas, rode este script no seu MySQL Workbench para criar um usuário padrão com a senha `123456`:
   ```sql
   INSERT INTO usuarios (nome, email, senha) 
   VALUES ('Aluno', 'aluno@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
   ```

   ---

   **Desenvolvido para o Challenge Fórum Hub** **Alura + Oracle Next Education (ONE) - 2026**
