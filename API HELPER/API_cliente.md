***
## API cliente

**Insert:** *Post*

``http://localhost:8080/cliente/insert``

>*Json for Insert*

```
{
    "usuarioID": {
        "usuarioID": 1
    },
    "cedula": "12345678901",
    "nome": "João da Silva",
    "data_nascimento": "2010-05-10",
    "genero": "M",
    "email": "joao.silva@email.com",
    "telefone": "555-1111",
    "rua": "Rua A",
    "bairro": "Bairro B",
    "cidade": "Cidade X",
    "provincia": "Província Y",
    "canton": "Cantão Z",
    "distrito": "Distrito W",
    "codigo_postal": 12345,
    "complemento": "Casa 1"
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/cliente/update/2``

  *Json for Updating*

```
{
  "nome": "asdada"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/cliente/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/cliente/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/cliente/find/all``

 

