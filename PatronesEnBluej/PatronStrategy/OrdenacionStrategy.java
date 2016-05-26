import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Esta clase hereda de Frame y es la que implementa la ventana que
 * sale en la pantalla al ejecutar la aplicación y las opciones que se
 * deben realizar al pulsar las opciones del menu.
 */
public class OrdenacionStrategy extends Frame implements ActionListener
{
    private DialogAbout dialog;
    private Coleccion mivector;
    private Algoritmos algOrdenacion;
    //para seleccionar y utilizar el algoritmo deseado.
    private Label ordenacion=new Label();
    private Label nodos=new Label();
    private Label num=new Label();
    /********************************************************************/
    /**
     * Es el constructor de la clase y se encarga de realizar el menu.
     */
    public OrdenacionStrategy()
    {
        super("Utilización de los patrones Strategy e Iterator");
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        int resolucionPantallaAlto=d.height;
        int resolucionPantallaAncho=d.width;
        setSize(resolucionPantallaAncho/2, resolucionPantallaAlto/2);
        setLocation(resolucionPantallaAncho/8,resolucionPantallaAlto/8);
        //creacion de menus
        MenuBar mbar= new MenuBar();
        setMenuBar(mbar);
        //Menu Ordenación
        Menu ordenacionMenu= new Menu("Ordenación");
        mbar.add(ordenacionMenu);
        //opciones del menu Ordenacion
        //opcion orden ascendente
        MenuItem ascendenteItem=new MenuItem("Ascendente", new MenuShortcut('a'));
        ascendenteItem.addActionListener(this);
        ordenacionMenu.add(ascendenteItem);
        //opcion orden descendente
        MenuItem descendenteItem=new MenuItem("Descendente", new MenuShortcut('d'));
        descendenteItem.addActionListener(this);
        ordenacionMenu.add(descendenteItem);
        ordenacionMenu.add("-");
        //opcion salir
        MenuItem salirItem=new MenuItem("Salir", new MenuShortcut('s'));
        salirItem.addActionListener(this);
        ordenacionMenu.add(salirItem);
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
                {   dispose();
                    System.exit(0);
                }
            });
        setLayout(null);
        ordenacion.setBounds(50,75,400,40);
        ordenacion.setFont(new Font("SansSerif",Font.BOLD,26));
        add(ordenacion);
        nodos.setFont(new Font("SansSerif",Font.BOLD,14));
        num.setFont(new Font("SansSerif",Font.ITALIC,14));
    }//OrdenacionStrategy
    /*****************************************************************/
    /**
     * Es el método principal main de la clase, crea un objeto de esta
     * clase y la visualiza por pantalla con el tamaño deseado.
     */
    public static void main(String args[])
    {
        OrdenacionStrategy f = new OrdenacionStrategy();
        f.setSize(600,400);
        f.show();
    }//main(String)
    /*****************************************************************/
    /**
     * Este método dicta lo que se ha de hacer cada vez que se
     * selecciona alguna opción del menu.
     */
    public void actionPerformed (ActionEvent e)
    {
        String seleccion=e.getActionCommand();
        int[] miarray=new int[10];
        Integer numero=new Integer(0);
        int nume;
        if ("Salir".equals(seleccion))//item Salir
           System.exit(0);
        else if ("Ascendente".equals(seleccion))//item Ascendente
        {
            ordenacion.setText("ORDENACIÓN ASCENDENTE");
            nodos.setText("Nodo1 Nodo2 Nodo3 Nodo4 Nodo5 Nodo6 Nodo7 Nodo8 Nodo9 Nodo10");
            nodos.setBounds(50,200,550,30);
            add(nodos);
            mivector=new Coleccion();//crea el vector de 10 elementos.
            //Seleccionamos el algoritmo deseado.
            algOrdenacion=new Algoritmos(new AlgBurbujaAsc());
            //Y utilizamos el algoritmo deseado.
            miarray=algOrdenacion.ordena(mivector.convertirEnArray());
            mivector.convertirEnVector(miarray);
            //conseguimos el iterador para recorrer la lista ascendentemente
            ListIterator ascendente=mivector.miiterator(0);
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
            ordenacion.setText("ORDENACIÓN DESCENDENTE");
            nodos.setText("Nodo1 Nodo2 Nodo3 Nodo4 Nodo5 Nodo6 Nodo7 Nodo8 Nodo9 Nodo10");
            nodos.setBounds(50,200,550,30);
            add(nodos);
            mivector=new Coleccion();//crea el vector de 10 elementos.
            //Seleccionamos el algoritmo deseado.
            algOrdenacion=new Algoritmos(new AlgBurbujaDesc());
            // Y utilizamos el algoritmo deseado.
            miarray=algOrdenacion.ordena(mivector.convertirEnArray());
            mivector.convertirEnVector(miarray);
            //conseguimos el iterador para recorrer la lista ascendentemente
            ListIterator ascendente=mivector.miiterator(0);
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
        else if ("About".equals(seleccion))//item About
        {
            int resolucionPantallaAlto=this.getSize().height;
            int resolucionPantallaAncho=this.getSize().width;
            dialog=new DialogAbout(this);
            dialog.setLocation(resolucionPantallaAncho/3,resolucionPantallaAlto/2);
            dialog.show();
        }
    }//actionPerformed(ActionEvent)
    
}//class OrdenacionStrategy
/************************FIN DE LA CLASE****************************/
