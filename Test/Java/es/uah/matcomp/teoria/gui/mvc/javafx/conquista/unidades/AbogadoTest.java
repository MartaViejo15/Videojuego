package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbogadoTest {

    @Test
    void evolucionar() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.evolucionar();
    }
}