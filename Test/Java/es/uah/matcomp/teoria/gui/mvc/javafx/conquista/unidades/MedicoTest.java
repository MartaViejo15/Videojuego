package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void evolucionar() {
        Medico Medico = new Medico("Medico", false);
        Medico.evolucionar();
    }
}