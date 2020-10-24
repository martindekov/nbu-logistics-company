# Logistics Company

New Bulgarian University project for logistics company. Details on the requirements can be found in the pdf file in the
repo.

## Set up

Prerequisites:
* Java 8
* IntelliJ

### Lombok

Enable annotation processing so we can use annotations for setters/getters/constructors etc. instead of writing them
ourselves.

For IntelliJ compile successfully Ctrl + Alt + S
1. Install Lombok plugin
2. Restart IDE
3. Ctrl + Alt + S
4. Build, Execution, Deployment | Compiler | Annotation Processors
5. Make sure Enable Annotation Processing is checked
6. Apply OK 

### Styles

The styles used in the project are from bootstrap's [Materia](https://bootswatch.com/materia/). 

### Data Base

For development purposes install [XAMPP](https://www.apachefriends.org/index.html) and start the mysql server.

1. Create database preferably called `logistics_company` or any other
2. Copy application.properties.example located in src/main/resources to application.properties
3. Configure the application.properties to match the credentials to your mysql database and the database name


