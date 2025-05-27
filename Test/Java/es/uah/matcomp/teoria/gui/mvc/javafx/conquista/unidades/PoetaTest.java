package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoetaTest {

    @Test
    void evolucionar() {
        Poeta Poeta = new Poeta("Poeta", false);
        Poeta.evolucionar();
    }
}