
/**
 * Clase usuaria de la clase singleton.
 */
public class Usuaria
{
    // declaracion e inicializacion del unico objeto de la clase.
    private MiSingleton unicoObjeto  = MiSingleton.getInstancia(); 

    /**
     * Constructor for objects of class Usuaria
     */
    public Usuaria()
    {
        // uso de la variable.
        System.out.println(unicoObjeto.toString());
    }
 
}
