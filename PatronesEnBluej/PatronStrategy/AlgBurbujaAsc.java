/**
 * Ordena un vector por el metodo de la Burbuja ascendentemente.
 */
class AlgBurbujaAsc implements Ordenacion
{
    /**
     * Ordena un vector por el método de la Burbuja descendentemente.
     * @param a[] el vector a ordenar.
     * @return int[] el vector ordenado.
     */
    public int[] ordenar(int a[])
    {
        for (int i = 1; i <= a.length; ++i)
            for (int j = (a.length) -1; j>= i; --j)
               if (a[j-1] > a[j])
                {   int T = a[j-1];
                    a[j-1] = a[j];
                    a[j] = T;
                }
        return a;
    }//ordenar
}//class AlgBurbujaAsc
/**********************FIN DE LA CLASE*****************************/