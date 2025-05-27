package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnidadTest {

    @Test
    void evolucionar() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.evolucionar();
    }

    @Test
    void usarElementoEspecifico() {
        Abogado abogado = new Abogado("abogado0", true);
        abogado.usarElementoEspecifico(abogado.getElementoEspecifico1());
        abogado.usarElementoEspecifico(abogado.getElementoEspecifico1());
        abogado.usarElementoEspecifico(abogado.getElementoEspecifico2());
        abogado.usarElementoEspecifico(abogado.getElementoEspecifico2());
        abogado.usarElementoEspecifico(null);
    }

    @Test
    void setHP() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setHP(10);
    }

    @Test
    void getId() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setId("123");
        abogado.getId();
    }

    @Test
    void setId() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setId("123");
    }

    @Test
    void getNombre() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.getNombre();
    }

    @Test
    void setNombre() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setNombre("abogado5");
    }

    @Test
    void getHP() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setHP(50);
        abogado.getHP();
    }

    @Test
    void testSetHP() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setHP(50);
    }

    @Test
    void getAtaque() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setAtaque(20);
        abogado.getId();
    }

    @Test
    void setAtaque() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setAtaque(20);
    }

    @Test
    void getDefensa() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setDefensa(20);
        abogado.getDefensa();
    }

    @Test
    void setDefensa() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setDefensa(20);
    }

    @Test
    void getRango_Movimiento() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setRango_Movimiento(5);
        abogado.getRango_Movimiento();
    }

    @Test
    void setRango_Movimiento() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setRango_Movimiento(5);
    }

    @Test
    void getRango_Ataque() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setRango_Ataque(3);
        abogado.getRango_Ataque();

    }

    @Test
    void setRango_Ataque() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setRango_Ataque(3);
    }

    @Test
    void isProfe() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.isProfe();
    }

    @Test
    void setProfe() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setProfe(true);
    }

    @Test
    void setElementoEspecifico1() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setElementoEspecifico1(new ElementoEspecifico("Espada", 10, 5, 2, 1, 1));
    }

    @Test
    void getElementoEspecifico1() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setElementoEspecifico1(new ElementoEspecifico("Espada", 10, 5, 2, 1, 1));
        abogado.getElementoEspecifico1();
    }

    @Test
    void setElementoEspecifico2() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setElementoEspecifico2(new ElementoEspecifico("Espada", 10, 5, 2, 1, 1));
    }

    @Test
    void getElementoEspecifico2() {
        Abogado abogado = new Abogado("abogado0", false);
        abogado.setElementoEspecifico2(new ElementoEspecifico("Espada", 10, 5, 2, 1, 1));
        abogado.getElementoEspecifico2();
    }
}