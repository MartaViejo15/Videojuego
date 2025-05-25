package es.uah.matcomp.teoria.gui.mvc.javafx.conquista.tablero;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Arista {
    private int DificultadDeMovimiento;
    private Casilla origen;
    private Casilla destino;

    public Arista() {
        this.DificultadDeMovimiento = 1;
        this.origen = null;
        this.destino = null;
    }
    public Arista(int Dificultad, Casilla origen, Casilla destino) {
        this.DificultadDeMovimiento = Dificultad;
        this.origen = origen;
        this.destino = destino;
    }

    public int getDificultadDeMovimiento() {
        return DificultadDeMovimiento;
    }

    public void setDificultadDeMovimiento(int dificultadDeMovimiento) {
        DificultadDeMovimiento = dificultadDeMovimiento;
    }

    public Casilla getOrigen() {
        return origen;
    }
    public Casilla getDestino() {
        return destino;
    }
    public void setOrigen(Casilla origen) {
        this.origen = origen;
    }
    public void setDestino(Casilla destino) {
        this.destino = destino;
    }
}
