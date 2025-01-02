***
## API fornecedor

**Insert:** *Post*

``http://localhost:8080/fornecedor/insert``

>*Json for Insert*

```
{
    "nome": "Fornecedor Exemplo",
    "cedula": "12345678901",
    "telefone": "123456789",
    "rua": "Rua Exemplo",
    "bairro": "Bairro Exemplo",
    "cidade": "Cidade Exemplo",
    "provincia": "Província Exemplo",
    "canton": "Cantão Exemplo",
    "distrito": "Distrito Exemplo",
    "codigo_postal":  12345,
    "complemento": "Complemento Exemplo"
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/fornecedor/update/2``

  *Json for Updating*

```
{
  "nome": "asdada"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/fornecedor/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/fornecedor/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/fornecedor/find/all``

 

