# Documentação Técnica da API Locadao

## Introdução

A API Locadao permite o gerenciamento de locações de veículos. 
Este documento fornece informações detalhadas sobre como interagir com a API para criar, recuperar, atualizar e excluir registros de veículos, clientes e locações.

## Endpoints

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

### Locações

... [outros endpoints de locações]

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

- `404 Not Found`: O recurso solicitado não foi encontrado.
- `400 Bad Request`: A solicitação não pode ser processada devido a erros de sintaxe ou parâmetros inválidos.
- `500 Internal Server Error`: Ocorreu um erro no servidor.

## Contato

Para mais informações ou suporte, entre em contato pelo email suporte@locadao.com.br.

