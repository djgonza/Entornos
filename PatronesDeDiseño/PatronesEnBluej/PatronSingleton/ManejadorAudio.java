import java.applet.AudioClip;
/**
 * Esta clase es utilizada para evitar que dos audio clips
 * suenen a la vez. La clase tiene una sola instancia a la
 * que se puede acceder a través de su metodo getInstancia.
 * Cuando pones audio clips a traves de ese objeto, este detiene
 * el ultimo audio clip que se esta escuchando antes de empezar
 * el nuevo audio demandado. Si todos los audio clips se ponen
 * a través del objeto instancia entonces nunca habrá mas
 * de un adio clip sonando al mismo tiempo.
 */
public class ManejadorAudio implements AudioClip
{
    private static  ManejadorAudio  instancia = new ManejadorAudio();
    private AudioClip audioAnterior; //la petición anterior de audio
    
    /**
     * Definimos un constructor privado, por lo tanto no se generará
     * un  constructor publico por defecto.
     */
    private ManejadorAudio()
    {
    }//ManejadorAudio()

    /**
     * Retorna una referencia a la unica instancia de la clase
     * ManejadorAudio
     * @return ManejadorAudio la unica instancia de la clase
     * ManejadorAudio
     */
    public static ManejadorAudio getInstancia()
    {
        return instancia;
    }//getInstancia()

    /**
     * Empieza la ejecución del audio seleccionado. Cada vez que se
     * llama a este metodo el audio comienza desde el principio.
     */
    public void play()
    {
        if (audioAnterior != null)
            audioAnterior.play();
    }//play()

    /**
     * Para la ejecución del audio que se esta escuchando y empieza el
     * audio pasado como parametro.
     * @param audio el nuevo audio a escuchar.
     */
    public void play(AudioClip audio)
    {
        if (audioAnterior != null)
            audioAnterior.stop();
        if (audio != null)
        {
            audioAnterior = audio;
            audio.play();
        }
    }//play(AudioClip)

    /**
     * Se escucha el audio en un bucle.
     */
    public void loop()
    {
        if (audioAnterior != null)
            audioAnterior.loop();
    }//loop()

    /**
     * Para la ejecución del audio que se esta escuchando y empieza el
     * audio pasado como parametro en un bucle.
     * @param audio el nuevo audio a escuchar en un bucle.
     */
    public void loop (AudioClip audio)
    {
        if (audioAnterior != null)
            audioAnterior.stop();
        if (audio != null)
        {
            audioAnterior = audio;
            audio.loop();
        }
    }//loop(AudioClip)

    /**
     * Para la ejecucion del audio.
     */
    public void stop()
    {
        if (audioAnterior != null)
            audioAnterior.stop();
    }//stop
}//class ManejadorAudio

/********************FIN DE LA CLASE***********************/
