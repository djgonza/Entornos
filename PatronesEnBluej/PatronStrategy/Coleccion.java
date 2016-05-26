import java.util.*;
/**
 * Esta clase implementa la coleccion de elementos, que en este caso
 * sera un vector de tipo Vector que contiene 10 elementos enteros
 * desordenados {4,7,6,1,2,8,3,5,10,9}
 */
public class Coleccion
{
    private static Vector vector=new Vector(9);
    
    /**
     * Este es el constructor de la clase y lo que hace es insertar en el
     * vector los 10 enteros desordenados y se imprime por pantalla el
     * contenido del vector.
     */
    public Coleccion()
    {
        vector.clear();
        vector.addElement(new Integer(4));
        vector.addElement(new Integer(7));
        vector.addElement(new Integer(6));
        vector.addElement(new Integer(1));
        vector.addElement(new Integer(2));
        vector.addElement(new Integer(8));
        vector.addElement(new Integer(3));
        vector.addElement(new Integer(5));
        vector.addElement(new Integer(10));
        vector.addElement(new Integer(9));
        // vector={4,7,6,1,2,8,3,5,10,9}
        System.out.print("Vector Desordenado: ");
        for (Enumeration e = vector.elements() ; e.hasMoreElements() ;)
        {
            Integer a;
            a=(Integer)e.nextElement();
            System.out.print(a.intValue()+" ");
        }
        System.out.println();
    }//Coleccion
    
    /**
     * Este método pasa el vector de tipo Vector (objetos Integer) a
     * un array de elementos int (tipo básico entero) para poder
     * ordenarlo.
     * @return int[] es el array con los elementos int del vector.
     */
    public int[] convertirEnArray ()
    {
        Integer a;
        int[] b=new int[10];
        int i=0;
        for (Enumeration e = vector.elements() ; e.hasMoreElements() ;)
        {
            a=(Integer)e.nextElement();
            b[i]=a.intValue();
            i++;
        }
        return b;
    }//convertirEnArray
   
    /**
     * Este método pasa el array b[] pasado como parametro al vector de
     * tipo Vector (objetos Integer) para recorrerlo con un iterator.
     * @param b[] es el array de elementos de tipo int.
     * @return Vector es el vector de elementos Integer.
     */
    public Vector convertirEnVector (int b[])
    {
        Integer a;
        vector.clear();//eliminamos todos los elementos del vector.

        for(int i=0;i<b.length;i++)
        {
            vector.addElement(new Integer(b[i]));
        }
        return vector;
    }//convertirEnVector
   
    /**
     * Retorna un ListIterator que es un interface IFIterator para
     * vectores que permite recorrer el vector. Este interface se obtiene
     * a través del metodo listIterator de la clase Vector pasandole como
     * parámetro La posicion especifica del vector por la que empezar
     * el recorrido.
     * @param index indica la posición del vector por la que empezar el
     * recorrido.
     * @return ListIterator es un interface de tipo ListIterator.
     */
    public ListIterator miiterator(int index)
    {
        return vector.listIterator(index);
    }//miiterator
    
}//class Coleccion
/***************************FIN DE LA CLASE*************************/