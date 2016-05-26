
/*
 * @(#)CommandChoice.java 5.1
 *
 */
//package CH.ifa.draw.util;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
/**
 * Clase CommandChoice
Un Command habilita la elección. Al seleccionar una opción se ejecuta el comando
correspondiente.
Se encuentra en el fichero CommandChoice.java y su contenido es el siguiente:
 *
 * @see Command
 */
public class CommandChoice extends Choice implements ItemListener 
{

    private Vector fCommands;
    public CommandChoice()
    {
        fCommands = new Vector(10);
        addItemListener(this);
    }

    /**
     * Adds a command to the menu.
     */
    public synchronized void addItem(Command command)
    {
        addItem(command.name());
        fCommands.addElement(command);
    }

    /**
     * Executes the command.
     */
    public void itemStateChanged(ItemEvent e)
    {
        Command command =
            (Command)fCommands.elementAt(getSelectedIndex());
        command.execute();
    }
}