public class FactoryProducer
{
   public static AbstractFactory getFactory(String opcion)
   {
      if     (opcion.equalsIgnoreCase("SHAPE"))    return new ShapeFactory();
      else if(opcion.equalsIgnoreCase("COLOR"))    return new ColorFactory();
      return null;
   }
}