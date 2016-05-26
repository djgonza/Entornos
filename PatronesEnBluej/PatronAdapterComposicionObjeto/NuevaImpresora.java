import java.awt.Font;

public class NuevaImpresora implements ImprimeColor
{
    ViejaImpresora vieja = new ViejaImpresora();

    public void setColor(int r, int g, int b)
    {
        vieja.setGrayscale((r+g+b)/3);
    }

    public void setDuplex(boolean b) 
    {
        // la impresora no soporta duplex, no haremos nada
    }

    public void setFont(Font f) 
    {
        // transformaríamos esta fuente a un número de fuente conocido por la vieja
        // impresora
        if (f.getName().equals("Arial"))
            vieja.setFontNumber(1);
        if (f.getName().equals("Times")) 
            vieja.setFontNumber(2);
        //........
    }

}
//............... lo mismo pero utilizando vieja .............
