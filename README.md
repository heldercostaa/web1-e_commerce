# SMD E-commerce
> Helder Costa (github/linkedin: heldercostaa)  
> Programação para Web I  
> Universidade Federal do Ceará - UFC  
> Docente: [Leonardo Oliveira](http://lattes.cnpq.br/2880668102587861)  

### IDE, Server, and Data Base
It was used the IDE **NetBeans** to develop this project, along with a server (installed with the custom settings in NetBeans installation) **Apache Tomcat** in version 8.0.27.
Besides that, the database used was **PostgreSQL** 11.0 manipulated through **pgAdmin 4** and using **PostgreSQL JDBC Driver** library version 9-4.1209 (must be imported in Libraries folder, in NetBeans case).  

To run the application, the database must be configured correctly. Therefore, it's necessary to run the database script found on  [this file](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/_database/script_ddl.sql).
And, to set an access login and password, edit [this file](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/config/Configuracao.java) with the correct credentials.  

### Step by Step to run
> 1. Import the project in NetBeans.
> 2. Check if PostgreSQL JDBC Driver library is in the Libraries folder.
> 3. Create the database and tables through the script found [here](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/_database/script_ddl.sql).
> 4. Edit database settings [here](https://github.com/heldercostaa/web1-e_commerce/blob/master/src/java/config/Configuracao.java).
> 5. Run the project with the IDE.  

**obs: to enter with functionary access (with access to all functionalities), it's necessary to manually insert a user in the database. To do that just run the following query in pgAdmin**:
```SQL
INSERT INTO funcionario (login, nome, senha, salario) VALUES ('admin', 'administrador', 'admin', 0);
```