package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuimicoTest {

    @Test
    void evolucionar() {
        Quimico Quimico = new Quimico("Quimico", false);
        Quimico.evolucionar();
    }
}