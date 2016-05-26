
/**
 *  Usuaria de la clase Factoria.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuaria
{
    
    private SuperTipo x, y;

    /**
     * Constructor for objects of class Usuaria
     */
    public Usuaria()
    {
        x = Factoria.getElemento(1);
        System.out.println(x);
        y = Factoria.getElemento(2);
        System.out.println(x);
    }

    
}
