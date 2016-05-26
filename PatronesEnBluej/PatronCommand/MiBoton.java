import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiBoton extends JButton implements Command 
{
    Random r = new Random();
    public MiBoton(String caption) 
    {
        super(caption);
    }
    //.......
    public void execute() 
    {
        setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
    }
}