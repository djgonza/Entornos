Abstract Factory(Fábrica abstracta)
===================================
Los patrones Abstract Factory trabajan alrededor de una 
super-fábrica que crea otras fábricas. Esta fábrica también es 
llamada fábrica de fábricas. Este tipo de diseño cae en la 
categoría de creational patter (Patron creacional) ya que nos 
proporciona una de las mejores formas de crear un objeto.
En el patrón Abstract Factory una interfaz es la responsable 
de crear una fábrica de objetos relacionados sin especificarle 
sus clases. Cada fábrica generada puede proporcionar los objetos
de acuerdo con el patrón Factory.

Implementación:
Vamos a crear las interfaces Shape y Color y las clases concretas 
que las implementan. Creamos una clase de fábricas abstracta 
AbstractFactory en el siguiente paso. Definimos las clases 
Factory ShapeFactory y ColorFactory las cuales extienden 
Abstractactory. Y creamos una clase constructora/generadora 
FactoryProducer.
AbstractFactoryPatternDemo usa FactoryProducer para obtener 
uno objeto de tipo AbstractFactory. Le pasará información (CIRCLE 
/ RECTANGLE / SQUARE para Shape) a AbstractFactory para obtener
el objeto que necesita. 
También le pasará información (RED / GREEN / BLUE para Color) 
a AbstractFactory para obtener el objeto que necesita.

Paso 1 Creamos la interfaz Shape Shape.java

Paso 2 Creamos las clases concretas implementando la interfaz.
Rectangle.java, Square.java y Circle.java

Paso 3 Creamos la interfaz Color Color.java

Paso 4 Creamos las clases concretas que implementan la interfaz.
Red.java Green.java y Blue.java

Paso 5 Creamos una clase abstracta para obtener las fábricas 
de objetos tipo Color y Shape. AbstractFactory.java

Paso 6 Creamos las clases Factory extendiendo de AbstractFactory 
para generar objetos de las clases concretas basados en 
información dada. ShapeFactory.java y ColorFactory.java

Paso 7 Creamos una clase Fábrica generadora para obtener fábricas
pasandole información como Color o Shape FactoryProducer.java

Paso 8 Usamos FactoryProducer para obtener AbstractFactory para 
obtener fábricas de clases concretas pasandoles información como 
el tipo AbstractFactoryPatternDemo.java

Paso 9 Verificamos la salida
Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.
Inside Red::fill() method.
Inside Green::fill() method.
Inside Blue::fill() method.

El diagrama de clases trata de representar las relacciones entre
las clases:

Subclases:  Rectangle, Square, Circle, Red, Green y Blue
Supertipos: Shape, Color
          + AbstractFactory
Factorias:  ShapeFactory, ColorFactory
          + FactoryProducer
Usuaria:    AbstractFactoryPatternDemo.      