# Especificaciones del Sistema

![Diagrama de Casos de Uso](/images/casos_de_uso.drawio.png)

## Actores

### Administrador

| Actor | Administrador |
|---|---|
| Descripción | Persona encargada de administrar el contenido de la aplicación, como mitologías, personajes y relatos. |
| Características | Puede crear, editar, actualizar y eliminar contenido. |
| Relaciones | Relación directa con el contenido gestionado en la base de datos. |
| Referencias | Relacionado con los casos de uso CU2, CU4 y CU5. |
| Notas | Los administradores tienen acceso exclusivo a las funciones de gestión. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

| Atributo | Descripción | Tipo |
|---|---|---|
| Nombre | Nombre del administrador | Texto |
| Contraseña | Contraseña para autenticarse | Texto cifrado |
| Rol | Define el nivel de acceso (Administrador) | Enumerado |

---

### Usuario

| Actor | Usuario |
|---|---|
| Descripción | Persona que utiliza la aplicación para explorar y consultar información sobre mitologías. |
| Características | Puede autenticarse, visualizar contenido y marcar elementos como favoritos. |
| Relaciones | Relación directa con el contenido de la aplicación. |
| Referencias | Relacionado con los casos de uso CU1, CU3 y CU6. |
| Notas | Los usuarios tienen acceso limitado al contenido y no pueden modificarlo. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

| Atributo | Descripción | Tipo |
|---|---|---|
| Nombre | Nombre del usuario | Texto |
| Contraseña | Contraseña para autenticarse | Texto cifrado |
| Favoritos | Lista de elementos marcados como favoritos | Lista de referencias |

---

## Casos de Uso

### Autenticarse

| Caso de Uso CU1 | Autenticarse |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Usuario, Administrador |
| Descripción | Permite a los usuarios autenticarse en la aplicación mediante el inicio de sesión o creación de una cuenta. |
| Flujo básico | 1. El usuario accede a la pantalla de autenticación.<br>2. El usuario introduce su nombre de usuario y contraseña.<br>3. El sistema valida las credenciales.<br>4. Si son válidas, el usuario accede a la pantalla de inicio. |
| Flujo alternativo | 3a. Si las credenciales no son válidas, el sistema muestra un mensaje de error y solicita intentarlo nuevamente.<br>3b. El usuario puede seleccionar la opción de "Recuperar contraseña" si la ha olvidado. |
| Pre-condiciones | El usuario debe tener una cuenta creada previamente (excepto para registrarse). |
| Post-condiciones | El usuario accede a la pantalla de inicio de la aplicación. |
| Requerimientos | Base de datos de usuarios con credenciales válidas. |
| Notas | El sistema debe ser capaz de manejar cuentas tanto de usuarios como de administradores. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

---

### Crear contenido

| Caso de Uso CU2 | Crear contenido |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Administrador |
| Descripción | Permite a los administradores agregar nuevas mitologías, personajes, relatos u otros elementos a la base de datos. |
| Flujo básico | 1. El administrador accede a la sección de administración.<br>2. Selecciona la opción de "Crear contenido".<br>3. Introduce los datos necesarios (nombre, descripción, imágenes, etc.).<br>4. Confirma y guarda el contenido. |
| Flujo alternativo | 3a. Si hay datos faltantes o incorrectos, el sistema muestra un mensaje de error y solicita corregirlos. |
| Pre-condiciones | El administrador debe estar autenticado en la aplicación. |
| Post-condiciones | El contenido queda disponible para los usuarios en la base de datos. |
| Requerimientos | Interfaz para introducir y gestionar datos. |
| Notas | El contenido debe pasar por una validación para garantizar su calidad y formato adecuado. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

---

### Visualizar contenido

| Caso de Uso CU3 | Visualizar contenido |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Usuario, Administrador |
| Descripción | Permite a los usuarios explorar el contenido de la aplicación. Incluye la visualización de una lista de mitologías, presentación detallada de cada mitología y acceso a elementos relacionados (personajes, relatos, lugares). |
| Flujo básico | 1. El usuario inicia sesión en la aplicación.<br>2. El sistema muestra una lista de mitologías disponibles, cada una con un nombre, imagen y breve descripción.<br>3. El usuario selecciona una mitología.<br>4. El sistema muestra una presentación detallada de la mitología, incluyendo un resumen y enlaces a elementos relacionados.<br>5. El usuario selecciona un enlace para explorar un elemento (por ejemplo, un personaje).<br>6. El sistema muestra la información detallada del elemento seleccionado. |
| Flujo alternativo | 5a. Si no hay elementos relacionados disponibles, el sistema muestra un mensaje indicando que no hay información adicional. |
| Pre-condiciones | 1. El usuario debe haber iniciado sesión correctamente.<br>2. La base de datos debe contener información sobre las mitologías y sus elementos relacionados. |
| Post-condiciones | 1. El usuario obtiene información detallada del contenido seleccionado.<br>2. El sistema registra las interacciones del usuario (si es necesario). |
| Requerimientos | Base de datos con información estructurada de mitologías, personajes y relatos. |
| Notas | Se pueden agregar funciones adicionales como búsqueda, filtros o favoritos para enriquecer la experiencia. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

---

### Actualizar contenido

| Caso de Uso CU4 | Actualizar contenido |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Administrador |
| Descripción | Permite a los administradores modificar información existente en la base de datos. |
| Flujo básico | 1. El administrador accede a la sección de administración.<br>2. Selecciona un elemento para editar.<br>3. Realiza los cambios necesarios.<br>4. Guarda los cambios. |
| Flujo alternativo | 3a. Si los cambios no son válidos, el sistema muestra un mensaje de error y solicita corregirlos. |
| Pre-condiciones | El administrador debe estar autenticado y el contenido a modificar debe existir. |
| Post-condiciones | Los cambios quedan reflejados en la base de datos. |
| Requerimientos | Interfaz para buscar, editar y validar contenido. |
| Notas | Es importante registrar quién realiza las modificaciones para fines de auditoría. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

---

### Eliminar contenido

| Caso de Uso CU5 | Eliminar contenido |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Administrador |
| Descripción | Permite a los administradores eliminar contenido de la base de datos. |
| Flujo básico | 1. El administrador accede a la sección de administración.<br>2. Selecciona un elemento para eliminar.<br>3. Confirma la eliminación. |
| Flujo alternativo | 3a. Si el administrador cancela la eliminación, no se realizan cambios. |
| Pre-condiciones | El administrador debe estar autenticado y el contenido a eliminar debe existir. |
| Post-condiciones | El contenido eliminado ya no está disponible en la aplicación. |
| Requerimientos | Interfaz para buscar y confirmar la eliminación de contenido. |
| Notas | La eliminación debe ser irreversible o requerir confirmación adicional para evitar errores. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |

---

### Favoritos

| Caso de Uso CU6 | Favoritos |
|---|---|
| Fuentes | Requisitos funcionales del sistema |
| Actor | Usuario, Administrador |
| Descripción | Permite a los usuarios marcar o eliminar contenido de la lista de favoritos para acceder rápidamente en el futuro. |
| Flujo básico | 1. El usuario visualiza un elemento (mitología, personaje, relato, etc.).<br>2. El usuario selecciona la opción "Añadir a favoritos" o "Eliminar de favoritos".<br>3. Si selecciona "Añadir a favoritos", el sistema guarda el elemento en la lista de favoritos del usuario.<br>4. Si selecciona "Eliminar de favoritos", el sistema elimina el elemento de la lista de favoritos del usuario. |
| Flujo alternativo | 2a. Si el elemento ya está en favoritos y el usuario selecciona "Añadir a favoritos", el sistema muestra un mensaje indicando que ya fue añadido.<br>2b. Si el elemento no está en favoritos y el usuario selecciona "Eliminar de favoritos", el sistema muestra un mensaje indicando que el elemento no está en favoritos. |
| Pre-condiciones | El usuario debe estar autenticado. |
| Post-condiciones | El elemento queda registrado o eliminado de la lista de favoritos del usuario según la acción realizada. |
| Requerimientos | Base de datos que relacione usuarios con sus favoritos, funcionalidad para agregar y eliminar elementos de favoritos. |
| Notas | Se debe considerar un manejo adecuado de las listas de favoritos en la base de datos para que se actualicen correctamente. |
| Autor | alexfdb |
| Fecha | 20/03/2025 |
