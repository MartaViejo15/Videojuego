package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;

public class Camino {
    private Lista<Casilla> camino;
    private int coste;

    public Camino(Lista<Casilla> camino, int coste) {
        this.camino = camino;
        this.coste = coste;
    }

    public Lista<Casilla> getCamino() {
        return camino;
    }
    public int getCoste() {
        return coste;
    }
}
