***
## API Pedido_venda

**Insert:** *Post*

``http://localhost:8080/pedido_venda/insert``

>*Json for Insert*

```
{
  "clienteID": {
    "clienteID": 1
  },
  "data_venda": "2024-11-25",
  "data_instalacao": "2024-11-30",
  "valor": 5000.75,
  "desconto": 250.50
}

```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/pedido_venda/update/2``

>*Json for Updating*

```
{ 
	"desconto": 250.50
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/pedido_venda/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/pedido_venda/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/pedido_venda/find/all``

 

