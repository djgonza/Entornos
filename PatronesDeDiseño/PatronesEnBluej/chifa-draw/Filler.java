
/*
 * @(#)Filler.java 5.1
 *
 */
 
import java.awt.*;
/**
 *Clase Filler
Un componente que puede ser utilizado para reservar espacio en blanco en un layout.
Se encuentra en el fichero Filler.java y su contenido es el siguiente:
 */
public class Filler extends Canvas
{
    private int fWidth;
    private int fHeight;
    private Color fBackground;

    public Filler(int width, int height) 
    {
        this(width, height, null);
    }

    public Filler(int width, int height, Color background)
    {
        fWidth = width;
        fHeight = height;
        fBackground = background;
    }

    public Dimension getMinimumSize() 
    {
        return new Dimension(fWidth, fHeight);
    }

    public Dimension getPreferredSize()
    {
        return getMinimumSize();
    }

    public Color getBackground() 
    {
        if (fBackground != null)
            return fBackground;
        return super.getBackground();
    }
}