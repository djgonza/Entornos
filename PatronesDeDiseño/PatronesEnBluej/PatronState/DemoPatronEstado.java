public class DemoPatronEstado 
{
   public static void main(String[] args)
   {
      Contexto contexto = new Contexto();

      EstadoStart  start = new EstadoStart();
      start.hacer(contexto);

      System.out.println(contexto.getEstado().toString());

      EstadoStop stop = new EstadoStop();
      stop.hacer(contexto);

      System.out.println(contexto.getEstado().toString());
      
      // lo mismo con un unico objeto Estado:
      
      Estado estado = new EstadoStart();
      estado.hacer(contexto);
      System.out.println(contexto.getEstado());
      estado = new EstadoStop();
      estado.hacer(contexto);
      System.out.println(contexto.getEstado());
   }
}