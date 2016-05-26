public class EstadoStart implements Estado
{

   public void hacer(Contexto contexto)
   {
      System.out.println("El jugador esta en estado: start");
      contexto.setEstado(this);
   }

   public String toString()
   {
      return "Estado Start";
   }
}