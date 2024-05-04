package cr.proyecto.poo;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static cr.proyecto.poo.ConjuntosFichas.getG1;
import static cr.proyecto.poo.ConjuntosFichas.getG2;
import static cr.proyecto.poo.ConjuntosFichas.getG3;
import static cr.proyecto.poo.ConjuntosFichas.getG4;

//clase GeneradorGrupoEstudio, acá se llena la lista GE basándose en probabilidades.
public class GeneradorGrupoEstudio {
    //se crea la lista GE.
    private static List<Ficha> GE = new ArrayList<>();

    //método para la probabilidad del 50%
    private static boolean probabilidad50() {
        Random rand = new Random(); // se crea un objeto de tipo 'Random'
        for (int i = 0; i < 1; i++) {
            int numero = rand.nextInt(2) + 1; // se genera un número aleatorio del 1 al 2
            if (numero == 2) {
                return true; // si el número generado es 2, se retorna 'true'
            }
        }
        return false; // sino, se retorna 'false'
    }

    //método para la probabilidad del 25%
    private static boolean probabilidad25(){
        Random rand = new Random(); // se crea un objeto de tipo 'Random'
        for (int i = 0; i < 1; i++) {
            int numero = rand.nextInt(16) + 1; // se genera un número aleatorio del 1 al 16
            if (numero<5) { // si el número generado es menor que 5, se retorna 'true'
                return true;
            }
        }
        return false; // sino, se retorna 'false'
    }

    //método para la probabilidad del 10%
    private static boolean probabilidad10(){
        Random rand = new Random(); // se crea un objeto de tipo 'Random'
        for (int i = 0; i < 1; i++) {
            int numero = rand.nextInt(10) + 1; // se genera un número aleatorio del 1 al 10
            if (numero==1) { // si el número generado fuese igual a 1, se retorna 'true'
                return true;
            }
        }
        return false; // sino, se retorna 'false'
    }


    //método para seleccionar las flashcard que pertenecen a G1
    public static void seleccionarFichaG1(){
        List<Ficha> G1 = getG1(); // se obtiene la lista G1
        GE.addAll(G1); // se agregan todas las flashcards que estén en G1 a GE, ya que hay un 100% de probabilidad que las flashcard de G1 estén en GE

    }

    //método para seleccionar las flashcard que pertenecen a G2
    private static void seleccionarFichaG2(){
        List<Ficha> G2 = getG2(); // se obtiene la lista G2

        for(Ficha ficha : G2) { // por cada flashcard en G2, se llama al método 'probabilidad50'
            if (probabilidad50()) { // si el método 'probabilidad50' retorna 'true'
                GE.add(ficha); // se agrega la flashcard a GE
            }
        }
    }

    //método para seleccionar las flashcard que pertenecen a G3
    private static void seleccionarFichaG3(){
        List<Ficha> G3 = getG3(); // se obtiene la lista G3

        for(Ficha ficha : G3) { // por cada flashcard en G3, se llama al método 'probabilidad25'
            if (probabilidad25()) { // si el método 'probabilidad25' retorna 'true'
                GE.add(ficha); // se agrega la flashcard a GE
            }
        }
    }

    //método para seleccionar las flashcard que pertenecen a G4
    private static void seleccionarFichaG4(){
        List<Ficha> G4 = getG4(); // se obtiene la lista G4

        for (Ficha ficha : G4) { // por cada flashcard en G4, se llama al método 'probabilidad10'
            if (probabilidad10()) { // si el método 'probabilidad10' retorna 'true'
                GE.add(ficha); // se agrega la flashcard a GE
            }
        }
    }

    //método el cual llena la lista GE, llamando a todos los métodos que usan probabilidades.
    public static void llenarGEprobabilidades(){
        seleccionarFichaG1();
        seleccionarFichaG2();
        seleccionarFichaG3();
        seleccionarFichaG4();
    }

    //se desordena la lista GE
    public static void desordenarGE(){
        Collections.shuffle(GE);
    }

    //getter de la lista GE
    public static List<Ficha> getGE() {
        return GE;
    }
}