
# Mejoras Propuestas para el Sistema

Este documento describe las mejoras propuestas para el sistema, con el objetivo de optimizar su funcionamiento y mejorar la experiencia de los usuarios. Le mando un abracito profe❤️

## Mejoras Implementadas

### 1. Sistema de Multas

Se ha implementado un sistema de multas por retraso en la devolución de libros. Este sistema incluye:

- Cálculo automático de la multa en función del tiempo de retraso.
- Generación de un recibo detallado con la información del usuario y el monto a pagar.

### 2. Estado Físico del Libro

Se ha añadido un sistema de seguimiento del estado físico de los libros, con las siguientes características:

- Atributos para registrar posibles daños en los libros.
- Un historial de mantenimiento que permite rastrear reparaciones o intervenciones realizadas en cada libro.

### 3. Perfiles de Usuario Extendidos

Se ha expandido la clase Usuario para incluir:

- Preferencias de lectura personalizadas.
- Géneros favoritos del usuario.
- Límites de préstamo ajustables según el tipo de usuario.

### 4. Gestión de Empleados Mejorada

Se han agregado funcionalidades para una mejor administración del personal, incluyendo:

- Registro de horarios específicos de los empleados.
- Especialidades de cada empleado dentro del sistema.
- Niveles de autorización diferenciados según el rol.

### 5. Sistema de Notificaciones

Se ha desarrollado un sistema de notificaciones que permite:

- Generar mensajes de alerta sobre fechas de vencimiento próximas.
- Notificar la disponibilidad de libros reservados.

### 6. Reemplazo de Arreglos por `ArrayList` para Gestionar Libros y Usuarios

Se ha mejorado la gestión de los libros y usuarios al reemplazar los arreglos tradicionales por `ArrayList`. Esto permite una manipulación más flexible y eficiente de los elementos en el sistema.

### 7. Implementación de `HashMap` para Manejar Empleados de Manera Eficiente

Se ha utilizado `HashMap` para almacenar y recuperar rápidamente los datos de los empleados. Esto permite un acceso más rápido y eficiente en comparación con otras estructuras de datos.

### 8. Incorporación de `Queue` para Gestionar Préstamos en Proceso

Se ha implementado una cola (`Queue`) para gestionar los préstamos que están en proceso. Esto asegura que los libros sean gestionados de manera ordenada y que no haya conflictos entre múltiples usuarios que solicitan el mismo libro.

### 9. Utilización de `Set` para Mantener el Historial de Préstamos Sin Duplicados

Se ha utilizado `Set` para el historial de préstamos, lo que asegura que no haya duplicados en los registros y que se mantenga una lista única de los préstamos realizados.

## Autores

Este documento y las mejoras fueron realizadas por:

- **Axel Velasco Chavez**
- **Israel Hernandez Fuentes**
- **Elizabeth Gonzales Mendoza**