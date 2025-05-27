package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.unidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoEspecificoTest {

    @Test
    void getNombre() {
        ElementoEspecifico elemento = new ElementoEspecifico("Espada de Fuego", 10, 5, 3, 2, 1);
        assertEquals("Espada de Fuego", elemento.getNombre());
    }

    @Test
    void getHP() {
        ElementoEspecifico elemento = new ElementoEspecifico("Espada", 10, 0, 0, 0, 0);
        assertEquals(10, elemento.getHP());
    }

    @Test
    void getAtaque() {
        ElementoEspecifico elemento = new ElementoEspecifico("Espada", 0, 5, 0, 0, 0);
        assertEquals(5, elemento.getAtaque());
    }

    @Test
    void getDefensa() {
        ElementoEspecifico elemento = new ElementoEspecifico("Escudo", 0, 0, 8, 0, 0);
        assertEquals(8, elemento.getDefensa());

    }

    @Test
    void getRango_movimiento() {
        ElementoEspecifico elemento = new ElementoEspecifico("Botas", 0, 0, 0, 3, 0);
        assertEquals(3, elemento.getRango_movimiento());

    }

    @Test
    void getRango_ataque() {
        ElementoEspecifico elemento = new ElementoEspecifico("Arco", 0, 0, 0, 0, 4);
        assertEquals(4, elemento.getRango_ataque());
    }

    @Test
    void uso() {
        ElementoEspecifico elemento1 = new ElementoEspecifico("Objeto", 0, 0, 0, 0, 0);
        assertFalse(elemento1.uso());
    }

    @Test
    void setUso() {
        ElementoEspecifico elemento1 = new ElementoEspecifico("Objeto", 0, 0, 0, 0, 0);
        elemento1.setUso(true);
        assertTrue(elemento1.uso());

        ElementoEspecifico elemento2 = new ElementoEspecifico("Objeto", 0, 0, 0, 0, 0);
        elemento2.setUso(true);  // Primero lo activamos
        elemento2.setUso(false); // Luego lo desactivamos
        assertFalse(elemento2.uso());

    }
}