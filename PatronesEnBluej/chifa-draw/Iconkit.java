
/*
 * @(#)Iconkit.java 5.1
 *
 */
//package CH.ifa.draw.util;
import java.awt.*;
import java.awt.image.ImageProducer;
import java.util.*;
/**
 * Clase IconKit
La clase IconKit soporta la compartición de imágenes. Mantiene un mapa de nombres de
imagen y sus correspondiente imágenes. IconKit también soporta la carga de una colección de
imágenes de un modo sincronizado. La resolución de un nombre de la ruta (path) para una
imagen se delega al DrawingEditor.
Patrones de diseño
Singleton El IconKit es un singleton.
Guía de construcción de software en Java con patrones de diseño
Francisco Javier Martínez Juan Página 413
Se encuentra en el fichero IconKit.java y su contenido es el siguiente:
 */
public class Iconkit
{
    private Hashtable fMap;
    private Vector fRegisteredImages;
    private Component fComponent;
    private final static int ID = 123;
    private static Iconkit fgIconkit = null;
    private static boolean fgDebug = false;
    /**
     * Constructs an Iconkit that uses the given editor to
     * resolve image path names.
     */
    public Iconkit(Component component)
    {
        fMap = new Hashtable(53);
        fRegisteredImages = new Vector(10);
        fComponent = component;
        fgIconkit = this;
    }

    /**
     * Gets the single instance
     */
    public static Iconkit instance() 
    {
        return fgIconkit;
    }

    /**
     * Loads all registered images.
    Guía de construcción de software en Java con patrones de diseño
    Francisco Javier Martínez Juan Página 414
     * @see #registerImage
     */
    public void loadRegisteredImages(Component component)
    {
        if (fRegisteredImages.size() == 0)
            return;
        MediaTracker tracker = new MediaTracker(component);
        // register images with MediaTracker
        Enumeration k = fRegisteredImages.elements();
        while (k.hasMoreElements()) {
            String fileName = (String) k.nextElement();
            if (basicGetImage(fileName) == null) {
                tracker.addImage(loadImage(fileName), ID);
            }
        }
        fRegisteredImages.removeAllElements();
        // block until all images are loaded
        try {
            tracker.waitForAll();
        } catch (Exception e) { }
    }

    /**
     * Registers an image that is then loaded together with
     * the other registered images by loadRegisteredImages.
     * @see #loadRegisteredImages
     */
    public void registerImage(String fileName) {
        fRegisteredImages.addElement(fileName);
    }

    /**
     * Registers and loads an image.
     */
    public Image registerAndLoadImage(Component component, String
    fileName) {
        registerImage(fileName);
        loadRegisteredImages(component);
        return getImage(fileName);
    }

    /**
     * Loads an image with the given name.
     */
    public Image loadImage(String filename) {
        if (fMap.containsKey(filename))
            return (Image) fMap.get(filename);
        Image image = loadImageResource(filename);
        if (image != null)
            fMap.put(filename, image);
        return image;
    }

    public Image loadImageResource(String resourcename) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        try {

            java.net.URL url = getClass().getResource(resourcename);
            if (fgDebug)
                System.out.println(resourcename);
            return toolkit.createImage((ImageProducer)
                url.getContent());
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Gets the image with the given name. If the image
     * can't be found it tries it again after loading
     * all the registered images.
     */
    public Image getImage(String filename) {
        Image image = basicGetImage(filename);
        if (image != null)
            return image;
        // load registered images and try again
        loadRegisteredImages(fComponent);
        // try again
        return basicGetImage(filename);
    }

    private Image basicGetImage(String filename) {
        if (fMap.containsKey(filename))
            return (Image) fMap.get(filename);
        return null;
    }
}