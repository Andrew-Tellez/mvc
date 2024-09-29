# mvc

## docker
### run postgres container
```bash
docker compose up
```
### delete postgres container
```bash
docker compose down
```

## maven
### compile project
```bash
mvn compile
```
### run tests
```bash
mvn test
```
### run project
```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```
### clean target directory
```bash
mvn clean
```
