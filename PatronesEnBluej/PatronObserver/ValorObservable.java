import java.util.Observable;
/**
 * Esta clase representa la clase Observable y es la que
 * notifica a los observadores (Observers) que estan
 * pendientes de los cambios de estado de esta clase, que
 * su estado se ha visto alterado.
 */
public class ValorObservable extends Observable
{
    private int nValor = 0;
    private int nInferior = 0;
    private int nSuperior = 0;

    /**
     * Constructor al que indicamos el valor en que comenzamos
     * y los limites inferior y superior que no deben
     * sobrepasarse.
     */
    public ValorObservable( int nValor,int nInferior,int nSuperior )
    {
        this.nValor = nValor;
        this.nInferior = nInferior;
        this.nSuperior = nSuperior;
    }//ValorObservable(int, int, int)

    /**
     * Fija el valor que le pasamos y notifica a los observadores que
     * estan pendientes del cambio de estado de los objetos de esta
     * clase, que su estado se ha visto alterado.
     */
    public void setValor(int nValor)
    {
        this.nValor = nValor;
        super.setChanged();
        super.notifyObservers();
    }//setValor(int)

    /**
     * Devuelve el valor actual que tiene el objeto.
     */
    public int getValor()
    {
        return( nValor );
    }//getValor

    /**
     * Devuelve el limite inferior del rango de valores en los que se
     * ha de mover el objeto.
     */
    public int getLimiteInferior()
    {
        return( nInferior );
    }//getLimiteInferior
    /**
     * Devuelve el limite superior del rango de valores en los que se
     * ha de mover el objeto.
     */
    public int getLimiteSuperior()
    {
    return( nSuperior );
    }//getLimiteSuperior

}//class ValorObservable
/**********************FIN DE LA CLASE****************************/
