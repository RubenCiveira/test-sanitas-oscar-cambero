# Calculadora
Microservicio "calculadora", usando maven + spring-boot, con funcionalidades básicas de sumar y restar.


## Requisitos previos
1. Maven 3.3.9
2. Java 1.8

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
Petición GET /rest/calculadora/operaciones en el puerto 8080.

Se pasarán tres parámetros: numeroUno (BigDecimal), numeroDos(BigDecimal) y operación (String).
Si la operación no existe devuelve un error controlado indicando que la operación no está soportada.


Distintas maneras de realizar una prueba: 
1. Swagger: http://localhost:8080/swagger-ui/index.html
2. Request URL: http://localhost:8080/rest/calculadora/operaciones?numeroDos=100&numeroUno=100&operacion=%2B.
3. Curl: curl -X GET "http://localhost:8080/rest/calculadora/operaciones?numeroDos=100&numeroUno=100&operacion=%2B" -H "accept: */*".


### TEST

mvn clean test







