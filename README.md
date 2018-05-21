The TASK: 

# SchedulingTreatments
Scheduling application in which procedures for treatment of patients performed by doctors are planned.

The application provides an interface for the following operations:
1. Adding patients
2. Scheduling procedures
3. Updating status of procedure

Tasks:
1. Implement database model using hibernate
2. Implement simple web GUI using Spring MVC

Technology constraints:
1. Oracle JDK 8 or OpenJDK
2. Spring Framework
3. Hibernate

Hints:
1. Readability and structure of source code is important, consider clean code best practices
2. Provide code comments and in code documentation where necessary
3. Provide sufficient amount of unit tests for implementation
4. Additional documentation is not required but be prepared for questions regarding design decision during review 
5. It is not required that data is persisted when application is shut down, but it is expected that rooms and doctors are already available after start of the application.
6. Rooms and doctors can be implemented within the code base. No need for exposing creation, update or deletion of rooms and doctors via interface.

AN IMPLEMENTATION : 

How to run: 
you have to have installed maven 3.3.9+ version and JAVA 8 version.

1) Extract files 

2) Start H2 database. Open h2/ folder, and run a run-h2.cmd file there. In the browser can opens an H2 console.
In the web app configured h2 db with name="h2db1", login sa, password sa. 

3) Change a directory to the root of the test, and start to file run-web-app.cmd or execute the command in CMD : mvn spring-boot:run -Drun.jvmArguments="-Drunning.from.maven=true"
