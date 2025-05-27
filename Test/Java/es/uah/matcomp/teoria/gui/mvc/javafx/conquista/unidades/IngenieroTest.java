package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngenieroTest {

    @Test
    void evolucionar() {
        Ingeniero Ingeniero = new Ingeniero("Ingeniero", false);
        Ingeniero.evolucionar();
    }
}