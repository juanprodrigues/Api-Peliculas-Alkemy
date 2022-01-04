# Api-Películas(Actualizacion 3 de Enero 2022)
## CHALLENGE BACKEND - Java
Este es un challenge para [Alkemy](https://www.alkemy.org/) para poder acceder a Aceleracion.
## Objetivo
Desarrollar una API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
personajes que lo componen y entender en qué películas estos participaron. 
## Requisitos
```
Utilizar Spring Boot.
No es necesario armar el Frontend.
Las rutas deberán seguir el patrón REST.
Utilizar la librería Spring Security.
```

## Despliegue del Proyecto
Antes de ejecutar el proyecto se necesita configurar unas variables importantes.
Como se usa la dependencia de MySQL(mysql-connector-java), se debe crear un Base de datos con el nombre de **_alkemyPeliculas_** o hacer sus respectivas modificaciones.

```
spring.datasource.url=jdbc:mysql://localhost:3306/alkemyPeliculas?serverTimezone=UTC
spring.datasource.username=Usuario
spring.datasource.password=Contraseña
```

Luego anteriormente, crear una cuenta en [SendGrid.](https://docs.sendgrid.com/) 

Además en el archivo _application.properties_ que se encuentra en _src\main\resources_ remplazar por sus datos correspondientes, en particular, se tiene que completar con su correo que se uso en [SendGrid.](https://docs.sendgrid.com/)
```
user.movie.email.sender=${CORREO}
```
Para habilitar(true) esta opcion se puede mapular en la siguiente propiedad.

```
user.movie.email.enabled=false
```
Por ultimo crear una variable de entorno como **_EMAIL_API_KEY_**(o similar) la cual almacene el token de autentificación única generado en la página.


Esta api se encuentra en funcionamiento a la fecha.

# Autentificación

Primero que nada, se tienen que registrar un usuario para luego logearse.

Método Post

```
http://localhost:8080/auth/signup
```

 y se tiene que enviar como cuerpo (Body)

```
{
    "username":"correo@gmail.com",
    "password":"password1"
}
```
Lugo procedemos a ingresar, este proceso nos dará un token que vamos a usar para realizar cada consulta de nuestra API

```
http://localhost:8080/auth/signin
```

```
{
    "username":"correo@gmail.com",
    "password":"password1"
}
```
Respuesta

```
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFucHJvZHJpZ3Vlcy4zM0BnbWFpbC5jb20iLCJleHAiOjE2Mzk1MjI2MzcsImlhdCI6MTYzOTQ4NjYzN30._Gqpfpoiy_i6phSF7obpdNv4MnO5bKAVfpaznyOa7lc
```

Esta cadena de texto es la utilizaremos para realizar consultas

# Endpoint de personaje

## Métodos Post de Consultas
Para este caso vamos a guardar un personaje de los Simpson
```
{
   "id_character":4,
   "image":"/ima3.png",
   "name":"bart",
   "age":8,
   "weight":50.0,
   "history":"historia de liza",
   "id_movie":1,
   "movies":[
      {     
          "id":2,
         "imagen":"/usr/tmp/CCC.jpg",
         "titulo":"La Pelicula",
         "calificacion":5,
         "fechaCreacion":"2021-09-28"
      }
   ]
}
```

## Métodos Get de Consultas

Obtener atributos de nombre e imagen de todos personajes en forma de lista.

```
http://localhost:8080/character/ 
```

Obtener una lista de todos personajes.

```
http://localhost:8080/character/all
```

Buscar personaje por IDMovie

```
http://localhost:8080/character?movies=2
```
Buscar personaje por nombre de personaje.

```
http://localhost:8080/character?name=bart
```

Buscar personaje por Año de personaje
```
http://localhost:8080/character?age=10
```
Buscar personaje por ID de personaje

```
http://localhost:8080/character/2
```

## Métodos Put de Consultas
Modificar una Personaje
```
http://localhost:8080/character/update/4
```
Body
```
{
    "id_character": 4,
    "image": "/ima2.png",
    "name": "Bart",
    "age": 10,
    "weight": 60.0,
    "history": "Esta es la historia verdadera de Bart",
    "id_movie": 1
}
```

## Métodos Delete de Consultas
Para eliminar un personaje.
```
http://localhost:8080/character/delete/3
```
# Endpoint de Película

## Métodos Get de Consultas
Listar Películas solo con los campos de imagen, título y fecha de creación.
```
http://localhost:8080/movies/
```

Listar con todos sus atributos.

```
http://localhost:8080/movies/all
```

Buscar por nombre.
```
http://localhost:8080/movies?name=Futurama La Pelicula
```
Buscar por Id de género.
```
http://localhost:8080/movies?gender=1
```
Buscar por todos y ordenarlos de forma ascendente.
```
http://localhost:8080/movies?order=ASC
```
Buscar por todos y ordenarlos de forma descendente.
```
http://localhost:8080/movies?order=DESC
```
## Métodos Post de Consultas.
Para guardar una película
```
http://localhost:8080/movies
```
Body
```
{
    "imagen": "/usr/tmp/CCC.jpg",
    "titulo": "Futurama",
    "fechaCreacion": "2021-09-28",
    "calificacion": 5,
    "idGenero": 2
}
```
## Métodos Put de Consultas.
Para Modificar una película

```
http://localhost:8080/movies/1
```
Body
```
{
    "imagen": "/usr/tmp/123.jpg",
    "titulo": "Futurama La Pelicula",
    "fechaCreacion": "2021-09-28",
    "calificacion": 3,
    "idGenero": 2
}
```

## Métodos delete de Consultas.

Para eliminar una película
```
http://localhost:8080/movies/4
```


# Endpoint de Genero
Estos endpoint corresponden a un CRUD.

## Método Get
Listar
```
http://localhost:8080/gender
```

## Método Post
Guardar
```
http://localhost:8080/gender
```
Body
```
{
    "imagen": "/Teeror.ong",
    "nombre": "Romance"
}
``` 

## Método Put
Modificar
```
http://localhost:8080/gender/3
```
Body
```
{
    "imagen": "/Teeror.ong",
    "nombre": "Romance"
}
``` 

## Método delete
Eliminar
```
http://localhost:8080/gender/4
```



