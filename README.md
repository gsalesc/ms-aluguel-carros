# Microsserviço de Aluguel de Carros

Microsserviço simples de aluguel de carros que realiza comunicação com um serviço de email

### Ferramentas utilizadas
  1. Spring Boot
  2. Spring Data JPA
  3. Spring OpenFeign
  4. Lombok
  5. Flyway
  6. Spring Eureka Server

## API
  - POST /api/aluguel
  ```
  Payload

  {
    "carroId": Integer,
    "cliente": {
        "nome":String,
        "cpf": String,
        "data_nascimento": DateTime,
        "email": String
    }, 
    "dataInicio": DateTime,
    "precoDia": Double,
    "qtdDias": Integer
  }
  ```
  ```
  200 OK
  {
    "id": String
  }
  ```

  - GET /api/aluguel/{cpf}
  
  ```
  200 OK
    [
      {
        "carro": {
            "nome": String,
            "marca": String,
            "placa": String,
            "situacao": SituacaoCarro
        },
        "cliente": {
            "nome": String,
            "cpf": String,
            "dataNascimento": DateTime,
            "email": String
        },
        "dataInicio": DateTime,
        "precoDia": Double,
        "qtdDias": Integer,
        "precoTotal": Double
        "situacao": SituacaoAluguel
      }
  ]
  
  ```
  
