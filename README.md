# 🌱 EcoCity - Simulador de Ciudad Sostenible

## 📌 Descripción

EcoCity es un simulador por consola desarrollado en Java donde el jugador gestiona una ciudad sostenible. El objetivo es construir edificios, administrar recursos (energía, dinero, población) y sobrevivir a eventos climáticos mientras se mantiene el equilibrio de la ciudad.

---

## 🎮 Funcionalidades

- Construcción de edificios
- Gestión de recursos:
  - Energía
  - Dinero
  - Población
- Simulación por meses
- Eventos climáticos
- Mantenimiento de edificios
- Visualización del estado de la ciudad

---

## 🧱 Estructura del Proyecto

### Clases principales

- Ciudad → Controla el estado global del juego
- Edificio (abstracta) → Base de todos los edificios
- Edificios concretos (CentralEolica, CentralSolar, etc.)

### Interfaces

- GeneradorRecursos → Edificios que producen recursos
- Mantenible → Edificios que requieren mantenimiento

### Conceptos aplicados

- Herencia (mínimo 3 niveles)
- Polimorfismo (uso de List<Edificio>)
- Interfaces
- Encapsulación

---

## 🚀 Cómo ejecutar

1. Clonar o descargar el proyecto
2. Abrirlo en un IDE como IntelliJ o Eclipse
3. Localizar la clase principal (Main)
4. Ejecutar el programa
5. Seguir las instrucciones por consola

---

## 👥 Equipo

Proyecto desarrollado por un equipo de 3 personas, con reparto de tareas en:

- Diseño y modelado de clases
- Implementación de la lógica del juego
- Desarrollo del motor de simulación y pruebas

---


## 📜 Licencia

Proyecto académico sin fines comerciales.
