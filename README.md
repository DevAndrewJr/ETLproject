# Extract transform load
Data transformation service


##  Enable Remote Connections to SQL Server
To allow remote connections to the SQL Server, follow these steps:

#### 1. Access Instance/Node Properties:
   Use SQL Server Management Studio (SSMS) to connect to the SQL Server.
   Right-click on the desired instance and select "Properties".

#### 2. Enable Remote Connections:
   In the properties dialog, navigate to the "Connections" section.
   Ensure that the "Allow remote connections to this server" checkbox is selected. 
   If it's not already selected, enable it.

#### 3. Apply Changes:
   Click "OK" to confirm the changes and close the properties window.

#### 4. Restart SQL Server Service (optional):
   If necessary, restart the SQL Server service to fully apply the changes.

## Configure Table Field Naming Strategy
By default, Hibernate in Spring Boot uses a table field naming strategy called 
"snake_case". If the table names in the database follow a different convention, 
such as "camelCase", you need to configure Hibernate to use the correct strategy.
To do this, you can specify the desired strategy in the Spring Boot configuration 
file (usually application.properties or application.yml) using one of the following 
properties:

#### properties:
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
Alternatively, if you're using Spring Boot 2.x or later:

#### properties:
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
Make sure to include the appropriate Hibernate dependencies in your project and 
verify that the configuration has taken effect by checking the column names in the 
database after restarting the application.