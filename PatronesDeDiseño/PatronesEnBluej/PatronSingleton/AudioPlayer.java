import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/**
 * Esta clase es la que implementa el applet. Desde aqui se
 * controlan los audios a traves de la clase ManejadorAudio.
 */
public class AudioPlayer extends Applet
{
    /** maneja es la referencia al unico objeto que existe de la
     * clase ManejadorAudio que lo obtiene a través del metodo
     * getInstancia de la clase ManejadorAudio
     */
    ManejadorAudio maneja = ManejadorAudio.getInstancia();
    
    private AudioClip audio;
    private Image fondo;

    /**
     * Este método es el que inicializa el applet y muestra
     * en la pantalla los botones y los radio botones.
     */
    public void init()
    {
        setLayout(new BorderLayout());
        Panel botones= new Panel();
        
        Button botonPlay = new Button("Play");
        Button botonStop = new Button("Stop");
        Button botonLoop = new Button("Loop");
        
        botonPlay.addActionListener(new HandlerBotones());
        botonStop.addActionListener(new HandlerBotones());
        botonLoop.addActionListener(new HandlerBotones());
        
        botones.add(botonPlay);
        botones.add(botonStop);
        botones.add(botonLoop);
        
        add("South",botones);
        
        Panel radioboton= new Panel();
        CheckboxGroup grupo = new CheckboxGroup();
        
        Checkbox radio1= new Checkbox("Audio1",grupo,false);
        Checkbox radio2= new Checkbox("Audio2",grupo,false);
        
        radio1.addItemListener (new HandlerCheckbox());
        radio2.addItemListener (new HandlerCheckbox());
        
        radioboton.add(radio1);
        radioboton.add(radio2);
        
        add("East", radioboton);
    }//init
    /**
     * Este metodo se ejecuta cuando se para el applet y lo
     * que hace es parar el audio si esta sonando.
     */
    public void stop()
    {
        maneja.stop();
    }//stop
    /**
     * Esta clase es la que pinta en la pantalla, pone el nombre
     * AUDIO PLAYER y visualiza una foto si esta asignada a la
     * variable fondo de tipo image.
     */
    public void paint(Graphics g)
    {
        Font tipofuente= new Font("SansSerif", Font.BOLD, 25);
        g.setFont(tipofuente);
        g.setColor(Color.blue);
        g.drawString("AUDIO PLAYER (Patrón Singleton)", 30, 30);
        if (fondo!=null)
            g.drawImage(fondo,31,35,this);
    }//paint

    /**
     * Esta clase controla los eventos sobre los botones.
     */
    class HandlerBotones implements ActionListener
    {
        /**
         * Este metodo dicta lo que se ha de hacer cuando se pulsa
         * alguno de los tres botones: play, stop y loop.
         */
        public void actionPerformed(ActionEvent e)
        {
            String s = e.getActionCommand();
            if      ("Play".equals(s))         maneja.play(audio);
            else if ("Stop".equals(s))         maneja.stop();
            else if ("Loop".equals(s))         maneja.loop(audio);
        }//actionPerformed
    }//class HndlerBotones
    
    /**
     * Esta clase controla los eventos sobre los radio botones.
     */
    class HandlerCheckbox implements ItemListener
    {
        /**
         * Este método dicta lo que se hace cuando se selecciona alguno
         * de los dos radio botones: audio1 y audio2.
         */
        public void itemStateChanged (ItemEvent e)
        {
            String s;
            Graphics g;
            Checkbox checkbox = (Checkbox) e.getItemSelectable();
            if(checkbox.getState())
            {
                s = checkbox.getLabel();
                if ("Audio1".equals(s))
                {
                    audio = getAudioClip(getCodeBase(),"audio/guitarra.au");
                    maneja.play(audio);
                    fondo = getImage(getCodeBase(),"paris.jpg");
                    repaint();
                }
                else
                {
                    audio = getAudioClip(getCodeBase(), "audio/spacemusic.au");
                    maneja.play(audio);
                    fondo = getImage(getCodeBase(),"playa.jpg");
                    repaint();
                }
            }
        }//itemStateChanged
       
    }
    //class HandlerCheckbox

}// class AudioPlayer

/***************************FIN DE LA CLASE*****************************/
/**
    Página web AudioPlayer
    Se encuentra en el fichero AudioPlayer.html y su contenido es el siguiente:
    <HTML>
        <HEAD>
            <TITLE> Audio Player</TITLE>
        </HEAD>
        <BODY>
            <APPLET CODE="AudioPlayer.class" WIDTH="600" HEIGHT="400">
            </APPLET>
        </BODY>
    </HTML>
*/