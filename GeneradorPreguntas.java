package cr.proyecto.poo;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;

import static cr.proyecto.poo.ConjuntosFichas.getG1;
import static cr.proyecto.poo.ConjuntosFichas.getG2;
import static cr.proyecto.poo.ConjuntosFichas.getG3;
import static cr.proyecto.poo.ConjuntosFichas.getG4;
import static cr.proyecto.poo.GeneradorGrupoEstudio.*;
import static cr.proyecto.poo.LectorDeArchivos.*;


public class GeneradorPreguntas{
    // se obtienen las listas GE,G1,G2,G3 Y G4.
    public static List<Ficha> GE = getGE();
    public static List<Ficha> G1 = getG1();
    public static List<Ficha> G2 = getG2();
    public static List<Ficha> G3 = getG3();
    public static List<Ficha> G4 = getG4();
    //método en donde se desarrolla toda la lógica del juego
    public static void Memotec() {
        int estudiadas = 0; // se inicializa la variable 'estudiadas' en 0
        int restantes = GE.size(); // se inicializa la variable 'restantes' como el lenght de la lista GE
        while (true) { // mientras sea 'true'
            for (Ficha ficha : GE) { // por cada flashcard que exista en la lista GE, se realiza lo siguiente
                String opcion = JOptionPane.showInputDialog(null, // se le pide un input al usuario
                                "         -._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._      \n" +
                                "                                                                                                                                                               \n" +
                                "                                                               Estudiando: " + getRutaArchivo() + "                                                                               \n" +
                                "                                     Ingrese 'terminar' en cualquier momento, para finalizar la sesión de estudio           \n" +
                                "                                                    Presiona 'cancel' para terminar la ejecución del programa                            \n " +
                                "                                                                                                                                                              \n" +
                                "                                             G1                  G2                  G3                  G4                                                             \n" +
                                "                                                                                                                                                               \n" +
                                "                                          " + G1.size() + " fichas          " + "\t\t\t" + G2.size() + " fichas         " + "\t\t\t" + G3.size() + " fichas          " + "\t\t\t" + G4.size() + " fichas                                                     \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                                                                                                             \n" +
                                "                                                                        " + ficha.frente + "                                                                                                   \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                Para ver reverso ingresa 'V'                                                                   \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                 Sesion Actual: " + GE.size() + "                                                                                    \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                    Estudiadas: " + estudiadas + "                                                                                       \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                                                                                                              \n" +
                                "                                                                    Restantes: " + restantes + "                                                                                         \n" +
                                "          -._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-._.-=-      \n");

                if(opcion == null){ // si este input 'opcion' es nulo
                    System.exit(0); // se termina la ejecución del programa
                }
                opcion = opcion.toLowerCase(); // se convierte el input 'opcion' en minúsculas
                if (Objects.equals(opcion, "terminar")) { // si el input 'opcion' es igual a 'terminar'
                    JOptionPane.showMessageDialog(null, "Saliendo de la sesión de estudio...", ":)", JOptionPane.INFORMATION_MESSAGE); // se le anuncia al usuario que se está saliendo
                    break;
                }

                if (Objects.equals(opcion, "v")) { // si el input 'opcion' es igual a 'v'
                    JOptionPane.showMessageDialog(null, ficha.reverso, "Reverso", JOptionPane.INFORMATION_MESSAGE); //se muestra el reverso de la flashcard
                    estudiadas++; // se le suma 1 a las fichas estudiadas
                    restantes--; // se le resta 1 a las fichas restantes
                    String bienMal = JOptionPane.showInputDialog(null, "Ingrese 'bien' si la atinaste, sino ingrese 'mal'\t"); // se muestra en pantalla
                    bienMal = bienMal.toLowerCase(); // se convierte 'bienMal' a minúsculas
                    if (Objects.equals(bienMal, "terminar")) { // si 'bienMal' es igual que 'terminar'
                        JOptionPane.showMessageDialog(null, "Saliendo de la sesión de estudio...", ":)", JOptionPane.INFORMATION_MESSAGE); // se le anuncia al usuario que se está saliendo
                        break;
                    }

                    if(bienMal == null){ // si 'bienMal' es igual a nulo
                        System.exit(0); // se termina la ejecución del programa
                    }

                    if (Objects.equals(bienMal, "bien")) { // si 'bienMal' es igual a 'bien'
                        respuestaBuena(ficha); // se llama al método 'respuestaBuena'
                    }

                    if (Objects.equals(bienMal, "mal")) { // si 'bienMal' es igual a 'mal'
                        respuestaMala(G1,ficha); // se llama al método 'respuestaMala'
                        respuestaMala(G2,ficha); // se llama al método 'respuestaMala'
                        respuestaMala(G3,ficha); // se llama al método 'respuestaMala'
                        respuestaMala(G4,ficha); // se llama al método 'respuestaMala'
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Opción no valida, ingrese un dato válido", "NO VÁLIDO", JOptionPane.WARNING_MESSAGE);} // se muestra en pantalla
            }
            GE.clear(); // se eliminan los elementos de GE
            String siOno = JOptionPane.showInputDialog(null, "¿Deseas iniciar otra sesión de estudio con el mismo grupo de fichas o con otro?\nEscriba 'diferente' o 'mismo'", "Mensaje", JOptionPane.QUESTION_MESSAGE); // se muestra en pantalla, recibe un input
            siOno = siOno.toLowerCase(); // se convierte en minúsculas el input 'siOno'
            if(Objects.equals(siOno,"mismo")){ // si 'siOno' es igual a 'mismo'
                llenarGEprobabilidades(); //se llama el método 'llenarGEprobabilidades'
                desordenarGE(); // se desordena GE
                estudiadas=0; // se reestablece 'estudiadas' en 0
                restantes = GE.size(); // se reestablece 'restantes' como el lenght de GE
                if(GE.isEmpty()){ // si GE estuviera vacía
                    llenarGEprobabilidades(); // se vuelve a llamar 'llenarGEprobabilidades'
                    desordenarGE(); // se desordena GE
                    estudiadas=0; // se reestablece 'estudiadas' en 0
                    restantes = GE.size(); // se reestablece 'restantes' como el lenght de GE
                }
            }
            else if (Objects.equals(siOno, "diferente")) { // si 'siOno' es igual a 'diferente'
                diferenteConjuntoFichas(); // se llama al método 'diferenteConjuntoFichas'

                return;
            }
            else{
                JOptionPane.showMessageDialog(null, "Opción no valida, ingrese un dato válido", "NO VÁLIDO", JOptionPane.WARNING_MESSAGE); // se muestra en pantalla
            }
        }
    }

    //método para imprimir una imagen en una ventana
    private static void imprimirImagenRespuestaBuena(){
        String rutaImagen = "duke.jpeg"; // el nombre de la imagen
        ImageIcon imagentemp = new ImageIcon(rutaImagen); // se crea un objeto de tipo 'ImageIcon'
        Image imagenEscalada = imagentemp.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); // se ajusta la imagen, para que no sea tan grande
        ImageIcon imagen = new ImageIcon(imagenEscalada); // se crea un objeto de tipo 'ImageIcon' de la imagen con el tamaño ideal
        JOptionPane.showMessageDialog(null, imagen, "¡Qué bien :)!", JOptionPane.INFORMATION_MESSAGE); // se muestra en pantalla
    }
    //método para imprimir una imagen en una ventana
    private static void imprimirImagenRespuestaMala(){
        String rutaImagen = "dukeEnojado.png"; // el nombre de la imagen
        ImageIcon imagentemp = new ImageIcon(rutaImagen); // se crea un objeto de tipo 'ImageIcon'
        Image imagenEscalada = imagentemp.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); // se ajusta la imagen, para que no sea tan grande
        ImageIcon imagen = new ImageIcon(imagenEscalada); // se crea un objeto de tipo 'ImageIcon' de la imagen con el tamaño ideal
        JOptionPane.showMessageDialog(null, imagen, "¡Qué mal :(!", JOptionPane.ERROR_MESSAGE); // se muestra en pantalla
    }

    //método para cuando el usuario tenga la respuesta correcta
    private static void respuestaBuena(Ficha ficha){
        if (G1.contains(ficha)) { // se verifica que la ficha actual esté en G1
            imprimirImagenRespuestaBuena();// se muestra en pantalla
            G1.remove(ficha); // se elimina la ficha de G1
            G2.add(ficha);// se mueve la ficha a G2
        } else if (G2.contains(ficha)) { // se verifica que la ficha actual esté en G2
            imprimirImagenRespuestaBuena();// se muestra en pantalla
            G2.remove(ficha); // se elimina la ficha de G2
            G3.add(ficha); // se mueve la ficha a G3
        } else if (G3.contains(ficha)) { // se verifica que la ficha actual esté en G3
            imprimirImagenRespuestaBuena();// se muestra en pantalla
            G3.remove(ficha); // se elimina la ficha de G3
            G4.add(ficha); // se mueve la ficha a G4
        }
    }


    //método para cuando el usuario tenga la respuesta incorrecta
    private static void respuestaMala(List<Ficha> lista, Ficha ficha){
        if(lista.contains(ficha)){ // se verifica que la ficha actual esté en la lista que se le pasa como parámetro
            imprimirImagenRespuestaMala(); // se muestra en pantalla
            lista.remove(ficha); // se elimina la ficha de la lista
            G1.add(ficha); // se mueve la ficha a G1
        }
    }

    //método para eliminar todos los elementos de todas las listas
    private static void limpiarListas(){
        G1.clear();
        G2.clear();
        G3.clear();
        G4.clear();
        GE.clear();
    }
    // métedo para cuando el usuario desee jugar con otro conjunto de fichas
    private static void diferenteConjuntoFichas(){
        limpiarListas(); // se limpian las listas
        leerArchivo(); // se lee el otro archivo
        ConjuntosFichas.llenarG1(); // se llama el método 'llenarG1'
        GeneradorGrupoEstudio.seleccionarFichaG1(); // se llama el método 'seleccionarFichaG1'
        GeneradorGrupoEstudio.desordenarGE(); // se llama el método 'desordenarGE'
        Memotec(); //se llama al método 'Memotec'
    }

}
