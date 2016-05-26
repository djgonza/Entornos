import java.awt.*;
import java.awt.event.*;
/**
 * Esta clase implementa el cuadro de dialogo que sale por pantalla
 * al pulsar en el menu Ayuda el item About o las teclas control+b
 */
public class DialogAbout extends Dialog
{
    static int HOR_TAMANO = 450;//tamaño en horizontal del cuadro
    static int VER_TAMANO = 200;//tamaño en vertical del cuadro
    
    /**
     * Es el constructor de la clase.
     */
    public DialogAbout( Frame parent )
    {
        super( parent,"About",true);
        this.setResizable( false );
        setBackground( Color.lightGray);
        setLayout( new BorderLayout() );
        Panel p = new Panel();
        Button b=new Button("Aceptar");
        b.addActionListener(new DialogHandler());
        p.add(b);
        add( "South",p );
        setSize( HOR_TAMANO,VER_TAMANO );
        addWindowListener(new WindowAdapter()
        {    public void windowClosing (WindowEvent e)
                {
                    dispose();
                }
        });
    }//DialogAbout(Frame)
   
    /**
     * Este método pinta en el cuadro las frases que aparecen en
     * él, en la posición deseada y con el color y fuentes
    Guía de construcción de software en Java con patrones de diseño
    Francisco Javier Martínez Juan Página 379
     * deseados.
     */
    public void paint( Graphics g )
    {
        g.setColor( Color.black );
        Font f=new Font("SansSerif",Font.BOLD,14);
        g.setFont(f);
        g.drawString( "Ordenación de un vector de forma ascendente y descendente",
        (HOR_TAMANO/HOR_TAMANO)+5,VER_TAMANO/3 );
        g.drawString( "Patrones utilizados: STRATEGY e ITERATOR",
            HOR_TAMANO/5,VER_TAMANO/3+40 );
        Font f1=new Font("TimesRoman",Font.ITALIC,12);
        g.setFont(f1);
        g.drawString( "Autor: Francisco Javier Martínez Juan",
            HOR_TAMANO/3,VER_TAMANO/3+80 );
    }//paint(Graphics)
    
    /**
     * Esta clase es la que maneja los eventos que ocurren sobre el
     * cuadro de dialogo.
     */
    class DialogHandler implements ActionListener
    {
        /**
         * Este método cierra el cuadro al pulsar el boton Aceptar.
         */
        public void actionPerformed (ActionEvent e)
        {
            dispose();
        }
    }
}//class DialogAbout
/**************** FIN DE LA CLASE ************************************/