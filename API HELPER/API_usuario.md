***
## API USUARIO
**Login:** *Post*

``http://localhost:8080/usuario/login``

>*Json for login*

```
{
  "usuarioID": 1,
  "senha": "123"
}
```

****** 
****** 

**Insert:** *Post*

``http://localhost:8080/usuario/insert``

>*Json for Insert*

```
{
    "usuarioID_FK": { 
        "usuarioID": 2
    },
    "companyID": { 
        "companyID": 1
    },
    "nome": "João da Silva",
    "genero": "F",
    "data_entrada": "2023-01-15",
    "tipo": 1,
    "cedula": "12345678901",
    "data_nascimento": "1990-05-09",
    "departamento": "Vendas",
    "data_admissao": "2023-02-01",
    "salario": 3500.00,
    "ativo": true,
    "telefone": "555-1234",
    "email": "joao.silva@example.com",
    "senha": "senhaSegura123",
    "rua": "Rua das Flores",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "canton": "São Paulo",
    "distrito": "Central",
    "codigo_postal": 12345678,
    "complemento": "Apto 101"
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/usuario/update/2``

>*Json for Updating*

```
{
    "nome": "Pietro P. Wilhelms",
    "telefone": "3838-000",
    "email": "pietro@sunbridge.com"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/usuario/delete/1``


****** 
****** 

**Find By Name:** *Put*

``http://localhost:8080/usuario/find/name/pietro``

 
****** 
****** 

**Find By Id:** *Put*

``http://localhost:8080/usuario/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/usuario/find/all``

 

