***
## API cliente_logistica

**Insert:** *Post*

``http://localhost:8080/cliente_logistica/insert``

>*Json for Insert*

```
{
  "cedula": "123456789012",
  "data_entrega": "2024-11-25",
  "nome": "João Silva",
  "genero": "F",
  "data_nascimento": "1990-05-15",
  "email": "joao.silva@email.com",
  "telefone": "555-1234-5678",
  "rua": "Rua Principal",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "provincia": "São Paulo",
  "canton": "SP",
  "distrito": "Centro",
  "codigo_postal":  12345678 ,
  "complemento": "Apto 101",
  "ped_venda": {
    "ped_venda": 1
  }
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/cliente_logistica/update/2``

  *Json for Updating*

```
{
  "nome": "asdada"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/cliente_logistica/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/cliente_logistica/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/cliente_logistica/find/all``

 

