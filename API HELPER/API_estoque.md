***
## API estoque

**Insert:** *Post*

``http://localhost:8080/estoque/insert``

>*Json for Insert*

```
{
  "rua": "Rua das Flores",
  "prateleira": "Prateleira A1",
  "peso": 25,
  "data_entrada": "2024-11-20",
  "data_saida": "2024-12-01",
  "valor_compra": 100.50,
  "valor_venda": 150.75
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/estoque/update/2``

  *Json for Updating*

```
{
  "rua": "asdada"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/estoque/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/estoque/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/estoque/find/all``

 

