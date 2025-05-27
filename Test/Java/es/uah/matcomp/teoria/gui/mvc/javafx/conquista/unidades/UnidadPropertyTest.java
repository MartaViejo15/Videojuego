package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.inventario.Multiplicación;
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
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.buscar(new Multiplicación());
        quimico.cogerInventario(new Multiplicación());
        quimico.buscar(new Multiplicación());
    }

    @Test
    void usarInventario() {
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.UsarInventario(new Multiplicación());
        quimico.cogerInventario(new Multiplicación());
        quimico.UsarInventario(new Multiplicación());
    }

    @Test
    void cogerInventario() {
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.cogerInventario(new Multiplicación());
        quimico.cogerInventario(new Multiplicación());
    }

    @Test
    void rollback() {
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.rollback();
    }

    @Test
    void mover() {
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.mover(3,3);
    }

    @Test
    void getPosicionX() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getPosicionX();
    }

    @Test
    void getPosicionY() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getPosicionY();
    }

    @Test
    void getBase() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getBase();
    }

    @Test
    void getHP() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getHP();
    }

    @Test
    void getAtaque() {
        UnidadProperty quimico = new UnidadProperty(new Quimico("quimico", true));
        quimico.getAtaque();
    }

    @Test
    void getDefensa() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getDefensa();
    }

    @Test
    void getRango_Movimiento() {
        UnidadProperty unidad = new UnidadProperty(new Quimico("quimico", true));
        unidad.getRango_Movimiento();
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