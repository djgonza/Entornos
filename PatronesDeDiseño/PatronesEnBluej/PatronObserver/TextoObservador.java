import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

/**
 * Esta clase representa un observador (Observer) que es un TextField,
 * que es un campo de entrada de texto de una sola linea.
 * Esta linea de texto aparecerá en una ventana independiente.
 * Se crea un nuevo objeto de esta clase, es decir una nueva
 * línea de entrada de texto cada vez que se pulse el botón
 * "Nuevo Observador Texto".
 */
public class TextoObservador extends Frame implements Observer
{
    private ValorObservable vo = null;
    private TextoObservador to;
    private TextField tf = null;
    private Label l = null;
    private int nInferior = 0;
    private int nSuperior = 0;

    /**
     * Constructor en el que creamos una ventana donde poder
     * introducir el valor numerico que represente la
     * cantidad que corresponda al objeto observable.
     */
    public TextoObservador( ValorObservable vo )
    {
        super("Observador de Texto");
        this.vo = vo;
        setLayout( new GridLayout( 0,1 ) );
        nInferior = vo.getLimiteInferior();
        nSuperior = vo.getLimiteSuperior();
        tf = new TextField( String.valueOf( vo.getValor() ) );
        tf.addActionListener(new ManejadorTextField());
        add( tf );
        l = new Label();
        add( l );
        setSize(300,100);
        addWindowListener (new WindowEventHandler());
        show();
    }//TextoObservador(ValorObservable)

    /**
     * Actualizamos el valor del objeto que estamos observando
     * en nuestro campo de texto, para reflejar el valor actual
     * del objeto.
     */
    public void update( Observable obs,Object obj )
    {
        if( obs == vo )
            tf.setText( String.valueOf( vo.getValor() ) );
    }//update(Observable, Object)

    /**
     * Esta clase maneja los events que se producen en el campo
     * de texto.
     */
    class ManejadorTextField implements ActionListener
    {

        /**
         * Controlamos el evento que proviene del campo de texto,
         * cuando se introduce un valor numerico.
         */
        public void actionPerformed( ActionEvent e)
        {
            int n = 0;
            boolean bValido = false;
            try
            {
                n = Integer.parseInt( tf.getText() );
                bValido = true;
            }
            catch( NumberFormatException nfe )
            {
                bValido = false;
            }
            // Comprobamos que no se sobrepasen los limites que hemos
            // fijado
            if( n < nInferior || n > nSuperior )
                bValido = false;
            if( bValido )
            {
                vo.setValor( n );
                l.setText( "" );
            }
            else
                l.setText( "Valor no válido -> inténtelo de nuevo: ["+nInferior+"-"+nSuperior+"]" );
        }//actionPerformed(ActionEvent)

    }//class ManejadorTextField

    /**
     * Esta clase maneja los eventos que se producen sobre la
     * ventana del campo de texto.
     */
    class WindowEventHandler extends WindowAdapter
    {
        /**
         * Controlamos el cierre de la ventana, para eliminar el
         * objeto que hemos creado antes de hacer desaparecer
         * la ventana.
         */
        public void windowClosing( WindowEvent e )
        {
            vo.deleteObserver(to);
            dispose();
        }//windowClosing(WindowEvent)
    }//class WindowEventHandler
}//class TextoObservador

/*************************FIN DE LA CLASE****************************/
