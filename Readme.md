# 🩺 ApiHorarioMed

API REST desarrollada con **Spring Boot** para gestionar el registro y
consulta de horarios de medicamentos o vitaminas.

Permite realizar operaciones CRUD completas y está diseñada para ser
consumida por una aplicación móvil Android desarrollada en Kotlin
(MiHorarioMed).

------------------------------------------------------------------------

## 🚀 Tecnologías utilizadas

-   Java 21
-   Spring Boot 4
-   Spring Data JPA
-   PostgreSQL
-   Maven
-   Render (Despliegue en la nube)

------------------------------------------------------------------------

## 📂 Estructura del Proyecto

    apihorariomed
    │
    ├── pom.xml
    │
    └── src
        └── main
            ├── java
            │   └── com
            │       └── tantalean
            │           └── apihorariomed
            │               ├── ApihorariomedApplication.java
            │               ├── controller
            │               │     └── ScheduleController.java
            │               ├── service
            │               │     └── ScheduleService.java
            │               ├── repository
            │               │     └── ScheduleRepository.java
            │               ├── model
            │               │     └── Schedule.java
            │               ├── dto
            │               │     ├── ScheduleRequest.java
            │               │     └── ScheduleResponse.java
            │               ├── exception
            │               │     ├── NotFoundException.java
            │               │     └── ApiExceptionHandler.java
            │               └── config
            │                     └── SeedData.java
            │
            └── resources
                  ├── application.properties
                  ├── static
                  └── templates

------------------------------------------------------------------------

## 🏗 Arquitectura

La API sigue una arquitectura en capas:

**Controller → Service → Repository → Base de Datos**

Esto permite:

-   Separación de responsabilidades
-   Código limpio y mantenible
-   Escalabilidad
-   Mejor organización del proyecto

------------------------------------------------------------------------

## 📌 Descripción de cada componente

### 🔹 ApihorariomedApplication.java

Clase principal que inicia la aplicación Spring Boot.

------------------------------------------------------------------------

### 🔹 model/Schedule.java

Entidad que representa la tabla `schedules` en la base de datos.

Campos: - id (autogenerado) - nombre - dosis - hora - frecuencia -
notas - activo

------------------------------------------------------------------------

### 🔹 repository/ScheduleRepository.java

Capa de acceso a datos. Extiende `JpaRepository` y permite operaciones
CRUD automáticas.

------------------------------------------------------------------------

### 🔹 service/ScheduleService.java

Contiene la lógica de negocio del sistema.

Se encarga de: - Validaciones - Gestión de excepciones - Comunicación
con el repositorio

------------------------------------------------------------------------

### 🔹 controller/ScheduleController.java

Expone los endpoints REST.

Endpoints principales:

-   GET /schedules
-   GET /schedules/{id}
-   POST /schedules
-   PUT /schedules/{id}
-   DELETE /schedules/{id}

------------------------------------------------------------------------

### 🔹 dto

Clases que estructuran los datos de entrada y salida:

-   ScheduleRequest → Datos que recibe la API.
-   ScheduleResponse → Datos que devuelve la API.

------------------------------------------------------------------------

### 🔹 exception

Manejo de errores personalizado:

-   NotFoundException → Cuando un registro no existe.
-   ApiExceptionHandler → Manejo global de errores.

------------------------------------------------------------------------

### 🔹 config/SeedData.java

Inserta datos de prueba al iniciar la aplicación.

------------------------------------------------------------------------

## 🌐 Despliegue

La API está desplegada en Render y accesible públicamente mediante
HTTPS.

Permite que la aplicación móvil consuma los servicios desde cualquier
lugar.

------------------------------------------------------------------------

## 🧪 Ejemplo de Request (POST)

``` json
{
  "nombre": "Vitamina C",
  "dosis": "1 tableta",
  "hora": "08:00:00",
  "frecuencia": "Diario",
  "notas": "Con comida",
  "activo": true
}
```

------------------------------------------------------------------------

## 🎯 Objetivo del Proyecto

Evaluar la capacidad para:

-   Diseñar e implementar servicios REST
-   Modelar una entidad simple
-   Aplicar operaciones CRUD
-   Implementar arquitectura en capas
-   Desplegar una API en la nube

------------------------------------------------------------------------

## 👨‍💻 Autor

Nilver Tantalean\
Ingeniería de Sistemas
