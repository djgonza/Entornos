/**
 * Esta clase controla la selección y uso del objeto particular
 * strategy. Es decir mediante esta clase se selecciona el algoritmo
 * a utilizar en nuestro caso AlgBurbujaAsc o AlgBurbujaDesc y se
 * llama a su método ordenar correspondiente.
 */
public class Algoritmos
{
    private Ordenacion algoritmo; //referencia al interface Ordenacion.
    
    /**
     * Constructor de la clase.
     * @param alg es un objeto de tipo ordenacion con el cual
     * seleccionamos el algoritmo que queremos utilizar.
     */
    public Algoritmos(Ordenacion alg)
    {
        algoritmo = alg;
    }//Algoritmos
   
    /**
     * Con este método llamamos al método ordenar del algoritmo elegido.
     * @param a[] el vector a ordenar.
     * @return int[] el vector ordenado.
     */
    public int[] ordena (int[] a)
    {
        return algoritmo.ordenar(a);
    }//ordena
    
    /**
     * Este método sirve para cambiar la selección del algoritmo.
     * @param nuevoAlgoritmo el nuevo algoritmo seleccionado.
     */
    public void cambiarAlgoritmo (Ordenacion nuevoAlgoritmo)
    {
        algoritmo = nuevoAlgoritmo;
    }//cambiarAlgoritmo
    
}//class Algoritmos
/********************FIN DE LA CLASE **************************/