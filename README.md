# Veterinario Backend

[![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Couchbase](https://img.shields.io/badge/Couchbase-EA2328?style=for-the-badge&logo=couchbase&logoColor=white)](https://www.couchbase.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

---

## 🚀 Despliegue en producción

La API está desplegada y disponible públicamente en:

**[https://veterinariobackend.onrender.com/](https://veterinariobackend.onrender.com/)**

- **Backend**: [Render](https://render.com/) (desplegado desde el `Dockerfile` de este repo)
- **Base de datos**: [Couchbase Capella](https://cloud.couchbase.com/) (Couchbase Server gestionado en la nube)

> ⚠️ Al estar en el plan gratuito de Render, el servicio "duerme" tras ~15 min de inactividad. La primera petición tras el reposo puede tardar 30-50s en responder.

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

**Base de datos** Couchbase Capella (NoSQL documental, gestionado en la nube)

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

## 🚀 Instalación y puesta en marcha (local)

### Prerrequisitos

- Java 21
- Maven
- Un clúster Couchbase (local, Docker o Couchbase Capella) con el bucket `veterinario` creado

### Configuración

La conexión se configura vía variables de entorno (con valores por defecto para Couchbase local):

| Variable | Por defecto | Descripción |
|---|---|---|
| `COUCHBASE_CONNECTION_STRING` | `couchbase://localhost` | Usa `couchbases://...` para conexiones seguras (p. ej. Capella) |
| `COUCHBASE_USERNAME` | `usuario` | Usuario de la base de datos |
| `COUCHBASE_PASSWORD` | `usuario` | Contraseña de la base de datos |
| `CORS_ALLOWED_ORIGINS` | `*` | Orígenes permitidos para CORS (dominio del frontend en producción) |

### Pasos

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/Fernandodg97/VeterinarioBackend.git
   cd VeterinarioBackend
   ```

2. **Ten un clúster Couchbase disponible** con el bucket `veterinario` (local o Capella)

3. **Ejecuta la aplicación**
   ```bash
   mvn spring-boot:run
   ```

   La API estará disponible en `http://localhost:4040`

### Con Docker

```bash
docker build -t veterinario-backend .
docker run -p 4040:4040 \
  -e COUCHBASE_CONNECTION_STRING=couchbase://localhost \
  -e COUCHBASE_USERNAME=usuario \
  -e COUCHBASE_PASSWORD=usuario \
  veterinario-backend
```

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

## 👨‍💻 Autor

| | |
|---|---|
| **Fernando Diaz** | [github.com/Fernandodg97](https://github.com/Fernandodg97) |

---

## 📄 Licencia

[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es)
