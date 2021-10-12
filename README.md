_Repositório apenas para estudo_

# Microservice Send Email

Desenvolvimento de um micro-serviço de envio de e-mails usanto Java Spring

Instrutor:

- [Michelli Brito](https://www.youtube.com/channel/UC2WbG8UgpPaLcFSNJYwtPow)

Referências:

- https://github.com/MichelliBrito/ms-email
- [Vídeo 1 - Overview Completo](https://www.youtube.com/watch?v=LW-N44fZ1wk)
- [Vídeo 2 - Criando um microservice de envio de email](https://www.youtube.com/watch?v=ZBleZzJf6ro)
- [Vídeo 3 - Comunicação Assíncrona entre microservices](https://www.youtube.com/watch?v=V-PqR0BxA8c)
- [Vídeo 4 - Arquitetura hexagonal em microservices na prática - Parte 1](https://www.youtube.com/watch?v=UmdOjbyYOX0)
- [Vídeo 5 - Arquitetura hexagonal em microservices na prática - Parte 2](https://www.youtube.com/watch?v=rpCXNOEMVXk)

<br>
<br>

## Overview Completo

### **Microservices - A arquitetra de Software moderna**

- Microservice nada mais é do que um aplicação que vai trabalhar de forma autônoma e independente.
- Porém um microservice não é executado sozinho.
- Geralmente em arquitetura de microserviços você tem vários microservices trabalhando de forma independente um dos outros Mas eles se comunicam internamente.
- Eles não ficam isolados, eles fazem essa comunicação interna quando é necessário.

**Tipos de comunicação entre microservices**

- Processsos Síncrosos
  - HTTP com API REST para comunicações internas entre os microservices
- Processos Assíncronos
  - Mensageria (Message broker)
    - Apache Kafka
    - Rabbit MQ

### **Arquitetura de Microservices**

![Arqtuitetura](https://raw.githubusercontent.com/jeanbarcellos/java.spring.michellibrito.ms-email/master/docs/img/video-01%20-%2005.JPG)

- Serviços base para compor a aruitetura. Também não microservices, mas não de regras de negócio.

  - monitoramento
  - gerenciamento de log,
  - configuração,
  - registro descoberta,
  - gateway para centralizar todas as entradas

  Exemplos:

  - API Gateway
  - Service Registry
  - Circuit Breaker
  - Config Server
  - Sleuth

#### Serviços base para os demais microservices

- **API Gateway**

  - Centralizar todas as entradas
  - Roteamento e filtros
  - Integra o balanceamento de carga (Spring Cloud Load Balancer)
  - Intergra serviços de descoberat
  - Segurança / Autenticação
  - Implmementações:
    - `Spring Cloud Gateway`
    - `Netflix Zuul` _(recebendo poucas atualizações / descontinuado)_

- **Service Registry / Discovery**

  - Registrar os microservices para que os mesmos sejam 'descobertos' assim que solicitados.
  - Implementações
    - `Spring Cloud Netflix Eureka`
    - `Spring Clound Consul`

- **Circuit Breaker**

  - Adicionado e implementado em chamadas de métodos com alto potencial de latência e falhas
  - Mitigar falhas em cascatas
  - Métodos Fallback durante falhas
  - `Histrix` era a implementação padrão de Circuit Breacker _(Netflix Histrix)_
  - Spring Cloud Circuit Breaker:
    - `Netflix Hystrix` _(recebendo poucas atualizações)_
    - `Resilience4J` _(mais utilizado)_
    - `Sentinel`
    - `Circuit Breaker (TAS)`

- **Config Server**

  - Git para armazenamento de configurações
  - Spring Cloud Config:
    - `Spring Cloud Config Server`
    - `Spring Cloud Config Client`

- **Log - Spring Cloud Sleuth**

  - Rastreamento (tracing distribuido)
  - Adiciona identificadores em cada logo
  - 2 tipos de indentificadores:
    - Trace ID: único entre todas as chamadas
    - Span ID: individual para cada chamada
  - `Spring Cloud Sleuth`
  - `Zipkin`

- **Spring Cloud Stream**

  - Mensagerias
  - Processos assíncronos e orientado a eventos
  - `RabbitMQ`
  - `Apache Kafka`

### JHipster - microservices com java

- Plataforma para iniciar, implementar e implantar arquitetura de microservices com JAVA
- Traz "pronto"
  - Back-end
    - Spring Boot
    - Micronaut
    - Quarkus
  - Front-end
    - Vue
    - React
    - Angular
  - Banco de Dados
    - Oracle
    - PostgreSQL
    - SQL Server
    - Mongo DB
    - Elasticsearch
  - Clouds
    - AWS
    - Docker
    - Kubernets
    - Google Cloud
    - Heroku

<br>
<br>
<br>

## Anotações

**Spring Initializr**

- https://start.spring.io/

**Endpoints**

- Enviar e-mail

  ```
  [POST] http://localhost:8080/send-email
  ```

  Body

  ```json
  {
    "emailFrom": "email.remetente@gmail.com",
    "emailTo": "email.destinatário@hotmail.com",
    "subject": "Teste envio de e-mail via REST usando Spring",
    "text": "Olá, fulano.\nEste é apenas um teste de envio de e-mail via REST!"
  }
  ```

- Listar e-mails

  ```
  [GET] http://localhost:8080/emails
  ```

- Detalhes de um e-mail

  ```
  [GET] http://localhost:8080/emails/{{emailId}}
  ```

**Json para envio de e-mail via REST**

```json
{
  "emailFrom": "**************@gmail.com",
  "emailTo": "**************@hotmail.com",
  "subject": "Teste envio de e-mail via REST usando Spring",
  "text": "Olá, fulano.\nEste é apenas um teste de envio de e-mail via REST!"
}
```

**Json para envio de e-mail VIA FILA**

```json
{
  "emailFrom": "**************@gmail.com",
  "emailTo": "**************@hotmail.com",
  "subject": "Teste envio de e-mail via QUEUE usando Spring",
  "text": "Olá, fulano.\nEste é apenas um teste de envio de e-mail via QUEUE!"
}
```
