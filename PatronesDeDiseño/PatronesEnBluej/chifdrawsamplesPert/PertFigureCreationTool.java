
/*
 * @(#)PertFigureCreationTool.java 5.1
 *
 */
//package CH.ifa.draw.samples.pert;
import java.awt.*;
import CH.ifa.draw.framework.*;
import CH.ifa.draw.standard.*;
/**
 * Clase PertFigureCreationTool
Una versión más eficiente de la herramienta de creación Pert que no esta basada en la
clonación.
Se encuentra en el fichero PertFigureCreationTool.java y su contenido es el siguiente:
 */

public class PertFigureCreationTool extends CreationTool 
{
    public PertFigureCreationTool(DrawingView view) 
    {
        super(view);
    }

    /**
     * Creates a new PertFigure.
     */
    protected Figure createFigure()
    {
        return new PertFigure();
    }
}