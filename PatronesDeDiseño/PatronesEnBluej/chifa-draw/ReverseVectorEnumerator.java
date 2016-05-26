
/*
 * @(#)ReverseVectorEnumerator.java 5.1
 *
 */
//package CH.ifa.draw.util;
import java.util.*;
/**
 * Clase ReverseVectorEnumerator
Un Enumeration que enumera un vector desde atrás (size-1) hacia delante (0).
Se encuentra en el fichero ReverseVectorEnumerator.java y su contenido es el siguiente:
 */
public class ReverseVectorEnumerator implements Enumeration 
{
    Vector vector;
    int count;
    public ReverseVectorEnumerator(Vector v)
    {
        vector = v;
        count = vector.size() - 1;
    }

    public boolean hasMoreElements() {
        return count >= 0;
    }

    public Object nextElement() {
        if (count >= 0) {
            return vector.elementAt(count--);
        }
        throw new NoSuchElementException("ReverseVectorEnumerator");
    }
}