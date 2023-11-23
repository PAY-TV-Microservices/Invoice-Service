# Invoice-Service
Microsserviço responsável pela emissão das faturas para os assinantes dos pacotes de canais.

## Contratos
### ASSINATURA-response-FATURA
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

### FATURA-request-PACOTES:
[
    {
        "packageId":"string",
    },
    {
        "packageId":"string",
    }
]

### PACOTES-response-FATURA:
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

### FATURA-response-PAGAMENTOS:
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


TODO

