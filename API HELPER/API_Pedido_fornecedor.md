***
## API Pedido_fornecedor

**Insert:** *Post*

``http://localhost:8080/pedido_fornecedor/insert``

>*Json for Insert*

```
{
  "quantidade": 50,
  "valor": 1500.00,
  "pedido_compra": {
    "ped_compra": 1
  },
  "it_cod": {
    "it_cod": 2
  },
  "estoqueID": {
    "estoqueID": 3
  }
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/pedido_fornecedor/update/2``

  *Json for Updating*

```
{
  "valor": 1500.00
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/pedido_fornecedor/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/pedido_fornecedor/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/pedido_fornecedor/find/all``

 

