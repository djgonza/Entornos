
/*
 * @(#)Command.java 5.1
 *
 */
 
import java.awt.*;
import java.util.*;
/**
 * Clase Command
Los comandos encapsulan una acción para ser ejecutada. Los comandos tienen un nombre y
pueden ser utilizados en conjunción con los componentes de los interfases del usuario
Command enabled.
Patrones de diseño
Command Command es una simple instancia del patrón Command sin soportar la
operación undo (deshacer).
Se encuentra en el fichero Command.java y su contenido es el siguiente:
 *
 * @see CommandButton
 * @see CommandMenu
 * @see CommandChoice
 */
public abstract class Command
{

    private String fName;
    
    /**
     * Constructs a command with the given name.
     */
    public Command(String name)
    {
        fName = name;
    }

    /**
     * Executes the command.
     */
    public abstract void execute();

    /**
     * Tests if the command can be executed.
     */
    public boolean isExecutable()
    {
        return true;
    }

    /**
     * Gets the command name.
     */
    public String name()
    {
        return fName;
    }
}