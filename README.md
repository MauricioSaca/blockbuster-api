# blockbuster-api
Spring boot security + JWT + Spring data JPA + PostgreSQL, API project

Prerequisites to test application

  1) Installed Java Jdk 1.8 or higher
  2) Installed maven
  3) Installed any IDE, preferent (Eclipse, Spring Tools or Jboss Developer Studio)
  4) Installed PosgreSql Database
  5) Git (Optional)

Setup the project

  1) Clone or download the project
  2) Install Dependencies with Maven (mvn clean install)
  3) Import project to IDE

Run the project

  1) mvn spring-boot:run
  
Note : Inside the project in the application.properties file, the properties:
  1) spring.jpa.generate-ddl = true
  2) spring.jpa.hibernate.ddl-auto=create-drop
 
Automatically the database is going to be creating with the following connection param:
  
  DATABASE NAME : postgres
  
    1)spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    2)spring.datasource.username=postgres
    3)spring.datasource.password=postgres
