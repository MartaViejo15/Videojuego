package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import es.uah.matcomp.teoria.gui.mvc.javafx.conquista.preguntas.Elemento;
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
    public void cambiarDif_mov(Casilla casilla, int dif_mov) {
        Elemento<Arista> aux = aristas.getPrimero();
        if(aux.getDato().getDestino() == casilla) {
            aux.getDato().setDificultadDeMovimiento(dif_mov);
        }
        while(aux.getSiguiente() != null) {
            if(aux.getSiguiente().getDato().getDestino() == casilla) {
                aux.getSiguiente().getDato().setDificultadDeMovimiento(dif_mov);
            }
            aux = aux.getSiguiente();
        }
    }

    public Casilla getCasilla(int x, int y) {
        Elemento<Casilla> aux = casillas.getPrimero();
        if(aux.getDato().getX() == x && aux.getDato().getY() == y) {
            return aux.getDato();
        }
        while (aux.getSiguiente() != null) {
            if(aux.getSiguiente().getDato().getX() == x && aux.getSiguiente().getDato().getY() == y) {
                return aux.getSiguiente().getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public Lista<Casilla> getCasillas() {
        return casillas;
    }
    public Lista<Arista> getAristas() {
        return aristas;
    }
}
