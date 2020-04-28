# Boggle Game
This is a simple demonstration of the Boggle game using Angular 6 Material on client-side and Java Spring boot application on the server side. Before we begin the set-up process first Git clone the project repository from https://github.com/ashish-bista-hub/boggle-new.git
### Client
* Pre-requisite for local development environment
    * Node.js must be installed, for more info https://nodejs.org/en/
    * Verify node package manager is also installed
    * Install Angular CLI - **npm install -g @angular/cli**
* To run the application
    * Open your favorite terminal and navigate inside the boggle client directory for e.g. cd boggle/client
    * first install the dependencies - **npm install**
    * execute the command - **npm start**
    * Open the browser and hit the url http://localhost:4200
FYI - The server should be running in order to load game 4 x 4 board
### API
* Pre-requisite for local development environment
    * Java 8 must be installed - **Mandatory** - To download visit https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html
    * Maven for dependency management - **Optional** - To download visit https://maven.apache.org/download.cgi

Please note that after installation both of these should be added to the enviornment variables path
* To check Java is installed - execute **java -version**
* To check Maven is installed - execute **mvn -v**

##### If you just want to run the API without local build then
* Open the terminal and navigate to cd api/executables
* execute the command **java -jar boggle-0.0.1-SNAPSHOT.jar**
* Once you see the message **"application started on Port 7080"** then
* Open the browser and hit url http://localhost:7080
* If you see the message Spring boot then your API is successfully started
* hit url http://localhost:7080/api/v1/boggle
* If you want to exceute API then hit url http://localhost:7080/swagger-ui.html

Note: This process does not require maven to be installed

##### If you want to build the API locally then
* Open the terminal and navigate to cd api
* Then execute **mvn clean compile install** - which will download all the required dependencies and package the application into **JAR** file
* Execute **mvn spring-boot:run** which will start the API server
* If you see the message Spring boot then your API is successfully started
* hit url http://localhost:7080/api/v1/boggle
* If you want to exceute API then hit url http://localhost:7080/swagger-ui.html

### Extra Features
* Unit test coverage is 80% on the API side which includes tests for Rest Controller & service
* Unit test for API are executed once you build the application locally wihtout successful test execution the build will fail
* To test API hit url http://localhost:7080/swagger-ui.html which is a API documentation tool
* Unit test are also written for the client side 
  
    
     




