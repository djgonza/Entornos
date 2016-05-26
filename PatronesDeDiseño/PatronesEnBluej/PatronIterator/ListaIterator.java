import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Esta clase hereda de Frame y es la que implementa la ventana que
 * sale en la pantalla al ejecutar la aplicación y las opciones que se
 * deben realizar al pulsar las opciones del menu.
 */
public class ListaIterator extends Frame implements ActionListener
{
    private DialogAbout dialog;
    private Coleccion milista=new Coleccion();//crea la lista de 10  elementos.
    private Label recorrido=new Label();
    private Label nodos=new Label();
    private Label num=new Label();
   
    /**
     * Es el constructor de la clase y se encarga de realizar el menu.
     */
    public ListaIterator()
    {
        super("Utilización del patrón Iterator");
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        int resolucionPantallaAlto=d.height;
        int resolucionPantallaAncho=d.width;
        setSize(resolucionPantallaAncho/2, resolucionPantallaAlto/2);
        setLocation(resolucionPantallaAncho/8,resolucionPantallaAlto/8);
        //creacion de menus
        MenuBar mbar= new MenuBar();
        setMenuBar(mbar);
        //Menu Listado
        Menu listadoMenu= new Menu("Listado");
        mbar.add(listadoMenu);
        //opciones del menu listado
        //opcion orden ascendente
        MenuItem ascendenteItem=new MenuItem("Ascendente", new
                MenuShortcut('a'));
        ascendenteItem.addActionListener(this);
        listadoMenu.add(ascendenteItem);
        //opcion orden descendente
        MenuItem descendenteItem=new MenuItem("Descendente", new
                MenuShortcut('d'));
        descendenteItem.addActionListener(this);
        listadoMenu.add(descendenteItem);
        listadoMenu.add("-");
        //opcion salir
        MenuItem salirItem=new MenuItem("Salir", new MenuShortcut('s'));
        salirItem.addActionListener(this);
        listadoMenu.add(salirItem);
        //Menu Ayuda
        Menu AyudaMenu= new Menu("Ayuda");
        mbar.add(AyudaMenu);
        //opciones del menu Ayuda
        //opcion About
        MenuItem aboutItem=new MenuItem("About", new MenuShortcut('b'));
        aboutItem.addActionListener(this);
        AyudaMenu.add(aboutItem);
        addWindowListener (new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    dispose();
                    System.exit(0);
                }
            });
        setLayout(null);
        recorrido.setBounds(50,75,400,40);
        recorrido.setFont(new Font("SansSerif",Font.BOLD,26));
        add(recorrido);
        nodos.setFont(new Font("SansSerif",Font.BOLD,14));
        num.setFont(new Font("SansSerif",Font.ITALIC,14));
    }//ListaIterator
    /****************************************************************/
    /**
     * Es el método principal main de la clase, crea un objeto de esta
    Guía de construcción de software en Java con patrones de diseño
    Francisco Javier Martínez Juan Página 364
     * clase y la visualiza por pantalla con el tamaño deseado.
     */
    public static void main(String args[])
    {
        ListaIterator f = new ListaIterator();
        f.setSize(600,400);
        f.show();
    }//main(String)
   
    /**
     * Este método dicta lo que se ha de hacer cada vez que se
     * selecciona alguna opción del menu.
     */
    public void actionPerformed (ActionEvent e)
    {
        String seleccion=e.getActionCommand();
        Integer numero=new Integer(0);
        int nume;
        if ("Salir".equals(seleccion))//item Salir
        {
            System.exit(0);
        }
        else if ("Ascendente".equals(seleccion))//item Ascendente
        {
            recorrido.setText("RECORRIDO ASCENDENTE");
            nodos.setText("Nodo1 Nodo2 Nodo3 Nodo4 Nodo5 Nodo6 Nodo7 Nodo8 Nodo9 Nodo10");
            nodos.setBounds(50,200,550,30);
            add(nodos);
            //conseguimos el iterador para recorrer la lista ascendentemente
            ListIterator ascendente=milista.miiterator(0);
            num.setText("");
            //recorremos la lista ascendentemente mientras existan elementos
            while (ascendente.hasNext())
            {
                numero=(Integer)ascendente.next();
                nume=numero.intValue();
                num.setText(num.getText()+" "+Integer.toString(nume));
            }
            num.setBounds(30,225,550,30);
            add(num);
        }
        else if ("Descendente".equals(seleccion))//item descendente
        {
            recorrido.setText("RECORRIDO DESCENDENTE");
            nodos.setText("Nodo10 Nodo9 Nodo8 Nodo7 Nodo6 Nodo5 Nodo4 Nodo3 Nodo2 Nodo1");
            nodos.setBounds(50,200,550,30);
            add(nodos);
            //conseguimos el iterador para recorrer la lista descendentemente
            ListIterator descendente=milista.miiterator(10);
            num.setText("");
            //recorremos la lista descendentemente mientras existan elementos
            while (descendente.hasPrevious())
            {
                numero=(Integer)descendente.previous();
                nume=numero.intValue();
                num.setText(num.getText()+"  "+Integer.toString(nume));
            }
            num.setBounds(30,225,550,30);
            add(num);
        }
        else if ("About".equals(seleccion))//item About
        {
            int resolucionPantallaAlto=this.getSize().height;
            int resolucionPantallaAncho=this.getSize().width;
            dialog=new DialogAbout(this);
            dialog.setLocation(resolucionPantallaAncho/3,resolucionPantallaAlto/2)
            ;
            dialog.show();
        }
    }//actionPerformed(ActionEvent)
   
}//class ListaIterator
/***********************FIN DE LA CLASE******************************/