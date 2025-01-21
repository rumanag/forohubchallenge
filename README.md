# FORO HUB 
![logo](/tools/images/foro1.png)

## 1. INTRODUCCION Y ANTECEDENTES

El proyecto aquí descrito es el resultado de 8 meses de estudio básico en el 
mundo de las  tecnologías de punta en Java.

De antemano, quiero indicar que mi proyecto no es mejor de todos, tampoco el peor, pero me 
ha permitido entender gran parte de la teoría que estudiamos durante el curso. Como 
le indicaba a nuestra monitora @Julia83_, entiendo el 95% de los temas que se aplican en el proyecto,
pero !vaya Hágalo!
Por tal razón, no alcancé a desarrollar todas las funcionalidades que hubiera querido incluír
en esta primera versión. Pero mi compromiso es continuar desarrollando las funcionalidades que 
permitan convertir el Foro Hub en una herramienta usada por muchas personas en internet.

Finalmente, Agradezco a Alura-Latam y a Oracle-One por habernos brindado esta experiencia,
la cual ha sido para mi un reto de vida. A @JUlia83_, mis más profundos respetos por su 
dedicación al ayudarnos a resolver dudas y solucionar problemas y por su alto conocimiento de los temas
involucrados en el proyecto. Nunca pude rajarla!


## 2. DESCRIPCIÓN DEL PROYECTO

La mejor descripción del proyecto la desarrolló la misma Alura-Latam, en Trello, por lo cual 
de allí tomo los apartes más relevantes:

"... Ya sabemos para qué sirve el foro y sabemos cómo se ve, pero ¿sabemos cómo funciona por detrás? 
Es decir ¿dónde se almacenan las informaciones? ¿cómo se tratan esos datos para que se relacione un tópico con una respuesta, 
o como se relacionan los usuarios con las respuestas de un tópico?
Ese es nuestro desafío, que se llama Foro Hub: vamos a replicar a nivel de back end este proceso, y para eso crearemos una 
API REST usando Spring.

Nuestra API va a centrarse específicamente en los tópicos, y debe permitir a los usuarios:
- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico"

"... Al final de nuestro desarrollo tendremos una API REST con las siguientes funcionalidades
- API con rutas implementadas siguiendo las mejores prácticas del modelo REST;
- Validaciones realizadas según reglas de negocio;
- Implementación de una base de datos para la persistencia de la información;
- Servicio de autenticación/autorización para restringir el acceso a la información."

# 3. CASOS DE USO

Con base en el apartado anterior, presentamos los casos de uso generales usados en el proyecto.
Para cada una de las clases y entidades -usuarios, tópicos, respuestas y cursos- la 
API Foro HUb será la encargada de cunmplir con las funcionalidades del sistema, de acuerdo con
el siguiente gráfico:
![casosDeUso](/tools/images/DiagramaCasosUsoGeneral.png)

# 4. BASE DE DATOS MySql y  HERRAMIENTA FLYWAY

En nuestro caso usamos MySql como motor de base de datos. La creación de las tablas la realizamos
con  Flyway, basados en el modelo E-R que presentamos a continuación, el cual tiene unas pocas
diferencias con relación al presentado en Trello.

![modeloEntidadRelacion](/tools/images/DiagramaEntidadRelacionV6.png)

## 4.1. Descripcion de tablas

Las siguientes figuras presentan las tablas y campos en el ambiente MySql:

### - **topicos**

![topicos](/tools/images/DescripcionTablaTopicos.png)

### - **usuarios**

![usuarios](/tools/images/DescripcionTablaUsuarios.png)

### - **cursos**

![modeloEntidadRelacion](/tools/images/DescripcionTablaCursos.png)

### - **respuestas**

![modeloEntidadRelacion](/tools/images/DescripcionTablaRespuestas.png)

# 5 APIs

Para el diseño local de las APIs hemos trabajado con Insomnia, una 
"API Client for REST", como se muestra en los siguientes figuras


### - **login**

![login](/tools/images/InsomniaLogin.png)

### - **Registrar Tópicos**

![registrarTopicos](/tools/images/InsomniaPostRegistrarTopicos1.png)

### - **Listar tópicos**

![listarTopicos](/tools/images/insomniaGetListadoTopicos.png)

### - **Eliminar un tópico**

![eliminarTopicos](/tools/images/InsomniaEliminarTopicos.png)

### - **Desactivar  un tópico**

![DesactivarTopicos](/tools/images/InsomniaDesactivarTopicos.png)

# 6 ESTRUCTURA DEL PROYECTO.

En las siguientes figuras indicamos la estructura del proyecto, desde
el punto de vista de directorios, paquetes, carpetas y archivos.

### - **Proyecto colapsado**

![proyectoColapsado](/tools/images/ProyectoColapsado.png)


### - **Proyecto Expandido a nivel de directorios**

![proyectoExpandidoDirectorios](/tools/images/ProyectoExpandido1.png)


### - **Proyecto expandido a nivel de archivos**

![ProyectoExpandidoArchivos](/tools/images/ProyectoExpandido2.png)

# 7. HERRAMIENTAS UTILIZADAS

 - Datos: MySql y Flyway
 - Encriptadores: Bcrypt
 - Manejo de APIs: Insomnia
 - soporte documental : ChatGPT - AI
 - IDE: Intellij
 - Framework: Spring Boot 7, Maven, JWT, Auth0, lombok
 - Proyecto agil: Trello


#### realizado por: RICARDO UMAÑA GUZMAN - 20/01/2025
