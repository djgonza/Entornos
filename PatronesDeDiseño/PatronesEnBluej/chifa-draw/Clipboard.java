
/*
 * @(#)Clipboard.java 5.1
 *
 */
//package CH.ifa.draw.util;
import java.awt.*;
import java.util.*;
/**
Clase Clipboard
Un suplente temporal para un portapapeles global. Es un singleton que puede ser utilizado
para almacenar y conseguir los contenidos del portapapeles.
Se encuentra en el fichero Clipboard.java y su contenido es el siguiente:
 */
public class Clipboard
{
    static Clipboard fgClipboard = new Clipboard();

    /**
     * Gets the clipboard.
     */
    static public Clipboard getClipboard()
    {
        return fgClipboard;
    }
    
    private Object fContents;
    
    private Clipboard()
    {  }

    /**
     * Sets the contents of the clipboard.
     */
    public void setContents(Object contents)
    {
        fContents = contents;
    }

    /**
     * Gets the contents of the clipboard.
     */
    public Object getContents()
    {
        return fContents;
    }
}