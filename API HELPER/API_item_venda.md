***
## API item_venda

**Insert:** *Post*

``http://localhost:8080/item_venda/insert``

>*Json for Insert*

```
{
    "ped_venda": {
        "ped_venda": 1
    },
    "quantidade": 5,
    "valor_prod": 99.99,
    "descricao": "Produto de alta qualidade",
    "marca": "Marca X",
    "garantia": 12,
    "composicao": "Plástico e metal",
    "origem": "Brasil",
    "it_cod": {
        "it_cod": 1
    }
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/item_venda/update/2``

  *Json for Updating*

```
{
  "quantidade": 31
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/item_venda/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/item_venda/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/item_venda/find/all``

 

