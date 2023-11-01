# Desafio Picpay Backend

## Contexto
Projeto para solução do desafio da Picpay em Java Spring seguindo o tutorial da Fernanda Kipper. [Link do reepositório do desafio](https://github.com/PicPay/picpay-desafio-backend).

## Tecnologias 
 - Java
 - Spring-boot
 - Spring-JPA
 - H2

## Rotas Disponíveis

A API possui as seguintes rotas conforme o desafio proposto:

### 1. Adicionar Usuário

```
Endpoint: GET http://localhost:8080/users
```

Retorna uma lista de todos os usuários inseridos.

### 2. Pesquisar um Usuário

```
Endpoint: GET http://localhost:8080/users/{id}
```

Retorna as informações do usuário pesquisado, se existir.

### 3. Inserir um Usuário

```
Endpoint: POST http://localhost:8080/users
```

Realiza um Usuário seguindo as regras de negócio do desafio.

### 4. Inserir uma Transação

```
Endpoint: POST http://localhost:8080/transactions
```

Realiza uma Transação seguindo as regras de negócio do desafio.
