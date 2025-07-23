# Parser para API pública de consultas de la BCN de Chile

## Contexto
La API pública de la Biblioteca del Congreso Nacional de Chile, expone información disponible al público, sin embargo lo hace en formato XML, este proyecto contempla una especie de *wrapper parser* para la información disponible pero en formato JSON.

## Motivación
Este es un proyecto personal con el solo fin de ponerme al día con las tendencias actuales con Java (viniendo de un Java dev con 9 años de experiencia *hands-on*, sin haber tocado Spring ni Spring Boot).

## Implementación
Este proyecto se implementa usando Spring Boot, hace uso de Jackson para parsear XML a POJO y posteriormente usa el mismo framework de Spring para exponer la información en formato JSON.
