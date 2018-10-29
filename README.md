# SMD E-commerce
> Helder Costa  
> Programação para Web I  
> Universidade Federal do Ceará - UFC  
> Docente: [Leonardo Oliveira](http://lattes.cnpq.br/2880668102587861)  

### IDE, Servidor e Banco de Dados
Foi utilizado a IDE **NetBeans** para o desenvolvimento do projeto, juntamente com um servidor (instalado na opção customizada da instalação do NetBeans) **Apache Tomcat** em sua versão 8.0.27.
Além disso, o banco de dados utilizado foi o **PostgreSQL** 11.0 manipulado através da interface do **pgAdmin 4** e usando a biblioteca **PostgreSQL JDBC Driver** na versão 9-4.1209 (deverá ser importado na pasta Libraries, no caso do NetBeans).

Para rodar a aplicação, é preciso que o banco de dados esteja configurado corretamente. Por isso, é necessário rodar o script de banco de dados encontrado [nesse arquivo](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/_database/script_ddl.sql).
E, para setar as configurações de senha e acesso, editar [esse arquivo](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/config/Configuracao.java) com as credenciais corretas.

### Passo a passo para rodar
> 1. Importar projeto no NetBeans.
> 2. Verificar se a biblioteca PostgreSQL JDBC Driver está na pasta Libraries.
> 3. Criar banco de dados e as tabelas através do script encontrado [aqui](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/_database/script_ddl.sql).
> 4. Editar configurações do banco de dados [aqui](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/config/Configuracao.java).
> 5. Rodar o projeto na IDE.

**obs: para entrar com acesso de funcionário (que possui acesso total), é necessário inserir manualmente no banco de dados um usuário. Para isso, basta rodar a seguinte query no pgAdmin**:
```SQL
INSERT INTO funcionario (login, nome, senha, salario) VALUES ('admin', 'administrador', 'admin', 0);
```

<!-- 
    Para saber mais sobre a sintaxe markdown, veja [este guia](https://guides.github.com/features/mastering-markdown/). 
-->