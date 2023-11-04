# Documentação Técnica da API Locadao

## Introdução

A API Locadao permite o gerenciamento de locações de veículos. 
Este documento fornece informações detalhadas sobre como interagir com a API para criar, recuperar, atualizar e excluir registros de veículos, clientes e locações.

## Endpoints
![Screenshot_2](https://github.com/jcr04/Locadao.java/assets/70778525/569b69f6-ad51-4f53-877f-e65dcb12eb58)

### Veículos

- **Listar Veículos**
  - Método: `GET`
  - Endpoint: `/veiculos`
  - Resposta: Uma lista de objetos representando os veículos.

- **Obter Veículo**
  - Método: `GET`
  - Endpoint: `/veiculos/{id}`
  - Parâmetros: `id` (ID do veículo)
  - Resposta: Objeto representando o veículo.

- **Cadastrar Veículo**
  - Método: `POST`
  - Endpoint: `/veiculos`
  - Corpo da Requisição: 
    ```json
    {
        "marca": "string",
        "modelo": "string",
        "ano": "integer",
        "precoDiaria": "float"
    }
    ```

- **Excluir Veículo**
  - Método: `DELETE`
  - Endpoint: `/veiculos/{id}`
  - Parâmetros: `id` (ID do veículo)

- **Alugar Veículo**
  - Método: `POST`
  - Endpoint: `/veiculos/{veiculoId}/alugar/{clienteId}`
  - Parâmetros: `veiculoId` (ID do veículo), `clienteId` (ID do cliente)
  - Exemplo de URL: `http://localhost:8081/veiculos/1/alugar/1`
  - Resposta de Exedmplo:
    ```json
    {
    "id": 8,
    "marca": "Fiat",
    "modelo": "Argo",
    "placa": "dec-1847",
    "ano": 2023,
    "precoDiaria": 150.0,
    "alugado": true,
    "cliente": {
        "id": 5,
        "nome": "Pedriana Pavão",
        "cpf": "323.276.389-22",
        "dataNascimento": "1987-07-28",
        "endereco": "Rua José Maria Santiago, 505, Centro, São José de Ribamar",
        "idade": 36,
        "cnh": true,
        "veiculos": [
            8
        ]
    },
    "locacoes": []
    }
    ```



### Clientes

- **Listar Clientes**
  - Método: `GET`
  - Endpoint: `/clientes`
  - Resposta: Uma lista de objetos representando os clientes.

- **Obter Cliente**
  - Método: `GET`
  - Endpoint: `/clientes/{id}`
  - Parâmetros: `id` (ID do cliente)
  - Resposta: Objeto representando o cliente.

- **Cadastrar Cliente**
  - Método: `POST`
  - Endpoint: `/clientes`
  - Corpo da Requisição: 
    ```json
    {
        "nome": "string",
        "cpf": "string",
        "dataNascimento": "string",
        "endereco": "string"
    }
    ```

- **Atualizar Cliente**
  - Método: `PUT`
  - Endpoint: `/clientes/{id}`
  - Parâmetros: `id` (ID do cliente)
  - Corpo da Requisição: 
    ```json
    {
        "nome": "string",
        "cpf": "string",
        "dataNascimento": "string",
        "endereco": "string"
    }
    ```

- **Excluir Cliente**
  - Método: `DELETE`
  - Endpoint: `/clientes/{id}`
  - Parâmetros: `id` (ID do cliente)


### Locações

- **Listar Locações**
  - Método: `GET`
  - Endpoint: `/locacoes`
  - Resposta: Uma lista de objetos representando as locações.

- **Obter Locação**
  - Método: `GET`
  - Endpoint: `/locacoes/{id}`
  - Parâmetros: `id` (ID da locação)
  - Resposta: Objeto representando a locação.

- **Cadastrar Locação**
  - Método: `POST`
  - Endpoint: `/locacoes`
  - Corpo da Requisição: 
    ```json
    {
        "veiculoId": "integer",
        "dataInicio": "string",
        "dataFim": "string",
        "valorTotal": "float"
    }
    ```

- **Atualizar Locação**
  - Método: `PUT`
  - Endpoint: `/locacoes/{id}`
  - Parâmetros: `id` (ID da locação)
  - Corpo da Requisição: 
    ```json
    {
        "dataInicio": "string",
        "dataFim": "string",
        "valorTotal": "float"
    }
    ```

- **Excluir Locação**
  - Método: `DELETE`
  - Endpoint: `/locacoes/{id}`
  - Parâmetros: `id` (ID da locação)
ts de clientes]

## Erros Comuns

- `200 OK`: A requisição foi bem-sucedida.
- `201 Created`: Um novo recurso foi criado com sucesso.
- `204 No Content`: A requisição foi bem-sucedida, mas não há conteúdo para ser enviado na resposta.
- `400 Bad Request`: A solicitação não pode ser processada devido a erros de sintaxe ou parâmetros inválidos.
- `401 Unauthorized`: O cliente não está autenticado.
- `403 Forbidden`: O cliente não tem permissão para acessar o recurso.
- `404 Not Found`: O recurso solicitado não foi encontrado.
- `405 Method Not Allowed`: O método HTTP usado não é suportado para o recurso solicitado.
- `415 Unsupported Media Type`: O tipo de mídia da requisição não é suportado pelo servidor.
- `422 Unprocessable Entity`: O servidor entende a sintaxe da requisição, mas não foi possível processá-la devido a erros semânticos.
- `429 Too Many Requests`: O cliente enviou muitas requisições em um determinado período de tempo.
- `500 Internal Server Error`: Ocorreu um erro no servidor.
- `503 Service Unavailable`: O servidor não está disponível no momento.

### Exceções Personalizadas

- `VeiculoNotFoundException`: Lançada quando um veículo solicitado não é encontrado.
- `ClienteNotFoundException`: Lançada quando um cliente solicitado não é encontrado.
- `LocacaoNotFoundException`: Lançada quando uma locação solicitada não é encontrado.
- `InvalidParameterException`: Lançada quando um parâmetro inválido é fornecido.
- `DatabaseException`: Lançada quando ocorre um erro ao interagir com o banco de dados.




