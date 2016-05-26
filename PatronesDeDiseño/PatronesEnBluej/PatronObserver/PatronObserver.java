import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
/**
 * Esta clase hereda de Frame y es la que implementa la ventana que
 * sale en la pantalla al ejecutar la aplicación y las opciones que se
 * deben realizar al pulsar los botones y las opciones del menú.
 */
public class PatronObserver extends Frame implements ActionListener
{
    private DialogAbout dialog;
    private Button bObservTexto;
    private Button bObservBarra;
    private ValorObservable vo;
    private Label titulo=new Label();
    /**
     * Es el constructor de la clase y se encarga de realizar el menu.
     */
    public PatronObserver()
    {
        super("Utilización del patrón Observer");
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        int resolucionPantallaAlto=d.height;
        int resolucionPantallaAncho=d.width;
        setSize(resolucionPantallaAncho/2, resolucionPantallaAlto/2);
        setLocation(resolucionPantallaAncho/8,
            resolucionPantallaAlto/8);
        setBackground( Color.white );
        //creacion de menus
        MenuBar mbar= new MenuBar();
        setMenuBar(mbar);
        //Menu Salir
        Menu salirMenu= new Menu("Salir");
        mbar.add(salirMenu);
        //opciones del menu Salir
        //opcion salir
        MenuItem salirItem=new MenuItem("Salir", new MenuShortcut('s'));
        salirItem.addActionListener(this);
        salirMenu.add(salirItem);
        //Menu Ayuda
        Menu AyudaMenu= new Menu("Ayuda");
        mbar.add(AyudaMenu);
        //opciones del menu Ayuda
        //opcion About
        MenuItem aboutItem=new MenuItem("About", new MenuShortcut('b'));
        aboutItem.addActionListener(this);
        AyudaMenu.add(aboutItem);
        setLayout(null);
        titulo.setBounds(150,75,300,40);
        titulo.setFont(new Font("SansSerif",Font.BOLD,26));
        titulo.setText("PATRÓN OBSERVER");
        add(titulo);
        bObservTexto = new Button( "Nuevo Observador Texto" );
        bObservBarra = new Button( "Nuevo Observador Barra" );
        vo = new ValorObservable( 0,0,1000 );
        bObservTexto.setBounds( 125,300,150,30);
        bObservBarra.setBounds(300,300,150,30);
        bObservTexto.setBackground( Color.lightGray );
        bObservBarra.setBackground( Color.lightGray );
        add( bObservTexto );
        bObservTexto.addActionListener(this);
        add( bObservBarra );
        bObservBarra.addActionListener(this);
        addWindowListener (new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    dispose();
                    System.exit(0);
                }
            });
    }//PatronObserver

    /**
     * Es el método principal main de la clase, crea un objeto de esta
     * clase y la visualiza por pantalla con el tamaño deseado.
     */
    public static void main(String args[])
    {
        PatronObserver f = new PatronObserver();
        f.setSize(600,400);
        f.setVisible(true);
    }//main(String)

    /**
     * Este método dicta lo que se ha de hacer cada vez que se
     * selecciona alguna opción del menú o se pulsa alguno de los
     * botones.
     */
    public void actionPerformed (ActionEvent e)
    {
        String s=e.getActionCommand();
        if( "Nuevo Observador Texto".equals(s) )//botón Nuevo Observador texto
        {
            TextoObservador textoObserv = new TextoObservador( vo );
            vo.addObserver( textoObserv );
        }
        else if("Nuevo Observador Barra".equals(s))//botón Nuevo  Observador Barra
        {
            BarraObservador barraObserv = new BarraObservador( vo );
            vo.addObserver( barraObserv );
        }
        if ("Salir".equals(s))//item Salir
        {
            System.exit(0);
        }
        else if ("About".equals(s))//item About
        {
            int resolucionPantallaAlto=this.getSize().height;
            int resolucionPantallaAncho=this.getSize().width;
            dialog=new DialogAbout(this);
            dialog.setLocation(resolucionPantallaAncho/3,resolucionPantallaAlto/2)
            ;
            dialog.setVisible(true);
        }
    }//actionPerformed(ActionEvent)
}//class PatronObserver
/************************FIN DE LA CLASE*****************************/