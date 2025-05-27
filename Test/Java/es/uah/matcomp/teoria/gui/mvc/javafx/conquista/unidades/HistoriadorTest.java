package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoriadorTest {

    @Test
    void evolucionar() {
        Historiador Historiador = new Historiador("Historiador", false);
        Historiador.evolucionar();
    }
}