package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

public class Arista {
    private int DificultadDeMovimiento;
    private Casilla origen;
    private Casilla destino;

    public Arista(int Dificultad, Casilla origen, Casilla destino) {
        this.DificultadDeMovimiento = Dificultad;
        this.origen = origen;
        this.destino = destino;
    }

    public int getDificultadDeMovimiento() {
        return DificultadDeMovimiento;
    }
    public Casilla getOrigen() {
        return origen;
    }
    public Casilla getDestino() {
        return destino;
    }
}
