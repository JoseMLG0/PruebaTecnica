# Prueba Tecnica

El proyecto a sido generado usando Java 17, Spring, MySQL.

## Inicializar Base de datos

Para poder ejecutar el proyecto, es necesario generar inicializar una base de datos con el siguiente query: CREATE DATABASE IF NOT EXISTS testdata

## Iniciar servidor

Se realiza el levantamiento del servidor desde el IDE o ejecutando el compilado ubicado en la carpeta builds/libs


## Servicios expuestos
- POST crear usuario: http://localhost:8080/users  - el body debe contener las variables: correo, apellido y nombre como minimo

```
{
    "nombre": "JOSE",
    "apellido": "JOSE1",
    "correo": "Jw1fO2efSE23rw423",
    "fechaNacimiento": "2023-02-02"
}
```
- GET ver usuario: http://localhost:8080/users/{idUsuario}
- DELETE eliminar usuario: http://localhost:8080/users/{idUsuario}
- GET ver todos los usuarios: 
- GET paginar usuarios: 
- GET ver salud del servicio: 