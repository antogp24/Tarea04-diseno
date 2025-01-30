# Tarea04-diseno

## Descripción de Patrones de Diseño Aplicados

### 1. **Factory Method** (Reservar Paquete Turístico)

- **Responsabilidad Única (SRP)**: Solo crea paquetes turísticos.
- **Abierto/Cerrado (OCP)**: Se pueden agregar nuevos tipos sin modificar el código existente.
- **Sustitución de Liskov (LSP)**: Las clases derivadas pueden sustituir la base sin problemas.
- **Segregación de Interfaces (ISP)**: No obliga a implementar funcionalidades no relacionadas.
- **Inversión de Dependencias (DIP)**: Depende de abstracciones, no de implementaciones concretas.

### 2. **Singleton** (Servicio de Reservación)

- **Responsabilidad Única (SRP)**: Gestiona todas las reservas con una instancia única.
- **Abierto/Cerrado (OCP)**: Se puede extender sin modificar la clase base.
- **Sustitución de Liskov (LSP)**: La instancia única no afecta el comportamiento.
- **Segregación de Interfaces (ISP)**: La interfaz es específica y no obliga implementaciones adicionales.
- **Inversión de Dependencias (DIP)**: Exposa una interfaz accesible sin depender de la implementación concreta.

### 3. **Observer** (Notificar Cambios en la Reserva)

- **Responsabilidad Única (SRP)**: Notifica cambios sin afectar la lógica de reservas.
- **Abierto/Cerrado (OCP)**: Se pueden agregar nuevos tipos de notificación fácilmente.
- **Sustitución de Liskov (LSP)**: Añadir o reemplazar observadores no afecta el sistema.
- **Segregación de Interfaces (ISP)**: Los observadores solo notifican, sin otros métodos innecesarios.
- **Inversión de Dependencias (DIP)**: Depende de una abstracción de notificación, no de clases concretas.

### 4. **Composite** (Combinar Actividades en Paquete Turístico)

- **Responsabilidad Única (SRP)**: Maneja actividades (individuales o combinadas) de manera uniforme.
- **Abierto/Cerrado (OCP)**: Permite agregar combinaciones de actividades sin cambiar clases existentes.
- **Sustitución de Liskov (LSP)**: Actividades individuales y compuestas se usan indistintamente.
- **Segregación de Interfaces (ISP)**: La interfaz es simple, sin métodos innecesarios.
- **Inversión de Dependencias (DIP)**: Depende de una abstracción común para las actividades.
