# Projeto Java RESTful API
- Este projeto é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. O objetivo da aplicação é gerenciar usuários, contas bancárias, cartões, e outros recursos.
## Principais Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- OpenAPI
- PostMan
- Railway

## Diagrama de classes 
``` mermaid

classDiagram
    class User {
        +String name
        +Account account
        +List~Feature~ features
        +Card card
        +List~News~ news
    }

    class Account {
        +String number
        +String agency
        +double balance
        +double limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +double limit
    }

    class News {
        +String icon
        +String description
    }

    User --> Account
    User --> Feature
    User --> Card
    User --> News

```
## Estrutura do Projeto

- ### Modelos de Domínio:

- `User`: Entidade principal representando um usuário, contendo relacionamentos com `Account`, `Card`, `Feature` e `News`.

- `Account`: Representa uma conta bancária com atributos como número da conta, agência, saldo e limite.

- `Card`: Representa um cartão bancário, incluindo atributos como número do cartão e limite disponível.

- `Feature` e `News`: Entidades adicionais herdadas da classe BaseItem, que contém atributos comuns como id, ícone, e descrição.

- ### Repositório:

- `UserRepository`: Interface responsável pela interação com o banco de dados para a entidade User, utilizando Spring Data JPA. Inclui um método para verificar se um número de conta já existe.

- ### Serviço:

- `UserServiceImplementation`: Implementação do serviço `UserService`, responsável pelas regras de negócios relacionadas aos usuários. Inclui métodos para criar novos usuários e buscar usuários pelo ID.

- ### Controller: 

- `UserController`: Controlador REST que gerencia as operações de criação e busca de usuários. Expondo endpoints como `/users` para criação de usuários e `/users/{id}` para buscar um usuário pelo ID.

- ### Tratamento de Exceções:

- `GlobalExceptionHandler`: Classe responsável pelo tratamento centralizado de exceções, incluindo exceções específicas como `IllegalArgumentException` e `NoSuchElementException`, e exceções inesperadas.


## Funcionalidades 

- Criar Usuário: Permite criar um novo usuário, verificando se o número da conta bancária já existe.

- Buscar Usuário por ID: Retorna os detalhes de um usuário a partir do seu ID.

