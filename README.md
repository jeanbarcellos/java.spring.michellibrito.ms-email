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
