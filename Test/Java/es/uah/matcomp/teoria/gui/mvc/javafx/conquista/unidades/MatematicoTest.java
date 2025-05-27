package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatematicoTest {

    @Test
    void evolucionar() {
        Matematico Matematico = new Matematico("Matematico", false);
        Matematico.evolucionar();
    }
}