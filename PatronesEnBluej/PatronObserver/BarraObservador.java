import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
/**
 * Esta clase representa un observador (Observer) que es una barra de
 * desplazamiento. Esta barra de desplazamiento aparecerá
 * en una ventana independiente. Se crea un nuevo objeto
 * de esta clase es decir una nueva barra de desplazamiento
 * cada vez que se pulse el botón "Nuevo Observador Barra".
 */
public class BarraObservador extends Frame implements Observer
{
    private ValorObservable vo = null;
    private BarraObservador bo;
    private Scrollbar sb = null;

    /**
     * Constructor que presenta una ventanita con la barra de
     * desplazamiento para poder ir alterando los valores del
     * objeto observable.
     */
    public BarraObservador( ValorObservable vo )
    {
        super( "Observador de Barra" );
        this.vo = vo;
        setLayout( new GridLayout( 0,1 ) );
        sb = new Scrollbar( Scrollbar.HORIZONTAL,vo.getValor(),1,
            vo.getLimiteInferior(),vo.getLimiteSuperior() );
        sb.addAdjustmentListener(new ManejadorScrolling());
        add( sb );
        setSize(300,100);
        addWindowListener (new WindowEventHandler());
        show();
    }//BarraObservador(ValorObservable)

    /**
     * Actualizamos el valor que corresponde al número que
     * actualmente tiene el objeto que estamos observando.
     */
    public void update( Observable obs,Object obj )
    {
        if( obs == vo )
            sb.setValue( vo.getValor() );
    }//update(Observable, Object)

    /**
     * Esta clase maneja los eventos que se producen sobre la
     * barra de desplazamiento.
     */
    class ManejadorScrolling implements AdjustmentListener
    {
        /**
         * Manejamos los eventos que se producen al manipular la
         * barra. Cuando desplazamos el marcador de la barra, vamos
         * actualizando el valor del objeto observable y presentamos
         * el valor que se ha adquirido.
         */
        public void adjustmentValueChanged( AdjustmentEvent e)
        {
            if     ( e.UNIT_INCREMENT ==  AdjustmentEvent.UNIT_INCREMENT )      vo.setValor( sb.getValue() );
            else if( e.UNIT_DECREMENT ==  AdjustmentEvent.UNIT_DECREMENT )      vo.setValor( sb.getValue() );
            else if( e.BLOCK_INCREMENT == AdjustmentEvent.BLOCK_INCREMENT )     vo.setValor( sb.getValue() );
            else if( e.BLOCK_DECREMENT == AdjustmentEvent.BLOCK_DECREMENT )     vo.setValor( sb.getValue() );
            else if( e.TRACK == AdjustmentEvent.TRACK )                         vo.setValor( sb.getValue() );
        }//adjustmentValueChanged(AdjustmentEvent)
    }//class ManejadorScrolling

    /**
     * Esta clase maneja los eventos sobre la ventana de la
     * barra de desplazamiento.
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
            vo.deleteObserver(bo);
            dispose();
        }//windowClosing(WindowEvent)
    }//class WindowEventHandler
}//class BarraObservador
/*****************FIN DE LA CLASE*********************************/