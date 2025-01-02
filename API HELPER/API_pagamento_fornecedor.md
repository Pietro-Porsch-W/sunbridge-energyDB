***
## API pagamento_fornecedor

**Insert:** *Post*

``http://localhost:8080/pagamento_fornecedor/insert``

>*Json for Insert*

```
{
  "data_pagamento": "2023-11-20",
  "valor": 2500.00,
  "forma_pagamento": "Transferência a"
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/pagamento_fornecedor/update/2``

  *Json for Updating*

```
{
  "valor": 1500.00
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/pagamento_fornecedor/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/pagamento_fornecedor/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/pagamento_fornecedor/find/all``

 

