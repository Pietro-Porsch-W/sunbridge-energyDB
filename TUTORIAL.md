# Tutorial para uso do software
> Lembre-se, está em fase de testes e pode apresentar um problema ou outro, e caso o mesmo ocorra, entre em contato com a equipe, que iremos resolver.

---

## Ferramentas necessárias 

* **IDE para o PostGreSQL**: Utilizamos o DBeaver, em conjunto com os drivers necessários para rodar o PostGreSql.
* **IDE para o Java**: Utilizamos o Intellij, em conjunto com o driver Java SDK 17.
* **IDE para o Node.js**: Utilizamos o VSCode, em conjunto com a extensão para [Node.js](https://nodejs.org/pt).

---

## Configuração do Banco

> É necessário ter uma conexão valida com um usuario com todas as permissões dentro do Banco para essa configuração, tal como a porta 5432.

1. Com o DBeaver aberto, abra a pasta ***"Banco_de_Dados"***, [Link no GitHub](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/tree/fcfab2eb26137cd89aff64fe8b76380540928395/Banco_de_dados).
2. Caso queira, crie um banco de dados manualmente com o nome de ***sunbridge*** caso contrario, descomente e rode apenas a ***primeira linha*** do arquivo "Criar_usuario_java", [Link no GitHub](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/Banco_de_dados/Criar_Usuario_Java.sql).
3. Execute o resto do arquivo mencionado acima dentro do banco ***sunbridge*** (tal como todo o resto dos arquivos), para criar o grupo de permissões e usuário utilizado no Java, e dar o grupo para o mesmo.
4. Abra o arquivo ***"Criar_Banco"***, [link no GitHub](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/Banco_de_dados/Criar_banco.sql).
5. Execute ele completo, ele vai criar as tabelas, sequencias, revisar as sequencias para o usuario Java, criar a Auditoria e dar um insert inicial nos dados para testar todo o banco.
6. Pronto, a configuração SQL está pronta.

---

## Configuração do BackEnd (Java)

> É necessário ter uma IDE instalada e configurada para o Java.
> > Existem duas formas, a direta e pelo executavel (***Ainda não implementado***), vou listar ambas.

### De forma direta

1. Abra sua IDE de preferencia, importe o projeto ou abra-o.
2. Abra o POM.XML e instale todas as dependencias.
3. Execute o projeto a partir do [SunBridgeJavaApplication](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/SunBridgeJava/SunBridgeJava-0.0.1-SNAPSHOT.jar), pronto, caso queira desativar ou ativar os Scripts SQL no terminal, acesse o .properties e comente com "#" todas linhas abaixo do titulo **"DEBUG"**.

### Para utilizar o Executavel 
1. Abra o [SunBridgeJava/Executa_java.bat](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/SunBridgeJava/Executa_java.bat).
2. Vai abrir um CMD com o log da aplicação.
3. Pronto, funcionando.
4. Para fechar clique CTRL + C, escreva S e clique enter.

> Para acessar o JavaDoc entre na pasta ***"SunBridgeJava/JavaDoc"***, ou pelo [GitHub]().
> 
> Abra o [INDEX.HTML](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/SunBridgeJava/javadoc/index.html).

---

## Configuração do FrontEnd

> É necessário utilizar o VSCode e ter a extensão para o [Node.js](https://nodejs.org/pt).
>
> Existem 2 métodos, pelo VSCode e direto, ambos precisam do Node instalado.
>
> É necessário que o PowerShell tenha permissão para rodar o NPM pelo VSCode

### Método pelo VSCode

1. Abra o VSCode, vá para a barra superior na opção ***"Terminal"***.
2. Clique em ***"New Terminal"***.
3. Escreva ou cole as seguintes linhas de comandos:
```
cd front
npm install
run npm dev
```
4. Segure Ctrl e clique no Link que aparecer dentro do terminal, que o mesmo vai abrir a pagina correta diretamente no navegador.
5. Tudo pronto para utilização.

### Método Direto

1. Execute o arquivo ***"front/Executa_front.bat"***, [link no GitHub](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/blob/fcfab2eb26137cd89aff64fe8b76380540928395/front/Executa_front.bat). 
2. Segure Ctrl e clique no Link que aparecer no CMD.
3. Para fechar clique CTRL + C, escreva S e clique enter.

---

## Para uso em testes

* Pode utilizar o usuario 1 a 6 com a senha 123, ou acesse a API do usuario e crie um novo, ele vai retornar o ID do seu usuário, então é só usar o ID com a senha informada.
> A senha ***NUNCA*** vai vir por requisição na API.

* Pode acessar a pasta ***API_HELPER*** para todos os links e testes prontos para utilizar todas as APIs existentes e funcionais dentro do sistema BackEnd.
> [Link da pasta API_HELPER no GitHub](https://github.com/Pietro-Porsch-W/sunbridge-energyDB/tree/fcfab2eb26137cd89aff64fe8b76380540928395/API%20HELPER).

 
