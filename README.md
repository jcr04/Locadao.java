# API Locadao

A API Locadao é um sistema para gerenciamento de locações de veículos. Com ela, é possível cadastrar veículos, clientes e registrar locações. Além disso, oferece funcionalidades para consulta e exclusão dessas informações.

## Funcionalidades

- **Cadastro de Veículos**: Permite o cadastro de veículos disponíveis para locação.
- **Cadastro de Clientes**: Permite o cadastro de clientes que podem alugar veículos.
- **Registro de Locações**: Permite o registro de locações associando um veículo a um cliente por um período determinado.
- **Consulta de Locações**: Oferece a possibilidade de consultar as locações efetuadas.
- **Exclusão de Registros**: Permite a exclusão de veículos, clientes e locações.

## Como Utilizar

Para utilizar a API, é necessário fazer requisições HTTP para os endpoints disponíveis. Por exemplo, para cadastrar um novo veículo, faça uma requisição POST para `/veiculos` com o corpo da requisição contendo as informações do veículo.

- crie um databse no postman chamado locacao e no seu arquivo
- **application.properties** coloque o seguinte
```batch
spring.datasource.url=jdbc:postgresql://localhost:5432/locadao
spring.datasource.username=postgres
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
debug=true
server.port=8081
spring.jpa.show-sql=true
```

### Exemplo de Requisição
![Screenshot_1](https://github.com/jcr04/Locadao.java/assets/70778525/1018cba6-b5a3-4b9f-a4d0-e7d7c6d7644f)

Para mais informações sobre como utilizar a API, consulte a documentação completa disponível em [Codedoc](https://github.com/jcr04/Locadao.java/blob/main/Codedoc.md).

