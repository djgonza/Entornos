import java.util.*;
/**
 * Esta clase implementa la coleccion de elementos, que en este caso
 * sera una lista de tipo LinkedList que contiene 10 elementos enteros
 * del 1 al 10 ambos incluidos.
 */
public class Coleccion
{
    /**
     * Creamos una lista enlazada llamada lista de tipo LinkedList
     */
    private LinkedList lista=new LinkedList();
    
    /**
     * Este es el constructor de la clase y lo que hace es insertar en la
     * lista los 10 enteros del 1 al 10 ambos incluidos.
     */
    public Coleccion()
    {
        for(int i=1;i<11;i++)
        {
            lista.add(new Integer(i));
        }
    }//Coleccion
   
    /**
     * Retorna un ListIterator que es un interface IFIterator para listas
     * que permite recorrer la lista en cada direccion y modificar la
     * lista durante el recorrido. Este interface se obtiene a través del
     * metodo listIterator de la clase LinkedList pasandole como
     * parámetro La posicion especifica de la lista por la que empezar el
     * recorrido.
     * @param index indica la posición de la lista por la que empezar el
     * recorrido.
     * @return ListIterator es un interface de tipo ListIterator.
     */
    public ListIterator miiterator(int index)
    {
        return lista.listIterator(index);
    }//miiterator
   
}//class Coleccion
