package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;

public class Camino {
    private Lista<Casilla> camino;
    private int coste;

    public Camino() {
        camino = new Lista<>();
        coste = 0;
    }
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
    public void setCamino(Lista<Casilla> camino) {
        this.camino = camino;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }
}
