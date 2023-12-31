# PAY-TV: Invoice Service 📺

## :paperclips: Sobre 

O PAY-TV foi desenvolvido durante o curso Back-end Java da [Ada](https://ada.tech/) no módulo "Arquitetura de Software Ágil II".<br>

O projeto inclui a adesão de um pacote de TV, assinatura de pacotes e promoções por tempo determinado,
agendamento de visitas técnicas para instalação de equipamentos ou manutenção, emissão de fatura e pagamento.<br>

O objetivo deste repositório é implementar o Invoice Service - microsserviço responsável pela emissão das faturas para os assinantes dos pacotes de canais da PAY-TV.<br>

## :pushpin: Funcionalidades principais

- Receber informações do microsserviço de [assinatura](https://github.com/Ar3secchim/Channel-Subscription-Service) dos pacotes de TV para gerar a fatura;
- Gerar a fatura com informações do microsserviço de [pacotes de TV](https://github.com/Ar3secchim/Channel-Package-Service);
- Enviar fatura gerada para o microsserviço de [pagamento](https://github.com/fernanda-reis/1037-pagamento) controlar o pagamento.

## :man_technologist: Conhecimentos aplicados
- **Linguagem de Programação:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** PostgreSQL
- **Mensageria:** RabbitMQ
- **Infraestrutura:** Docker
- **Metodologia de Desenvolvimento:** Scrum

## ⚙️ Como Executar
1. Clone o repositório em uma pasta de preferência
  ```
  https://github.com/PAY-TV-Microservices/Invoice-Service
  ```
2. Se necessário, instale as dependências
3. Dentro do projeto, rode 
  ```
  docker-compose up
  ```
4. Visualize a interface da API utilizando o Swagger UI ou outra plataforma de sua preferência <br>
> **Acesso ao Swagger UI** <br>
   Se preferir, você pode explorar e testar os endpoints da API acessando o Swagger UI. <br>
   Certifique-se de que o projeto esteja em execução e acesse a URL abaixo pelo seu navegador: <br>
   http://localhost:8080/swagger-ui/index.html#/

## 🤝 Contratos

#### - ASSINATURA-response-FATURA:
  ```
{
    "userId":"string",
    //LocalDate
    "issueDate": LocalDate,
    [
        {
            "packageId":"string",
        },
        {
            "packageId":"string",
        }
    ],
},
{
    "userId":"string",
    //LocalDate
    "issueDate": 10/02/2023,
    [
        {
            "packageId":"string",
        },
        {
            "packageId":"string",
        }
    ],
}
  ```
#### - FATURA-request-PACOTES:

  ```
[
    {
        "packageId":"string",
    },
    {
        "packageId":"string",
    }
]

  ```
#### - PACOTES-response-FATURA:

  ```
{
    "packageId":"STRING",
    //bigdecimal
    "packageValue": 100,
    //bigdecimal
    "dealValue": 20,
},
{
    "packageId":"STRING",
    //bigdecimal
    "packageValue": 300,
    //bigdecimal
    "dealValue": 50,
}

  ```

#### - FATURA-response-PAGAMENTOS:
  ```
{
    "invoiceId":"string",   
    "userId":"string",
    //LocalDate
    "dueDate": 10/02/2023,
    //bigdecimal
    "totalCost": 200,
},
{
    "invoiceId":"string",
    "userId":"string",
    //LocalDate
    "dueDate": 05/04/2023,
    //bigdecimal
    "totalCost": 400,
}
  ```

> _Os Microsserviços de Fatura e Visita Técnica da PAY-TV foram desenvolvidos por [Dayane](https://github.com/acdayane), [Juliana](https://github.com/julianaando), [Karen](https://github.com/karenCLima), [Natalia](https://github.com/nataliagiacobo), [Raquel](https://github.com/raquelpcarvalho) e [Thaís](https://github.com/tdthais)._
