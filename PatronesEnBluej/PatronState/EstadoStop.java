public class EstadoStop implements Estado 
{

   public void hacer(Contexto contexto) 
   {
      System.out.println("El jugador esta en estado: stop");
      contexto.setEstado(this);
   }

   public String toString()
   {
      return "Estado Stop ";
   }
}