package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnidadPropertyTest {

    @Test
    void atacar() {
        UnidadProperty atacante = new UnidadProperty(new Quimico("atacante", true));
        UnidadProperty objetivo = new UnidadProperty(new Abogado("Objetivo", false));
        int daño = atacante.atacar(objetivo);
        assertTrue(daño >= 0);
        assertEquals(objetivo.getHP().get(), objetivo.getBase().getHP());
    }

    @Test
    void buscar() {

    }

    @Test
    void usarInventario() {

    }

    @Test
    void cogerInventario() {
    }

    @Test
    void rollback() {
    }

    @Test
    void mover() {
    }

    @Test
    void getPosicionX() {
    }

    @Test
    void getPosicionY() {
    }

    @Test
    void getBase() {
    }

    @Test
    void getHP() {
    }

    @Test
    void getAtaque() {
    }

    @Test
    void getDefensa() {
    }

    @Test
    void getRango_Movimiento() {
    }

    @Test
    void getRango_Ataque() {
    }

    @Test
    void getInventario() {
    }

    @Test
    void getPosicion() {
    }

    @Test
    void setRango_Movimiento() {
    }

    @Test
    void setRango_Ataque() {
    }

    @Test
    void setPosicion() {
    }

    @Test
    void setInventario() {
    }

    @Test
    void setHP() {
    }

    @Test
    void setDefensa() {
    }

    @Test
    void setAtaque() {
    }

    @Test
    void setBase() {
    }
}