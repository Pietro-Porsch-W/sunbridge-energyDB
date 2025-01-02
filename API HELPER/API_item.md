***
## API item

**Insert:** *Post*

``http://localhost:8080/item/insert``

>*Json for Insert*

```
{
    "nome": "Produto Exemplo",
    "descricao": "Descrição detalhada do produto exemplo",
    "quantidade": 50,
    "valor": 19.99,
    "categoria": "Eletrônicos",
    "estoqueID": {
        "estoqueID": 1
    }
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/item/update/2``

  *Json for Updating*

```
{
  "quantidade": 31
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/item/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/item/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/item/find/all``

 

