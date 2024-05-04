package cr.proyecto.poo;

import static cr.proyecto.poo.LectorDeArchivos.leerArchivo;
import static cr.proyecto.poo.LectorDeArchivos.leerCarpeta;

public class Main {
    //método que llama a todas las clases para lograr jugar 'Memotec' exitosamente
    public static void jugarMemotec(){
        leerCarpeta();
        leerArchivo();
        ConjuntosFichas.llenarG1();
        GeneradorGrupoEstudio.seleccionarFichaG1();
        GeneradorGrupoEstudio.desordenarGE();
        GeneradorPreguntas.Memotec();
    }
    //main
    public static void main(String[] args){jugarMemotec();}
}