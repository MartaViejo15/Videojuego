package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaestroTest {

    @Test
    void evolucionar() {
        Maestro Maestro = new Maestro("Maestro", false);
        Maestro.evolucionar();
    }
}