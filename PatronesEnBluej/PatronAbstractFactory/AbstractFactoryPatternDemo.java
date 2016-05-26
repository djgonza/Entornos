public class AbstractFactoryPatternDemo 
{
   public static void main(String[] args)
   {
      //get shape factory
      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

      //obtiene un Shape Circle  y llama al metodo draw de Shape Circle
      Shape shape1 = shapeFactory.getShape("CIRCLE");
      shape1.draw();

      Shape shape2 = shapeFactory.getShape("RECTANGLE");
      shape2.draw();
      Shape shape3 = shapeFactory.getShape("SQUARE");
      shape3.draw();

      //get color factory
      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

      //obtiene un objeto de Color Red y llama al metodo fill de Red
      Color color1 = colorFactory.getColor("RED");
      color1.fill();

      Color color2 = colorFactory.getColor("Green");
      color2.fill();
      Color color3 = colorFactory.getColor("BLUE");
      color3.fill();
   }
}