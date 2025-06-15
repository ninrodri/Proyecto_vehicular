# Manual de Usuario del Sistema de Registro Vehicular

## 1. Introducción

Bienvenido al Sistema de Registro Vehicular. Este manual tiene como objetivo guiar al usuario final en el uso correcto del programa, explicando las funciones disponibles, su acceso y uso paso a paso. El sistema está diseñado para facilitar la administración descentralizada de vehículos, traspasos y multas por departamento.

## 2. Requisitos del Sistema

### 2.1 Requisitos de Hardware

- Procesador: Intel i3 o superior
- Memoria RAM: 4 GB mínimo
- Espacio en disco: 200 MB libres

### 2.2 Requisitos de Software

- Sistema operativo: Windows 10 o superior
- Java Runtime Environment (JRE) 8 o superior
- NetBeans (para edición del código, opcional)

## 3. Inicio del Programa

1. Ejecutar el archivo `RegistroSuch.jar` o abrir el proyecto desde NetBeans.
2. Al iniciar, se mostrará la ventana de **Selección de Carpeta**, donde deberá elegir la carpeta correspondiente al departamento.

## 4. Módulos Principales y Uso

### 4.1 Módulo Vehículos

- **Función:** Consultar los registros de vehículos.
- **Acción:**
  - Ingresar el número de placa en el campo de búsqueda.
  - Presionar "Buscar" para ver la información completa del vehículo.

### 4.2 Módulo Traspasos

- **Función:** Visualizar el historial de traspasos por vehículo.
- **Acción:**
  - Seleccionar un vehículo por su placa.
  - Ver en la tabla los traspasos anteriores y actuales.

### 4.3 Módulo Multas

- **Función:** Mostrar las multas registradas por cada vehículo.
- **Acción:**
  - Ingresar la placa.
  - Ver todas las multas asociadas, con fecha, motivo y monto.

### 4.4 Módulo Estadísticas

- **Función:** Generar informes y comparaciones.
- **Ejemplos de consulta:**
  - Vehículo con más multas.
  - Departamento con mayor número de traspasos.
  - Comparación de tiempo de búsqueda entre ABB y AVL.

### 4.5 Módulo Graficador

- **Función:** Visualizar los árboles ABB y AVL.
- **Acción:**
  - Hacer clic en "Graficar"
  - Se mostrará un archivo .png generado con Graphviz.

## 5. Consejos de Uso

- Asegúrese de seleccionar correctamente la carpeta del departamento antes de operar.
- Utilice placas exactas (sin espacios) para evitar errores de búsqueda.
- Puede cambiar de carpeta desde el menú "Archivo > Seleccionar Carpeta".

## 6. Solución de Problemas

| Problema              | Solución                                                      |
| --------------------- | ------------------------------------------------------------- |
| No carga información  | Verifique que seleccionó la carpeta correcta del departamento |
| No encuentra vehículo | Asegúrese de escribir correctamente la placa                  |
| Error al iniciar      | Verifique que tenga Java instalado correctamente              |

## 7. Contacto y Soporte

- Autor: Nincy Abigail Rodriguez Chavez

---

**Versión del sistema:** 24.0\
**Lenguaje:** Java\
**Entorno de desarrollo:** NetBeans

