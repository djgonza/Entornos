Estado
En el patrón el de comportamiento de una clase que cambia dependiendo 
de su estado. Este tipo de patrón de diseño es de tipo herencia.
Creamos objetos que representan varios estados y un objeto de 
contexto cuyo comportamiento varia cuando su objeto de estado varia.

Implementación
Vamos a crear la interfaz Estado definiendo una action y clase 
concretas implementando Estado.
Contexto es una clase que contiene un Estado.
Usaremos Contexto y objetos de estado para demostrar el cambio 
de comportamiento en Contexto basado en el tipo de estado en el 
que se encuentra.

Paso 1 Creamos una interfaz Estado.java

Paso 2 Creamos la clases concretas implementando la misma 
interfaz:   EstadoStart.java y EstadoStop.java

Paso 3 Creamos la clase  Contexto.java

Paso 4
Usa el contexto para ver el cambio de comportamiente cuando 
Estado cambia EstadoPatternDemo.java

Paso 5
Verifica la salida

El jugador esta en estado: start
Estado Start
El jugador esta en estado: stop
Estado Stop 
