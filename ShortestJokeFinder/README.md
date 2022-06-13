# NS Jokefinder Api - Spring Boot with generated Camel REST DSL API

The project generates resources based on the openapi specification stored in resources/openapi folder

Replace the openapi.yaml file in src/main/resources/openapi directory with your own OpenAPI specification
and run the Maven compile command to generate Camel REST DSL and data models

```
$ mvn clean compile
```
new resources are generated in generated.swagger.api and generated.swagger.model packeges


You can run this example in your local using

```
Download the source project from Github -> $ mvn clean compile (Run from the 
root directory of the project, this will generate the Camel REST DSL and 
data models -> Then you can run the main application and Test using Postman.)
```

```
$ mvn spring-boot:run
```

      - 5500:5500


docker build -t ns/jokefinder:latest .

docker run -d -p 8080:8080 ns/jokefinder:latest
