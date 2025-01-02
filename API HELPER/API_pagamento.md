***
## API pagamento

**Insert:** *Post*

``http://localhost:8080/pagamento/insert``

>*Json for Insert*

```
{
    "clienteID": {
        "clienteID": 1
    },
    "data_pagamento": "2024-11-20",
    "valor_pago": 150.75,
    "forma_pagamento": "Cartão de Crédito",
    "status_pagamento": "Concluído"
}

```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/pagamento/update/2``

  *Json for Updating*

```
{
  "valor": 1500.00
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/pagamento/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/pagamento/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/pagamento/find/all``

 

