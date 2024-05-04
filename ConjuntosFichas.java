package cr.proyecto.poo;

import java.util.List;
import java.util.ArrayList;

import static cr.proyecto.poo.LectorDeArchivos.getListaGeneral;

//clase ConjuntoFichas, en donde se crean las listas G1,G2, G3 y G4.
public class ConjuntosFichas {

    private static List<Ficha> G1 = new ArrayList<>(); // Lista en donde se guardan las flashcards de G1.
    private static List<Ficha> G2 = new ArrayList<>(); // Lista en donde se guardan las flashcards de G2.
    private static List<Ficha> G3 = new ArrayList<>(); // Lista en donde se guardan las flashcards de G3.
    private static List<Ficha> G4 = new ArrayList<>(); // Lista en donde se guardan las flashcards de G4.

    //método que lo que hace es llenar G1 con todas las flashcards que tenga GE.
    public static void llenarG1() {
        //se obtiene la ListaGeneral de flashcards.
        List<Ficha> listaGeneralDeFichas = getListaGeneral();
        // se mueven los elementos de ListaGeneral a G1
        G1.addAll(listaGeneralDeFichas);

        // y se limpia la ListaGeneral
        listaGeneralDeFichas.clear();

    }

    //getter de la lista G1
    public static List<Ficha> getG1() {
        return G1;
    }

    //getter de la lista G2
    public static List<Ficha> getG2() {
        return G2;
    }

    //getter de la lista G3
    public static List<Ficha> getG3() {
        return G3;
    }

    //getter de la lista G4
    public static List<Ficha> getG4() {
        return G4;
    }
}
