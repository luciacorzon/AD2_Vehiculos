# Hai que configurar a Base de Datos

1) Configurar o ficheiro de propiedades en src/main/resources/application.properties

```properties
# Configuración de la base de datos H2 en modo archivo (se guarda en el proyecto)
spring.datasource.url=jdbc:h2:file:./data/vehiculosdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# H2 Console (para ver los datos en el navegador)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
## Gestiñon das tablas da base de datos na liña `spring.jpa.hibernate.ddl-auto`

| Opción         | Descripción                                         | ¿Cuándo usarlo?                    |
|---------------|-----------------------------------------------------|------------------------------------|
| **none**      | No modifica la base de datos                        | 🔹 Producción (manual scripts SQL) |
| **create**    | Borra y vuelve a crear tablas en cada inicio        | ⚠️ Desarrollo inicial             |
| **create-drop** | Borra, crea y elimina tablas al apagar la app     | 🔄 Pruebas automatizadas         |
| **update**    | Modifica la estructura sin borrar datos             | 🟢 Desarrollo continuo            |
| **validate**  | Solo verifica que la BD coincida con las entidades  | ✅ Producción (con BD ya creada)  |


2) Agregar dependencia de H2 en el archivo `pom.xml` se non se fixo xa ao inicializar o proxecto


3) Executar o proxecto