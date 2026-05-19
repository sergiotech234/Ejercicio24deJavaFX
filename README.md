# CRUD con JavaFX y Base de Datos (TableView)

## Descripción

Este proyecto consiste en desarrollar una aplicación en **JavaFX** conectada a una **base de datos**, que permite realizar operaciones **CRUD (Create, Read, Update, Delete)** sobre una tabla. Los datos se muestran en un **TableView**, permitiendo su gestión desde la interfaz gráfica.

El objetivo del ejercicio es aprender a manejar operaciones completas de persistencia de datos integradas con una interfaz gráfica.

## Objetivos

- Conectar JavaFX con una base de datos usando JDBC.
- Mostrar datos en un `TableView`.
- Implementar operaciones CRUD:
  - Crear registros
  - Leer registros
  - Actualizar registros
  - Eliminar registros
- Manipular datos desde la interfaz gráfica.
- Mejorar la interacción usuario–base de datos.

## Funcionamiento

1. Se inicia la aplicación.
2. Se carga la conexión con la base de datos.
3. Se muestran los registros en un `TableView`.
4. El usuario puede:
   - **Crear** nuevos registros mediante un formulario.
   - **Leer** datos en la tabla.
   - **Actualizar** registros seleccionados.
   - **Eliminar** registros seleccionados.
5. Los cambios se reflejan inmediatamente en la interfaz.

## Ejemplo de interfaz

```text
+------------------------------------------------------+
| ID | Nombre | Email           | Teléfono            |
|----|--------|----------------|----------------------|
| 1  | Ana    | ana@mail.com   | 123456789            |
| 2  | Luis   | luis@mail.com  | 987654321            |
+------------------------------------------------------+

[ Nombre ] [ Email ] [ Teléfono ]
[ Crear ] [ Actualizar ] [ Eliminar ]
```

## Ejemplo de SQL

### Crear registro
```sql
INSERT INTO usuarios (nombre, email, telefono)
VALUES ('Juan', 'juan@mail.com', '111222333');
```

### Leer registros
```sql
SELECT * FROM usuarios;
```

### Actualizar registro
```sql
UPDATE usuarios
SET nombre = 'Juan Actualizado'
WHERE id = 1;
```

### Eliminar registro
```sql
DELETE FROM usuarios WHERE id = 1;
```
