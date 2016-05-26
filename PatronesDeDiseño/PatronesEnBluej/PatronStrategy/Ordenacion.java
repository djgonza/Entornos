/**
 * Este interface proporciona una forma común para acceder al
 * algoritmo de ordenación encapsulado en sus subclases, es decir
 * en las clases que implementan el interface.
 */
interface Ordenacion
{
    /**
     * Este método es el que se utiliza para ejecutar cualquiera
     * de los algoritmos de ordenación y será implementado por el
     * algoritmo de ordenación determinado.
     */
    public int[] ordenar(int a[]);
}//interface Ordenacion
/********************FIN DEL INTERFACE***************************/