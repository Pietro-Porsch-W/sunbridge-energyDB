***
## API Pedido_compra

**Insert:** *Post*

``http://localhost:8080/pedido_compra/insert``

>*Json for Insert*

```
{
  "data_compra": "2023-11-20",
  "data_entrega": "2023-11-30",
  "valor": 5000.00,
  "desconto": 500.00,
  "usuarioID": {
    "usuarioID": 1
  },
  "fornecedorID": {
    "fornecedorID": 1
  },
  "pagamento_fornecedorID": {
    "pagamento_fornecedorID": 1
  }
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/pedido_compra/update/2``

  *Json for Updating*

```
{
  "valor": 1500.00
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/pedido_compra/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/pedido_compra/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/pedido_compra/find/all``

 

