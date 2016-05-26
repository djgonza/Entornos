import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiFrame extends JFrame implements ActionListener
{
    public MiFrame()
    {
        MiBoton b = new MiBoton("Pulsame ya");
        b.addActionListener(this);
        this.getContentPane().add(b);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) 
    {
        Command accion = (Command) e.getSource();
        accion.execute();
    }
}