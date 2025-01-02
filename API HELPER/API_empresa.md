***
## API empresa

**Insert:** *Post*

``http://localhost:8080/empresa/insert``

>*Json for Insert*

```
{ 
	"nome": "teste_",
	"websiteURL": "https://www.teste_.com",
	"email": "contato@teste_.com",
	"telefone": "322-1231",
	"cidade": "Cidade teste_",
	"provincia": "Província teste_",
	"data_fundacao": "2000-01-01",
	"cedula_juridica": "33123",
	"setor": "teste_",
	"numero_licenca": "teste_",
	"rua": "Rua teste_",
	"bairro": "teste_",
	"canton": "teste_ A",
	"distrito": "Distrito A",
	"codigo_postal": 12345,
	"complemento": "Prédio Comercial"
}
```
****** 
****** 

**Update:** *Put*

``http://localhost:8080/empresa/update/2``

  *Json for Updating*

```
{
  "nome": "asdada"
}
```
****** 
****** 

**Delete:** *Delete*

``http://localhost:8080/empresa/delete/1``


****** 
******  

**Find By Id:** *Put*

``http://localhost:8080/empresa/find/id/1``

 
****** 
****** 

**Find By All:** *Put*

``http://localhost:8080/empresa/find/all``

 

