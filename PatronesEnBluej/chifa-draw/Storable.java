/**
Interface Storable
Interface que es utilizado por StorableInput y StorableOutput para guardar y recuperar
objetos. Los objetos que implementan este interface y que son recuperados por StorableInput
tienen que proporcionar un constructor por defecto sin argumentos.
Se encuentra en el fichero Storable.java y su contenido es el siguiente:
*/
/*
* @(#)Storable.java 5.1
*
*/

//package CH.ifa.draw.util;
import java.io.*;
/**
* Interface that is used by StorableInput and StorableOutput
* to flatten and resurrect objects. Objects that implement
* this interface and that are resurrected by StorableInput
* have to provide a default constructor with no arguments.
*
* @see StorableInput
* @see StorableOutput
*/
public interface Storable {
/**
* Writes the object to the StorableOutput.
*/
public void write(StorableOutput dw);
/**
* Reads the object from the StorableInput.
*/
public void read(StorableInput dr) throws IOException;
}