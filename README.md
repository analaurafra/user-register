# User Register Service 🚀

Uma aplicação Spring Boot para gerenciamento de registro de usuários com operações CRUD completas.

## 📋 Descrição

O **User Register** é um serviço de API REST desenvolvido em **Java 21** com **Spring Boot 3.3.4** que oferece operações básicas de gerenciamento de usuários, incluindo criar, ler, atualizar e deletar registros. O projeto utiliza banco de dados em memória **H2** e segue padrões de arquitetura limpa com separação de responsabilidades.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: 21
- **Spring Boot**: 3.3.4
- **Spring Data JPA**: Para persistência de dados
- **H2 Database**: Banco de dados em memória
- **Lombok**: Para reduzir boilerplate de código
- **Maven**: Gerenciador de dependências
- **JUnit 5**: Framework de testes

---

## 📁 Estrutura do Projeto

```
user-register/
├── src/
│   ├── main/
│   │   ├── java/com/indomita/user_register/
│   │   │   ├── UserRegisterApplication.java      # Classe principal
│   │   │   ├── controller/
│   │   │   │   └── UsuarioController.java        # Endpoints REST
│   │   │   ├── business/
│   │   │   │   └── UsuarioService.java           # Lógica de negócio
│   │   │   └── infrastructure/
│   │   │       ├── entitys/
│   │   │       │   └── Usuario.java              # Entidade JPA
│   │   │       └── repository/
│   │   │           └── UsuarioRepository.java    # Acesso a dados
│   │   └── resources/
│   │       └── application.properties            # Configurações
│   └── test/
│       └── java/com/indomita/user_register/
│           └── UserRegisterApplicationTests.java
├── pom.xml                                        # Dependências Maven
└── README.md

```

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 21 ou superior
- Maven 3.6+

### Passos para rodar a aplicação

1. **Clone o repositório**
   ```bash
   git clone https://github.com/analaurafra/user-register.git
   cd user-register
   ```

2. **Compile o projeto**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **A aplicação estará disponível em:**
   - **API**: `http://localhost:8081`
   - **H2 Console**: `http://localhost:8081/h2-console`

---

## 📊 Acessando o H2 Console

O H2 Console permite visualizar e gerenciar o banco de dados em memória:

1. Acesse: **[http://localhost:8081/h2-console](http://localhost:8081/h2-console)**
2. Configure as credenciais:
   - **JDBC URL**: `jdbc:h2:mem:usuarios`
   - **User Name**: `sa`
   - **Password**: (deixe em branco)
3. Clique em **Connect**

---

## 🔌 Endpoints da API

### 1. **POST - Salvar Usuário**
Cria um novo usuário no banco de dados.

**Endpoint:**
```
POST http://localhost:8081/usuario
```

**Headers:**
```
Content-Type: application/json
```

**Body:**
```json
{
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

**Resposta (200 OK):**
```
Status: 200 OK
Body: (vazio)
```

---

### 2. **GET - Buscar Usuário por Email**
Retorna um usuário específico com base no email.

**Endpoint:**
```
GET http://localhost:8081/usuario?email=joao@example.com
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

**Resposta (404 Not Found):**
```json
{
  "message": "Email não encontrado"
}
```

---

### 3. **PUT - Atualizar Usuário**
Atualiza um usuário existente pelo ID (atualiza apenas os campos fornecidos).

**Endpoint:**
```
PUT http://localhost:8081/usuario?id=1
```

**Headers:**
```
Content-Type: application/json
```

**Body:**
```json
{
  "nome": "João Silva Santos",
  "email": "joao.silva@example.com"
}
```

**Resposta (200 OK):**
```
Status: 200 OK
Body: (vazio)
```

---

### 4. **DELETE - Deletar Usuário**
Remove um usuário do banco de dados pelo email.

**Endpoint:**
```
DELETE http://localhost:8081/usuario?email=joao@example.com
```

**Resposta (200 OK):**
```
Status: 200 OK
Body: (vazio)
```

---

## 🧪 Exemplos de Testes no Insomnia

### Passo 1: Importar no Insomnia

Copie e importe a seguinte coleção no Insomnia (Menu → Import):

```json
{
  "_type": "export",
  "__export_format": 4,
  "__export_date": "2024-09-30T00:00:00.000Z",
  "__export_app": "Insomnia",
  "__export_version": 4,
  "resources": [
    {
      "_id": "wrk_userregister",
      "_type": "workspace",
      "name": "User Register API",
      "description": "Testes da API de Registro de Usuários"
    },
    {
      "_id": "env_base",
      "_type": "environment",
      "parentId": "wrk_userregister",
      "name": "Base Environment",
      "data": {
        "base_url": "http://localhost:8081",
        "h2_console": "http://localhost:8081/h2-console"
      }
    },
    {
      "_id": "req_create_user",
      "_type": "request",
      "parentId": "wrk_userregister",
      "name": "POST - Criar Usuário",
      "method": "POST",
      "url": "{{ base_url }}/usuario",
      "headers": [
        {
          "name": "Content-Type",
          "value": "application/json"
        }
      ],
      "body": {
        "mimeType": "application/json",
        "text": "{\"nome\": \"Maria Silva\", \"email\": \"maria.silva@example.com\"}"
      }
    },
    {
      "_id": "req_get_user",
      "_type": "request",
      "parentId": "wrk_userregister",
      "name": "GET - Buscar Usuário por Email",
      "method": "GET",
      "url": "{{ base_url }}/usuario?email=maria.silva@example.com"
    },
    {
      "_id": "req_update_user",
      "_type": "request",
      "parentId": "wrk_userregister",
      "name": "PUT - Atualizar Usuário",
      "method": "PUT",
      "url": "{{ base_url }}/usuario?id=1",
      "headers": [
        {
          "name": "Content-Type",
          "value": "application/json"
        }
      ],
      "body": {
        "mimeType": "application/json",
        "text": "{\"nome\": \"Maria Silva Santos\", \"email\": \"maria.santos@example.com\"}"
      }
    },
    {
      "_id": "req_delete_user",
      "_type": "request",
      "parentId": "wrk_userregister",
      "name": "DELETE - Deletar Usuário",
      "method": "DELETE",
      "url": "{{ base_url }}/usuario?email=maria.silva@example.com"
    }
  ]
}
```

### Passo 2: Executar Testes Sequencialmente

#### 1️⃣ **Criar Usuário (POST)**

```
POST http://localhost:8081/usuario
Content-Type: application/json

{
  "nome": "Ana Costa",
  "email": "ana.costa@example.com"
}
```

**Resposta esperada:**
```
Status: 200 OK
```

---

#### 2️⃣ **Buscar Usuário (GET)**

```
GET http://localhost:8081/usuario?email=ana.costa@example.com
```

**Resposta esperada:**
```json
{
  "id": 1,
  "nome": "Ana Costa",
  "email": "ana.costa@example.com"
}
```

---

#### 3️⃣ **Atualizar Usuário (PUT)**

```
PUT http://localhost:8081/usuario?id=1
Content-Type: application/json

{
  "nome": "Ana Costa Silva",
  "email": "ana.silva@example.com"
}
```

**Resposta esperada:**
```
Status: 200 OK
```

---

#### 4️⃣ **Deletar Usuário (DELETE)**

```
DELETE http://localhost:8081/usuario?email=ana.silva@example.com
```

**Resposta esperada:**
```
Status: 200 OK
```

---

## 📝 Entidade Usuario

```java
@Entity
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "name")
    private String nome;
}
```

**Validações:**
- ✅ Email é único (constraint UNIQUE)
- ✅ ID é gerado automaticamente
- ✅ Nome e email são obrigatórios

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller (REST)
    ↓
Service (Lógica de Negócio)
    ↓
Repository (Acesso a Dados / JPA)
    ↓
Entity (Modelo de Banco de Dados / H2)
```

### Camadas:

- **Controller**: Recebe requisições HTTP e retorna respostas
- **Service**: Contém a lógica de negócio e validações
- **Repository**: Interface JPA para acesso ao banco de dados
- **Entity**: Representa a tabela no banco de dados

---

## 🔍 Exemplo de Fluxo Completo

1. **Cliente envia POST** com dados do usuário
2. **UsuarioController** recebe a requisição
3. **UsuarioService** valida e processa os dados
4. **UsuarioRepository** persiste no H2
5. **Resposta 200 OK** é retornada ao cliente

---

## 📚 Dependências Principais

| Dependência | Versão | Descrição |
|---|---|---|
| spring-boot-starter-web | 3.3.4 | API REST |
| spring-boot-starter-data-jpa | 3.3.4 | ORM Hibernate |
| h2 | - | Banco de dados em memória |
| lombok | - | Reduz boilerplate |
| spring-boot-starter-test | 3.3.4 | Testes unitários |

---

## 🧪 Rodando os Testes

```bash
# Executar todos os testes
mvn test

# Executar teste específico
mvn test -Dtest=UserRegisterApplicationTests
```

---

## 📖 Configurações (application.properties)

```properties
spring.application.name=user-register
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:usuarios
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

server.port=8081
```

---

## 🐛 Tratamento de Erros

A aplicação lança exceções personalizadas:

| Erro | Cenário |
|---|---|
| `RuntimeException: "Email não encontrado"` | GET com email inexistente |
| `RuntimeException: "Usuario Não Encontrado"` | PUT com ID inexistente |
| `DataIntegrityViolationException` | Email duplicado |

---

## 💡 Melhorias Futuras

- [ ] Implementar DTOs para melhor transferência de dados
- [ ] Adicionar validações com `@Valid` e `@NotNull`
- [ ] Implementar tratamento global de exceções (ExceptionHandler)
- [ ] Adicionar autenticação e autorização
- [ ] Criar testes de integração completos
- [ ] Implementar logging detalhado
- [ ] Adicionar documentação Swagger/OpenAPI
- [ ] Migrar para banco de dados produtivo (PostgreSQL/MySQL)

---

## 👥 Autor

- **Ana Laura** - [GitHub](https://github.com/analaurafra)

---

## 📄 Licença

Este projeto é de uso pessoal e educacional.

---

## 🔗 Links Úteis

- 🔧 **H2 Console**: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)
- 📚 **Spring Boot Docs**: [spring.io](https://spring.io)
- 🗄️ **H2 Database**: [h2database.com](http://h2database.com)
- 🧪 **Insomnia**: [insomnia.rest](https://insomnia.rest)
- 📚 **Referências:** [javanauta.youtube](https://insomnia.rest)](https://www.youtube.com/watch?v=yW7RrWfUeHE)

---

**Desenvolvido com ❤️ em Java**
