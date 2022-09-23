# Calculadora
Microservicio "calculadora", usando maven + spring-boot, con funcionalidades básicas de sumar y restar.


## Requisitos previos
1. Maven 3.3.9
2. Java 1.11

## Instalación

Generar el JAR a ejecutar, con las instrucciones: 
```
git clone https://github.com/oskarcp/calculadora.git
cd calculadora
mvn validate
mvn verify
mvn clean install
```
Al finalizar, tendremos el JAR calculadora.jar  en /target.

## Ejecución

java -jar target/calculadora.jar

## Pruebas

### API REST
Petición GET rest/calculator/operations en el puerto 8080.


Se pasarán tres parámetros: numeroUno (BigDecimal), numeroDos(BigDecimal) y operación (String).
Si la operación no existe devuelve un error controlado indicando que la operación no está soportada.


Distintas maneras de realizar una prueba: 
1. Swagger: http://localhost:8080/calculator/swagger-ui/index.html
2. Request URL: http://localhost:8080/calculator/rest/calculator/operations?numberTwo=100&numberOne=100&operation=add
3. Curl: curl -X 'GET' \
  'http://localhost:8080/calculator/rest/calculator/operations?numberOne=100&numberTwo=99&operation=add' \
  -H 'accept: application/json'

### TEST

mvn clean test







