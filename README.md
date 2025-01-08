# Job Development

**Gerencie vagas e candidatos de forma simples e eficiente.**

Este projeto é uma aplicação backend desenvolvida em Java com Spring Boot. Ele permite o gerenciamento de vagas, candidatos e empresas, com autenticação, documentação de APIs via Swagger e persistência de dados utilizando PostgreSQL.

## Requisitos do Sistema

- **Java**: Versão 17 ou superior
- **Maven**: Versão 3.6.0 ou superior
- **PostgreSQL**: Versão 12 ou superior

## Configuração do Projeto

### Clonar o Repositório

```bash
git clone <url-do-repositorio>
cd job-development
```

### Configurar o Banco de Dados

Se você está utilizando o Docker, siga os passos abaixo para configurar o banco de dados:

1. Certifique-se de que o Docker está instalado e em execução.
2. Suba o container do PostgreSQL utilizando o arquivo `docker-compose.yml`:

```yaml
services:
  postgres:
    container_name: job-management-postgres
    image: postgres
    ports:
      - 5432:5432
    environment:
      - POSTGRES_USER=sexta
      - POSTGRES_PASSWORD=feira
      - POSTGRES_DB=job_management
```

3. Inicie o serviço:

```bash
docker-compose up -d
```

Se você não estiver utilizando Docker:

1. Certifique-se de que o PostgreSQL está instalado e em execução.
2. Crie um banco de dados para o projeto:

```sql
CREATE DATABASE job_development;
```

3. Atualize o arquivo `application.properties` ou `application.yml` com as credenciais do banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/job_development
spring.datasource.username=<seu-usuario>
spring.datasource.password=<sua-senha>
```

### Instalar Dependências

Rode o seguinte comando para instalar todas as dependências do projeto:

```bash
mvn clean install
```

### Executar o Projeto

Inicie a aplicação utilizando o comando:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

## Documentação da API

A documentação interativa da API pode ser acessada através do Swagger UI:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Dependências Principais

- **Spring Boot**:
  - `spring-boot-starter-web`: Para criação de endpoints REST.
  - `spring-boot-starter-validation`: Para validação de dados.
  - `spring-boot-starter-data-jpa`: Para integração com o banco de dados.
  - `spring-boot-starter-security`: Para controle de autenticação e segurança.
  - `spring-boot-devtools`: Para hot reload durante o desenvolvimento.
- **PostgreSQL**:
  - Driver de conexão com o banco de dados.
- **Springdoc OpenAPI**:
  - `springdoc-openapi-starter-webmvc-ui`: Para documentação e teste da API.
- **Lombok**: Para reduzir boilerplate code no Java.
- **Auth0 Java JWT**: Para manipulação de tokens JWT.

## Testes

Para executar os testes, utilize o comando:

```bash
mvn test
```

## Licença

Este projeto está licenciado sob a [licença MIT](LICENSE).

## Autor

Desenvolvido por [JotahDev](https://github.com/jotahdev).

