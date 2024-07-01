# OrderFlow

OrderFlow es un sistema avanzado para la gestión de mesas y pedidos en restaurantes, optimizando la experiencia de clientes y personal. Desarrollado en Java con Spring Boot, emplea patrones arquitectónicos como Observer y Facade para un diseño modular y escalable. Además, hace uso de principios de programación orientada a objetos como herencia y polimorfismo para una estructura de código limpia y mantenible.

## Descripción del Proyecto

OrderFlow está diseñado para gestionar y optimizar la operativa de un restaurante mediante un sistema robusto y eficiente. El proyecto permite la gestión de usuarios, mesas, pedidos y servicios de manera integral, mejorando la eficiencia del restaurante y la satisfacción del cliente. Utiliza metodologías avanzadas de desarrollo de software, asegurando un código de alta calidad y fácil de mantener.

## Funcionalidades Principales

- **Gestión de Mozos:** Permite registrar, eliminar y listar mozos.
- **Gestión de Pedidos:** Permite agregar y eliminar pedidos de clientes.
- **Login de Usuarios:** Interfaz para el inicio de sesión de los usuarios del sistema.
- **Gestión de Mesas:** Permite la asignación y liberación de mesas.
- **Procesamiento de Pedidos:** Facilita el seguimiento y procesamiento de pedidos en curso.
- **Registro de Clientes:** Permite registrar nuevos clientes con diferentes categorías.
- **Gestión de Servicios:** Permite agregar y eliminar servicios ofrecidos por el restaurante.


## Programación Orientada a Objetos (POO): 
El proyecto hace uso extensivo de la herencia y el polimorfismo para estructurar el código de manera eficiente y reutilizable.

- **Herencia:** La clase Usuario es extendida por las clases Mozo y Gestor, lo que permite compartir y especializar comportamientos comunes.
- **Polimorfismo:** Las interfaces ICliente y IProducto permiten la implementación de múltiples comportamientos, facilitando la expansión futura del sistema.

## Patrones Arquitectónicos Utilizados

- **Observer:** Implementado para actualizar automáticamente las interfaces de usuario en respuesta a cambios en los datos.
- **Facade:** Proporciona una interfaz simplificada para las interacciones con el subsistema de gestión de pedidos y usuarios.

## Principios SOLID:
El código sigue los principios SOLID para asegurar que sea fácil de entender, mantener y expandir.

- **Single Responsibility Principle (SRP):** Cada clase tiene una única responsabilidad, como se observa en las clases dedicadas a gestionar usuarios, pedidos, mesas, etc.
- **Open/Closed Principle (OCP):** El sistema está diseñado para ser extendido sin modificar el código existente, facilitando futuras mejoras y adiciones.

## Requisitos

- Java 17 o superior
- Maven

## Instalación

Clona el repositorio:
```bash
git clone https://github.com/srodriguezamarillo/OrderFlow.git
cd OrderFlow
```

## Compila el proyecto con Maven:
```bash
./mvnw clean install
```

## Ejecución de Pruebas
```bash
./mvnw test
```

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/java`: Contiene el código fuente principal del proyecto.
- `src/test/java`: Contiene las pruebas unitarias del proyecto.
- `pom.xml`: Archivo de configuración de Maven.

## Contribución
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.

2. Crea una nueva rama para tus cambios:
   ```bash
   git checkout -b feature-nueva-funcionalidad

3. Realiza tus cambios y haz commit de los mismos:
   ```bash
   git commit -m 'Agregar nueva funcionalidad'

4. Sube tus cambios a tu repositorio fork:
   ```bash
   git push origin feature-nueva-funcionalidad

5. Abre un Pull Request en el repositorio original.

## Licencia
Para más detalles, consulta el archivo LICENSE.

## Contacto
Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto:

- **Email:**  srodriguezamarillo@gmail.com
- **LinkedIn:** www.linkedin.com/in/sebastianrodriguezamarillo