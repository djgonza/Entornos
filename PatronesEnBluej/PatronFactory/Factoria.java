
/**
 * class Factoria Enlace entre el aebol de clases y sus
 * clases usuarias. para obtener un elemento se usa el 
 * metodo getElemento.
 * 
 * @author Mikel
 * @version may 16
 */
public class Factoria
{
    public static final int TOPE_ELEMENTOS = 3;

    /**
     * Constructor for objects of class Factoria
     */
    public Factoria()
    {
    }

   public static SuperTipo getElemento(int tipo)
   {
       if (tipo == 1) return new a();
       if (tipo == 2) return new b();
       if (tipo == 3) return new c();
       // INCLUYE LA CLASE d,
       // NO OLVIDES CAMBIAR LA CONSTANTE TOPE_ELEMENTOS 
       return null;
       
   }
}
