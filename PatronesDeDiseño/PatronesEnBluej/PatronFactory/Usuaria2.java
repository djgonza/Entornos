import java.util.*;
/**
 *  Usuaria2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuaria2
{
    private ArrayList<SuperTipo> elementos;

    /**
     * Constructor for objects of class Usuaria2
     */
    public Usuaria2()
    {
        Random azar = new Random();
        elementos = new ArrayList<SuperTipo>();
        for (int i = 1 ; i < 10; i++)
        {
            int tipo = azar.nextInt(Factoria.TOPE_ELEMENTOS);
            elementos.add(Factoria.getElemento(tipo));
        }
        
        for (SuperTipo s: elementos)
            System.out.println(s); 
    }

    
}
