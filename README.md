# 🗣️ Fórum Hub API

API RESTful para um sistema de fórum construída com **Java e Spring Boot** — projeto desenvolvido como desafio final do curso de back-end da **Alura** em parceria com o **Oracle Next Education (ONE)**.

---

## 🧠 Visão Geral

O objetivo do Fórum Hub API é fornecer um backend robusto para aplicações de fórum de discussões, garantindo segurança e integridade dos dados. O sistema permite operações como:

* 📌 **CRUD de tópicos** (Criar, Listar, Atualizar e Deletar)
* 🔐 **Autenticação e autorização** de usuários
* 🛡️ **Proteção de rotas** (Separação entre rotas públicas e privadas)

---

## 🚀 Funcionalidades

- ✅ **Endpoints REST** bem definidos e padronizados
- ✅ **Estrutura de projeto** moderna em Java 17 com Spring Boot 3
- ✅ **Persistência de dados** em banco de dados relacional (MySQL)
- ✅ **Migrações automatizadas** utilizando Flyway
- ✅ **Segurança Stateless** utilizando tokens JWT e senhas criptografadas (BCrypt)
- ✅ **Tratamento de erros global** devolvendo respostas limpas em formato JSON

---

## 📋 Pré-requisitos

Antes de iniciar, tenha instalado na sua máquina:

* ☕ **Java JDK 17+**
* 🐘 **Maven 3.6+**
* 🐬 **Banco de dados** (MySQL)
* 🟪 **Insomnia** ou Postman (Para testar as requisições)

---

## 📦 Instalação e Execução

### 1. Clonar o repositório
```bash
git clone https://github.com/LeilannyRodrigues/forum_hub.git
```

### 2. Configurar o Banco de Dados
Crie um banco de dados local chamado `forum_hub` no seu MySQL.
Abra o arquivo `src/main/resources/application.properties` e configure as credenciais da sua máquina:
```properties
spring.datasource.url=jdbc:mysql://localhost/forum_hub
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui
```

### 3. Criar o usuário de teste
Para testar o login na API, é necessário ter um usuário com senha criptografada. Execute o script abaixo no seu banco de dados para criar o usuário padrão com a senha `123456`:
```sql
INSERT INTO usuarios (nome, email, senha) 
VALUES ('Aluno', 'aluno@email.com', '$2a$10$Y50UOPQxteJIGqYVuMeehOFyfCooWCoPiuGP12.rqbD4IboSF5.j');
```

### 4. Rodar a aplicação
Inicie a aplicação rodando a classe `Application.java` na sua IDE (IntelliJ). O Flyway criará todas as tabelas automaticamente.

---

## 📌 Exemplos de Endpoints

Abaixo estão as rotas disponíveis na aplicação. 

| Método | Endpoint | Acesso | Descrição |
| :--- | :--- | :--- | :--- |
| **POST** | `/login` | 🔓 Público | Recebe `email` e `senha`, devolve o Token JWT |
| **GET** | `/topicos` | 🔓 Público | Lista todos os tópicos abertos |
| **GET** | `/topicos/{id}` | 🔓 Público | Detalha um tópico específico pelo ID |
| **POST** | `/topicos` | 🔐 Protegido | Cria um novo tópico (Autor via token) |
| **PUT** | `/topicos/{id}` | 🔐 Protegido | Atualiza dados de um tópico |
| **DELETE** | `/topicos/{id}` | 🔐 Protegido | Exclui um tópico do sistema |

   **Desenvolvido para o Challenge Fórum Hub** **Alura + Oracle Next Education (ONE) - 2026**
