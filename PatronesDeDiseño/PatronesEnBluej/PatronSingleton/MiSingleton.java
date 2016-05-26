/**
 * Clase con un unico objeto, para obtener el objeto
 * se llama al metodo estatico publico getInstancia.
 * 
 * Usa el Patron de diseño Singleton.
 * 
 */
public class MiSingleton
{
    /**
     * Dato PRIVADO y estatico de tipo MiSingleton
     * que contiene el unico objeto;
     */
    private static MiSingleton instancia = new MiSingleton();
    
    // resto de variables de instancia
    // ...
    
    /**
     * Constructor PRIVADO, llamado al declarar la clase.
     * Debe existir un constructor privado al menos, para que no se
     * genere automaticamente un constructor publico sin parametros.
     */
    private MiSingleton() // puede llevar parametros, 
    {
       // instrucciones del constructor.
       // si hay parametros se asignaran a las variables de instancia.
    }
    
    /**
     * Metodo estatico PUBLICO que devuelve el unico objeto.
     * se le llama desde fuera con:
     *      MiSingleton instancia = new MiSingleton.getInstancia();
     */
    public static  MiSingleton getInstancia()
    {
        return instancia;
    }
    
    // resto de metodos.
    // ...
}