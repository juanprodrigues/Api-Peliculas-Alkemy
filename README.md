# Api-Películas
 Esta api se encuentra en desarrollo pero se pueden probar las siguientes funcionalidades con Postman.

## Autentificación

Primero que nada se tienen que registrar un usuario para luego logearse.

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

## Guardar un personaje
Para este caso vamos a guardar un personaje de los Simpson
```
{
        "id_character": 1,
        "image": "/ima3.png",
        "name": "Lisa",
        "age": 8,
        "weight": 50.0,
        "history": "historia de liza",
        "id_movie": 1,
         "movies":[
             {
         "imagen":"/usr/tmp/CCC.jpg",
         "titulo":"Los Simpson La pelicula",
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

