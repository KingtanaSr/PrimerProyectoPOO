package cr.proyecto.poo;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


//clase 'LectorDeArchivos' la cual su objetivo es el leer las flashcards de un .txt
public class LectorDeArchivos {
    private static String rutaCarpeta; // variable que almacena la ruta de la carpeta
    private static String rutaArchivo;// variable que almacena la ruta del archivo de extension '.txt'
    private static final List<Ficha> ListaGeneral = new ArrayList<>(); // se crea la lista 'ListaGeneral'

    //método para leer una carpeta
    public static void leerCarpeta() {
        rutaCarpeta = JOptionPane.showInputDialog(null, "Ingrese la ruta de la carpeta: "); // se muestra en pantalla, y recibe un input
        List<String>nombreArchivos = new ArrayList<>(); // se crea una lista de 'String' para almacenar el nombre de los .txt

        File carpeta = new File(rutaCarpeta); // se crea un objeto de tipo 'File' con la ruta de la carpeta proporcionada

        if (carpeta.isDirectory()) { //se revisa si es una carpeta
            File[] archivos = carpeta.listFiles();//  se hace una lista con los archivos que se encuentren en la carpeta
            if (archivos != null) { // se revisa que si hayan archivos, para poder iterar en ellos
                for (File archivo : archivos) { // por cada archivo
                    if (archivo.isFile() && esTxT(archivo.getName())) {// se verifica si el archivo es verdaderamente un archivo y si tiene la extensión ".txt"
                        nombreArchivos.add(archivo.getName() + " "); // se agrega a la lista de 'string' con los nombres de los archivos
                    }
                }
            } else {
                System.out.println("La carpeta no tiene archivos, está vacía."); // por si la carpeta no tenía archivos
            }
        } else {
            System.out.println("La ruta no es una carpeta."); // por si el usuario no ingresó una ruta correcta
        }
        if(!nombreArchivos.isEmpty()){ //para imprimir los archivos, si es diferente de nulo
            JOptionPane.showMessageDialog(null, nombreArchivos, "Archivos a escoger", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //método para leer el archivo .txt
    public static void leerArchivo() {
        rutaArchivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo (con '.txt' al final): "); // se recibe un input y se muestra en pantalla
        rutaArchivo = rutaCarpeta + "/" + rutaArchivo; // para tener la ruta del archivo total, se concatenan los strings

        // se crean las colas para almacenar las tupla
        try (BufferedReader bufer = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea; // variable para almacenar una linea del archivo

            // se lee cada línea del archivo
            while ((linea = bufer.readLine()) != null) { //mientras no sea nulo

                // se divide la línea en dos strings que están separados por un guion
                String[] partes = linea.split("-");
                if (partes.length == 2) {        // asegurarse de que la línea tenga el formato esperado
                    // se eliminan los espacios en blanco al principio y al final de una cadena de caracteres
                    Ficha ficha = new Ficha(partes[0].trim(), partes[1].trim());     // crear una tupla con los dos string
                    ListaGeneral.add(ficha);    // se agregar la tupla a 'ListaGeneral'
                } else {
                    JOptionPane.showMessageDialog(null, "Error: formato incorrecto en la línea \"" + linea + "\". Se ignora esta línea.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE); // para los posibles errores
        }
    }




    //método para verificar que el archivo es .txt
    private static boolean esTxT(String ruta) { //recibe la ruta que ingresó el usuario
        File archivo = new File(ruta); //se crea un objeto tipo 'File'
        String extension = obtenerExtension(archivo); //se establece un string en donde se llama la función 'obtenerExtension'
        return extension != null && extension.equals("txt"); // se retorna 'true' si no es nulo y si la extension es igual a 'txt'.
    }

    //método auxiliar que retorna la extensión de un archivo
    private static String obtenerExtension(File archivo) { // obtiene un archivo como parámetro
        String nombreArchivo= archivo.getName(); // se guarda el nombre del archivo
        int punto = nombreArchivo.lastIndexOf('.'); // se guarda el índice del carácter '.'
        if (punto != -1 && punto < nombreArchivo.length() - 1) { //si el índice del punto es diferente a -1 y es menor al length del nombre del archivo
            return nombreArchivo.substring(punto + 1).toLowerCase(); // se retorna la extensión, en minúsculas
        }
        return null; // sino, se retorna nulo
    }

    //getter de ruta archivo
    public static String getRutaArchivo() {
        File archivo = new File(rutaArchivo);
        return archivo.getName();
    }

    //getter de 'ListaGeneral'
    public static List<Ficha> getListaGeneral() {
        return ListaGeneral;
    }

}


