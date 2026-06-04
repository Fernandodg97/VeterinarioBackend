# Veterinario Backend

[![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Couchbase](https://img.shields.io/badge/Couchbase-EA2328?style=for-the-badge&logo=couchbase&logoColor=white)](https://www.couchbase.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

---

## 👋 Para recruiters

API REST backend para la gestión de clínicas veterinarias, usuarios, mascotas y tratamientos, desarrollada con **Java + Spring Boot** y **Couchbase** como base de datos NoSQL documental.

**Stack:** Java 21 · Spring Boot 3.4 · Spring Data Couchbase · Maven

**Destacado:**
- API REST con arquitectura en capas: controllers, services y repositories
- Base de datos NoSQL documental con **Couchbase**  modelo de datos anidado (usuario → mascotas → tratamientos)
- Configuración CORS para integración con cualquier frontend
- Empaquetado WAR sobre Tomcat embebido

---

## 🛠️ Stack tecnológico

**Backend** Java 21 · Spring Boot 3.4.4 · Spring Data Couchbase · Spring Web · Maven

**Base de datos** Couchbase Server (NoSQL documental)

---

## ✨ Funcionalidades

| Módulo | Descripción |
|---|---|
| **Usuarios** | CRUD completo: crear, consultar, editar y eliminar usuarios |
| **Mascotas** | Gestión de mascotas asociadas a cada usuario |
| **Tratamientos** | Registro de tratamientos por mascota (medicamento, dosis, duración) |

---

## 📮 API REST

### Usuarios

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/usuarios` | Crear un usuario |
| GET | `/api/usuarios` | Obtener todos los usuarios |
| GET | `/api/usuarios/{id}` | Obtener un usuario por ID |
| PUT | `/api/usuarios/{id}` | Editar un usuario |
| DELETE | `/api/usuarios/{id}` | Eliminar un usuario |

### Mascotas

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/usuarios/{id}/mascotas` | Agregar mascota a un usuario |
| GET | `/api/usuarios/{id}/mascotas` | Obtener mascotas del usuario |
| PUT | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}` | Editar una mascota |
| DELETE | `/api/usuarios/{id}/mascotas/{mascotaId}` | Eliminar una mascota |

### Tratamientos

| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos` | Agregar tratamiento |
| GET | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos` | Obtener tratamientos |
| DELETE | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos/{tratamientoId}` | Eliminar tratamiento |

---

## 🚀 Instalación y puesta en marcha

### Prerrequisitos

- Java 21
- Maven
- Couchbase Server corriendo en `localhost` con el bucket `veterinario` creado

### Configuración

```properties
spring.application.name=veterinario
server.port=4040

spring.couchbase.connection-string=localhost
spring.couchbase.bucket.name=veterinario
spring.couchbase.username=usuario
spring.couchbase.password=usuario
```

### Pasos

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/Fernandodg97/VeterinarioBackend.git
   cd VeterinarioBackend
   ```

2. **Inicia Couchbase** y crea el bucket `veterinario` con usuario `usuario` y contraseña `usuario`

3. **Ejecuta la aplicación**
   ```bash
   mvn spring-boot:run
   ```

   La API estará disponible en `http://localhost:4040`

---

## 📤 Ejemplos de peticiones

### Crear usuario

```http
POST /api/usuarios
Content-Type: application/json

{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@example.com",
  "numero_cuenta": "123456"
}
```

### Agregar mascota

```http
POST /api/usuarios/12345/mascotas
Content-Type: application/json

{
  "nombre": "Rex",
  "raza": "Pastor Alemán",
  "genero": "Macho",
  "fechaNacimiento": "2019-06-15",
  "peso": 30.5
}
```

### Agregar tratamiento

```http
POST /api/usuarios/12345/mascotas/111/tratamientos
Content-Type: application/json

{
  "medicamento": "Antiinflamatorio",
  "dosis": "250mg",
  "duracion": "5 días"
}
```

---

## 📚 Documentacion

| Archivo | Descripcion |
|---|---|
| [`Presentacion_Comunidad.pdf`](./Presentacion_Comunidad.pdf) | Presentacion del proyecto |

---

## 👨‍💻 Autor

| | |
|---|---|
| **Fernando Diaz** | [github.com/Fernandodg97](https://github.com/Fernandodg97) |

---

## 📄 Licencia

[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es)
