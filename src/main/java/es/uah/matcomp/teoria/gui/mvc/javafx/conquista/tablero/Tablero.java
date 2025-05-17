package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Lista;

public class Tablero {
    private Lista<Casilla> casillas;
    private Lista<Arista> aristas;

    public Tablero() {
        this.casillas = new Lista<>();
        this.aristas = new Lista<>();
    }

    public void addCasilla(int x, int y) {
        this.casillas.add(new Casilla(x, y));
    }
    public void addArista(int dif_mov, Casilla origen, Casilla destino) {
        Arista arista = new Arista(dif_mov, origen, destino);
        arista.getOrigen().getSalida().add(arista);
        arista.getDestino().getEntrada().add(arista);
        aristas.add(arista);
    }

    public Lista<Casilla> getCasillas() {
        return casillas;
    }
    public Lista<Arista> getAristas() {
        return aristas;
    }
}
