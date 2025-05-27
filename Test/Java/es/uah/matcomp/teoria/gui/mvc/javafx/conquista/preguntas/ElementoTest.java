package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    Elemento<Integer> e = new Elemento<>(6);
    Lista<Integer> lista = new Lista<>();

    @Test
    void getDato() {
        e.getDato();
    }

    @Test
    void setDato() {
        e.setDato(7);
    }

    @Test
    void getSiguiente() {
        lista.add(1);
        lista.add(2);
        e.getSiguiente();
    }

    @Test
    void setSiguiente() {
        lista.add(1);
        Elemento<Integer> elem1= new Elemento<>(6);
        e.setSiguiente(elem1);
    }

}
}