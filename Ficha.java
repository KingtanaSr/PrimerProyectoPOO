package cr.proyecto.poo;

import java.util.Objects;

//clase Ficha, en donde se establece el frente y el reverso de la flashcard y se hace override de algunos métodos, necesario a la lógica aplicada en la implementación
public class Ficha {
    public String frente; // variable que contiene el frente de la flashcard
    public String reverso; // variable que contiene el reverso de la flashcard

    //constructor de la Ficha, que recibe 'primero' y 'segundo'
    public Ficha(String frente, String reverso) {
        this.frente = frente;
        this.reverso = reverso;
    }

    @Override
    public boolean equals(Object o) { //override del método 'equals' recibe un objeto como parámetro
        if (this == o) return true; // si contienen lo mismo, retorna 'true'
        if (o == null || getClass() != o.getClass()) return false; // si es nulo o si no poseen la misma clase, retorna 'false'
        Ficha other = (Ficha) o; // se crea otro objeto de tipo Ficha
        return Objects.equals(frente, other.frente) &&
                Objects.equals(reverso, other.reverso); // se llama recursivamente para realizar una comparación de los atributos 'primero' y 'segundo'.
    }

    @Override
    public String toString() { //override del método 'toString'
        return "(" + frente + ", " + reverso + ")"; // se establece como se van a recibir las flashcards, para que el programa sepa cuál es 'primero' y 'segundo'.
    }
}